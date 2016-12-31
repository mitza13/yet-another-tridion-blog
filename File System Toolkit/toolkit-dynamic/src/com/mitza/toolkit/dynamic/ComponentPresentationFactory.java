package com.mitza.toolkit.dynamic;

import com.mitza.toolkit.domain.ComponentMeta;
import com.mitza.toolkit.domain.ComponentPresentationMeta;
import com.mitza.toolkit.model.ModelFactory;
import com.mitza.util.TcmUri;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Singleton factory implementation that retrieves Dynamic Component Presentations.
 *
 * @author Mihai Cadariu
 * @since 17.11.2015
 */
public enum ComponentPresentationFactory {

    INSTANCE;
    private final Logger log = LoggerFactory.getLogger(ComponentPresentationFactory.class);
    private final ModelFactory modelFactory;

    ComponentPresentationFactory() {
        log.debug("Create new instance");

        modelFactory = ModelFactory.INSTANCE;
    }

    /**
     * Return the Dynamic Component Presentation identified by the given parameters or null, if no such DCP exists.
     *
     * @param publicationId int the Publication id identifying this DCP
     * @param componentId   int the Component item id identifying this DCP
     * @param templateId    int the Component Template item id identifying this DCP
     * @return ComponentPresentationMeta the identified DCP or null, if not found
     */
    public ComponentPresentationMeta getComponentPresentation(int publicationId, int componentId, int templateId) {
        log.debug("Retrieve component presentation {}-{}-{}", new Object[]{publicationId, componentId, templateId});

        TcmUri componentUri = new TcmUri(publicationId, componentId);
        ComponentMeta componentMeta = modelFactory.getModel(componentUri);
        if (componentMeta == null) {
            return null;
        }

        List<ComponentPresentationMeta> dcpMetas = componentMeta.getDynamicComponentPresentationMetas();
        if (dcpMetas == null) {
            return null;
        }

        for (ComponentPresentationMeta meta : dcpMetas) {
            if (meta.getPublicationId() == publicationId && meta.getComponentId() == componentId &&
                    meta.getTemplateId() == templateId) {
                return meta;
            }
        }

        return null;
    }

    /**
     * Return the Dynamic Component Presentation identified by the given parameters or null, if no such DCP exists.
     * Since no Component Template item id is provided, there can be several DCPs on the same Publication and Component ids.
     * This method retrieves the first DCP by comparing the linking priority of the Component Template the DCP is based on.
     * There might several DCPs with the same highest template priority, but only one is returned.
     *
     * @param publicationId int the Publication id identifying this DCP
     * @param componentId   int the Component item id identifying this DCP
     * @return ComponentPresentationMeta the identified DCP or null, if not found
     */
    public ComponentPresentationMeta getComponentPresentationWithHighestPriority(int publicationId, int componentId) {
        log.debug("Retrieve component presentation with highest priority {}-{}", new Object[]{publicationId, componentId});

        TcmUri componentUri = new TcmUri(publicationId, componentId);
        ComponentMeta componentMeta = modelFactory.getModel(componentUri);
        if (componentMeta == null) {
            return null;
        }

        List<ComponentPresentationMeta> dcpMetas = componentMeta.getDynamicComponentPresentationMetas();
        if (dcpMetas == null) {
            return null;
        }

        int maxPriority = 0;
        ComponentPresentationMeta result = null;

        for (ComponentPresentationMeta meta : dcpMetas) {
            if (meta.getPriority() > maxPriority) {
                maxPriority = meta.getPriority();
                result = meta;
            }
        }

        return result;
    }
}
