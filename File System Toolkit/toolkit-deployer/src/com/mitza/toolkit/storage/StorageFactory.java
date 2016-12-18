package com.mitza.toolkit.storage;

import com.mitza.toolkit.domain.ComponentMeta;
import com.mitza.toolkit.domain.ComponentMetaImpl;
import com.mitza.toolkit.domain.ComponentPresentationMeta;
import com.mitza.toolkit.domain.ComponentPresentationMetaImpl;
import com.mitza.toolkit.domain.ItemTypes;
import com.mitza.toolkit.domain.LinkInfo;
import com.mitza.toolkit.domain.PageMeta;
import com.mitza.toolkit.domain.PageMetaImpl;
import com.mitza.toolkit.model.ModelFactory;
import com.mitza.util.TcmUri;
import com.tridion.broker.StorageException;
import com.tridion.dcp.ComponentPresentation;
import com.tridion.dcp.ComponentPresentationFactory;
import com.tridion.meta.ComponentPresentationMetaFactory;
import com.tridion.storage.BinaryVariant;
import com.tridion.storage.StorageManagerFactory;
import com.tridion.storage.StorageTypeMapping;
import com.tridion.storage.dao.BinaryVariantDAO;
import com.tridion.storage.dao.LinkInfoDAO;
import com.tridion.transport.transportpackage.Binary;
import com.tridion.transport.transportpackage.Component;
import com.tridion.transport.transportpackage.Page;
import com.tridion.util.TCMURI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Singleton factory implementation handling persistance for the publish and unpublish actions.
 *
 * @author Mihai Cadariu
 * @since 06.11.2015
 */
public enum StorageFactory {

    INSTANCE;
    private final Map<Integer, ComponentPresentationFactory> cpFactoryCache;
    private final Map<Integer, ComponentPresentationMetaFactory> cpMetaFactoryCache;
    private final ModelFactory modelFactory;
    private final IndexHandler indexHandler;

    private final Logger log = LoggerFactory.getLogger(StorageFactory.class);

    StorageFactory() {
        log.debug("Create new instance");

        cpFactoryCache = new HashMap<>();
        cpMetaFactoryCache = new HashMap<>();
        indexHandler = IndexHandler.INSTANCE;
        modelFactory = ModelFactory.INSTANCE;
    }

    /**
     * Persists a Tridion transport Page deploy to the underlying storage and updates custom meta index accordingly
     *
     * @param page Page the Tridion transport page to deploy
     */
    public void deployPage(Page page) {
        log.info("Deploy page {}", page);

        TCMURI tcmUri = page.getId();
        TcmUri pageUri = new TcmUri(tcmUri.getPublicationId(), tcmUri.getItemId(), ItemTypes.PAGE);

        PageMetaImpl pageMeta = modelFactory.getOrCreateModel(pageUri);
        indexHandler.updateIndexCustomMeta(pageMeta, IndexHandler.PublishType.Undeploy);

        Converter.convert(page, pageMeta);
        storePage(pageMeta);
    }

    /**
     * Persists a Toolkit Page meta to the underlying storage and updates custom meta index accordingly
     *
     * @param pageMeta PageMeta the Toolkit page meta to deploy
     */
    public void storePage(PageMeta pageMeta) {
        log.info("Deploy pageMeta {}", pageMeta);

        modelFactory.updateModel(pageMeta);
        indexHandler.updateIndexCustomMeta(pageMeta, IndexHandler.PublishType.Deploy);
    }

    /**
     * Persists a page undeploy to the underlying storage and updates custom meta index accordingly.
     * Potentially it also undeploys the Component Presentations on the page.
     *
     * @param publicationId int the Publication id of the Page to undeploy
     * @param pageId        int the Page item id to undeploy
     */
    public void undeployPage(int publicationId, int pageId) throws StorageException {
        log.info("Undeploy page {}-{}-64", publicationId, pageId);

        TcmUri pageUri = new TcmUri(publicationId, pageId, ItemTypes.PAGE);
        PageMetaImpl pageMeta = modelFactory.getModel(pageUri);
        if (pageMeta == null) {
            return;
        }

        indexHandler.updateIndexCustomMeta(pageMeta, IndexHandler.PublishType.Undeploy);
        modelFactory.removeModel(pageUri);

        for (ComponentPresentationMeta componentPresentationMeta : pageMeta.getComponentPresentationMetas()) {
            undeployComponent(publicationId, componentPresentationMeta.getComponentId());
        }
    }

    /**
     * Persists a Tridion transport Binary deploy to the underlying storage and updates custom meta index accordingly
     *
     * @param binary Binary the Tridion transport binary to deploy
     */
    public void deployBinary(Binary binary) throws StorageException {
        log.info("Deploy binary {}", binary);

        TCMURI tcmUri = binary.getId();
        int publicationId = tcmUri.getPublicationId();
        int componentId = tcmUri.getItemId();
        TcmUri componentUri = new TcmUri(publicationId, componentId);

        ComponentMetaImpl componentMeta = modelFactory.getOrCreateModel(componentUri);
        componentMeta.setLastPublished(new Date());
        storeBinary(componentMeta);
    }

    /**
     * Persists a Toolkit ComponentMeta representing a Binary to the underlying storage and updates custom meta index
     * accordingly. It also synchronizes the link information and dynamic Component Presentations for this binary.
     *
     * @param componentMeta ComponentMeta the Toolkit binary to deploy
     */
    public void storeBinary(ComponentMeta componentMeta) throws StorageException {
        log.info("Store binary componentMeta {}", componentMeta);

        ComponentMetaImpl componentMetaImpl = (ComponentMetaImpl) componentMeta;
        indexHandler.updateIndexCustomMeta(componentMetaImpl, IndexHandler.PublishType.Undeploy);

        componentMetaImpl.setMultimedia(true);

        synchronizeComponentDcps(componentMetaImpl);
        synchronizeBinaryLinkInfo(componentMetaImpl);

        modelFactory.updateModel(componentMetaImpl);
        indexHandler.updateIndexSchema(componentMetaImpl, IndexHandler.PublishType.Deploy);
        indexHandler.updateIndexCustomMeta(componentMetaImpl, IndexHandler.PublishType.Deploy);
    }

    /**
     * Persists a binary undeploy to the underlying storage.
     * Potentially it also undeploys the Component Presentations.
     *
     * @param publicationId int the Publication id of the Binary to undeploy
     * @param componentId   int the Component item id to undeploy
     * @param variantId     String the binary vartiant to undeploy
     */
    public void undeployBinary(int publicationId, int componentId, String variantId) throws StorageException {
        log.info("Undeploy binary publication:{}, component:{}, variant:{}", new Object[]{publicationId, componentId, variantId});

        TcmUri componentUri = new TcmUri(publicationId, componentId);
        ComponentMetaImpl componentMeta = modelFactory.getModel(componentUri);
        if (componentMeta == null) {
            return;
        }

        synchronizeComponentDcps(componentMeta);
        List<ComponentPresentationMeta> dcpMetas = componentMeta.getDynamicComponentPresentationMetas();
        List<LinkInfo> linkInfos = componentMeta.getLinkInfos();

        if (linkInfos != null) {
            for (Iterator<LinkInfo> iterator = linkInfos.iterator(); iterator.hasNext(); ) {
                LinkInfo linkInfo = iterator.next();
                String linkVariant = linkInfo.getVariant();
                if (linkVariant != null && linkVariant.equals(variantId) || linkVariant == null && variantId == null) {
                    iterator.remove();
                }
            }
        }

        if ((dcpMetas == null || dcpMetas.isEmpty()) && (linkInfos == null || linkInfos.isEmpty())) {
            undeployComponent(componentMeta);
        } else {
            modelFactory.updateModel(componentMeta);
        }
    }

    /**
     * Persists a Tridion transport Component deploy to the underlying storage and updates custom meta index accordingly
     *
     * @param component Component the Tridion transport Component to deploy
     */
    public void deployComponent(Component component) throws StorageException {
        log.info("Deploy component {}", component);

        TCMURI tcmUri = component.getId();
        int publicationId = tcmUri.getPublicationId();
        int componentId = tcmUri.getItemId();
        TcmUri componentUri = new TcmUri(publicationId, componentId);

        ComponentMetaImpl componentMeta = modelFactory.getOrCreateModel(componentUri);
        indexHandler.updateIndexCustomMeta(componentMeta, IndexHandler.PublishType.Undeploy);

        Converter.convert(component, componentMeta);
        storeComponent(componentMeta);
    }

    /**
     * Persists a Toolkit ComponentMeta to the underlying storage and updates schema and custom meta indexes accordingly
     *
     * @param componentMeta ComponentMeta the Toolkit Component meta to deploy
     */
    public void storeComponent(ComponentMeta componentMeta) throws StorageException {
        log.info("Store componentMeta {}", componentMeta);

        ComponentMetaImpl componentMetaImpl = (ComponentMetaImpl) componentMeta;
        synchronizeComponentDcps(componentMetaImpl);
        synchronizeComponentLinkInfos(componentMetaImpl);

        modelFactory.updateModel(componentMetaImpl);
        indexHandler.updateIndexSchema(componentMetaImpl, IndexHandler.PublishType.Deploy);
        indexHandler.updateIndexCustomMeta(componentMetaImpl, IndexHandler.PublishType.Deploy);
    }

    /**
     * Synchronizes all Component Presentations for the given Component and updates the Component to the underlying storage
     *
     * @param publicationId int the Publication id
     * @param componentId   int the Component item id
     * @param templateId    int the Component Template item id
     */
    public void deployComponentPresentation(int publicationId, int componentId, int templateId) {
        Object[] dcpParameters = {publicationId, componentId, templateId};
        log.info("Deploy component presentation {}-{}-{}", dcpParameters);

        TcmUri componentUri = new TcmUri(publicationId, componentId);
        ComponentMetaImpl componentMeta = modelFactory.getOrCreateModel(componentUri);

        synchronizeComponentDcps(componentMeta);

        modelFactory.updateModel(componentMeta);
    }

    /**
     * Synchronizes all Component Presentations for the given Component and updates/removes the Component from the underlying storage
     *
     * @param publicationId int the Publication id
     * @param componentId   int the Component item id
     * @param templateId    int the Component Template item id
     */
    public void undeployComponentPresentation(int publicationId, int componentId, int templateId) throws StorageException {
        log.info("Undeploy component presentation {}-{}-{}", new Object[]{publicationId, componentId, templateId});

        TcmUri componentUri = new TcmUri(publicationId, componentId);
        ComponentMetaImpl componentMeta = modelFactory.getModel(componentUri);
        if (componentMeta == null) {
            return;
        }

        synchronizeComponentDcps(componentMeta);
        List<ComponentPresentationMeta> dcpMetas = componentMeta.getDynamicComponentPresentationMetas();

        if (componentMeta.isMultimedia()) {
            synchronizeBinaryLinkInfo(componentMeta);
        } else {
            synchronizeComponentLinkInfos(componentMeta);
        }
        List<LinkInfo> linkInfos = componentMeta.getLinkInfos();

        if ((dcpMetas == null || dcpMetas.isEmpty()) && (linkInfos == null || linkInfos.isEmpty())) {
            undeployComponent(componentMeta);
        } else {
            modelFactory.updateModel(componentMeta);
        }
    }

    private void undeployComponent(ComponentMeta componentMeta) {
        indexHandler.updateIndexSchema(componentMeta, IndexHandler.PublishType.Undeploy);
        indexHandler.updateIndexCustomMeta(componentMeta, IndexHandler.PublishType.Undeploy);
        modelFactory.removeModel(componentMeta.getTcmUri());
    }

    private void undeployComponent(int publicationId, int componentId) throws StorageException {
        log.debug("Undeploy component {}-{}", publicationId, componentId);

        TcmUri componentUri = new TcmUri(publicationId, componentId);
        ComponentMetaImpl componentMeta = modelFactory.getModel(componentUri);
        if (componentMeta == null) {
            return;
        }

        synchronizeComponentDcps(componentMeta);
        List<ComponentPresentationMeta> dcpMetas = componentMeta.getDynamicComponentPresentationMetas();

        synchronizeComponentLinkInfos(componentMeta);
        List<LinkInfo> linkInfos = componentMeta.getLinkInfos();

        if ((dcpMetas == null || dcpMetas.isEmpty()) && (linkInfos == null || linkInfos.isEmpty())) {
            undeployComponent(componentMeta);
        } else {
            modelFactory.updateModel(componentMeta);
        }
    }

    private void synchronizeBinaryLinkInfo(ComponentMetaImpl componentMeta) throws StorageException {
        TcmUri componentUri = componentMeta.getTcmUri();
        int publicationId = componentUri.getPublicationId();
        int componentId = componentUri.getItemId();

        BinaryVariantDAO binaryVariantDAO = (BinaryVariantDAO) StorageManagerFactory.getDAO(publicationId, StorageTypeMapping.BINARY_VARIANT);
        List<BinaryVariant> binaryVariants = binaryVariantDAO.findByPrimaryKey(publicationId, componentId);
        componentMeta.setLinkInfos(Converter.convertBinaryVariants(binaryVariants));
    }

    private void synchronizeComponentLinkInfos(ComponentMetaImpl componentMeta) throws StorageException {
        TcmUri componentUri = componentMeta.getTcmUri();
        int publicationId = componentUri.getPublicationId();
        int componentId = componentUri.getItemId();

        LinkInfoDAO linkInfoDAO = (LinkInfoDAO) StorageManagerFactory.getDAO(publicationId, StorageTypeMapping.LINK_INFO);
        List<com.tridion.storage.LinkInfo> linkInfos = linkInfoDAO.findByComponent(publicationId, componentId);
        componentMeta.setLinkInfos(Converter.convert(linkInfos));
    }

    private void synchronizeComponentDcps(ComponentMetaImpl componentMeta) {
        TcmUri componentUri = componentMeta.getTcmUri();
        int publicationId = componentUri.getPublicationId();
        int componentId = componentUri.getItemId();

        ComponentPresentationMetaFactory factory = getComponentPresentationMetaFactory(publicationId);
        Collection<com.tridion.meta.ComponentPresentationMeta> dcpMetas = factory.getMetaByComponent(componentUri.toString());
        List<ComponentPresentationMeta> convertMetas = Converter.convert(dcpMetas);
        componentMeta.setDynamicComponentPresentationMetas(convertMetas);

        if (convertMetas != null) {
            for (ComponentPresentationMeta meta : convertMetas) {
                int templateId = meta.getTemplateId();
                ComponentPresentation cp = getComponentPresentation(publicationId, componentId, templateId);

                if (cp == null) {
                    log.warn("Expected DCP {}-{}-{}, but found null DCP",
                            new Object[]{publicationId, componentId, templateId});
                } else {
                    ComponentPresentationMetaImpl metaImpl = (ComponentPresentationMetaImpl) meta;
                    metaImpl.setContent(cp.getContent());
                }
            }
        }
    }

    private ComponentPresentation getComponentPresentation(int publicationId, int componentId, int templateId) {
        ComponentPresentationFactory factory = getComponentPresentationFactory(publicationId);
        return factory.getComponentPresentation(componentId, templateId);
    }

    private ComponentPresentationFactory getComponentPresentationFactory(int publicationId) {
        ComponentPresentationFactory result = cpFactoryCache.get(publicationId);
        if (result == null) {
            result = new ComponentPresentationFactory(publicationId);
            cpFactoryCache.put(publicationId, result);
        }

        return result;
    }

    private ComponentPresentationMetaFactory getComponentPresentationMetaFactory(int publicationId) {
        ComponentPresentationMetaFactory result = cpMetaFactoryCache.get(publicationId);
        if (result == null) {
            result = new ComponentPresentationMetaFactory(publicationId);
            cpMetaFactoryCache.put(publicationId, result);
        }

        return result;
    }
}
