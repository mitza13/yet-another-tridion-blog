package com.mitza.toolkit.storage;

import com.mitza.toolkit.domain.ComponentMetaImpl;
import com.mitza.toolkit.domain.ComponentPresentationMeta;
import com.mitza.toolkit.domain.ComponentPresentationMetaImpl;
import com.mitza.toolkit.domain.CustomMeta;
import com.mitza.toolkit.domain.CustomMetaImpl;
import com.mitza.toolkit.domain.LinkInfo;
import com.mitza.toolkit.domain.LinkInfoImpl;
import com.mitza.toolkit.domain.PageMetaImpl;
import com.tridion.broker.StorageException;
import com.tridion.meta.NameValuePair;
import com.tridion.storage.BinaryVariant;
import com.tridion.transport.transportpackage.Component;
import com.tridion.transport.transportpackage.ComponentPresentationKey;
import com.tridion.transport.transportpackage.Page;
import com.tridion.util.TCMURI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Static helper class that handles conversion between Tridion and Toolkit models
 *
 * @author Mihai Cadariu
 * @since 06.11.2015
 */
public class Converter {

    private static final Logger log = LoggerFactory.getLogger(Converter.class);

    /**
     * Convert Tridion Page model to Toolkit PageMetaImpl model
     *
     * @param from Page the Tridion source model
     * @param to   PageMetaImpl the Toolkit destination model
     */
    public static void convert(Page from, PageMetaImpl to) {
        log.debug("Convert PageMeta from:{} to:{}", from, to);

        com.tridion.meta.PageMeta facade = from.getPageMetaFacade();
        to.setComponentPresentationMetas(convert(from.getComponentPresentationKeys()));
        to.setCustomMeta(convert(facade.getCustomMeta()));
        to.setFilename(facade.getPath());
        to.setLastModified(facade.getModificationDate());
        to.setLastPublished(facade.getLastPublicationDate());
        to.setPageTemplateId(facade.getTemplateId());
        to.setTitle(facade.getTitle());
        to.setUrl(facade.getURLPath());
    }

    /**
     * Convert Tridion PageMeta to Toolkit PageMetaImpl model
     *
     * @param from PageMeta the Tridion source model
     * @param to   PageMetaImpl the Toolkit destination model
     */
    public static void convert(com.tridion.meta.PageMeta from, PageMetaImpl to) throws StorageException {
        log.debug("Convert PageMeta from:{} to:{}", from, to);

        to.setComponentPresentationMetas(convert(from.getComponentPresentationMetas()));
        to.setCustomMeta(convert(from.getCustomMeta()));
        to.setFilename(from.getPath());
        to.setLastModified(from.getModificationDate());
        to.setLastPublished(from.getLastPublicationDate());
        to.setPageTemplateId(from.getTemplateId());
        to.setTitle(from.getTitle());
        to.setUrl(from.getURLPath());
    }

    /**
     * Convert Tridion Component model to Toolkit ComponentMetaImpl model
     *
     * @param from Component the Tridion source model
     * @param to   ComponentMetaImpl the Toolkit destination model
     */
    public static void convert(Component from, ComponentMetaImpl to) {
        log.debug("Convert Component from:{} to:{}", from, to);

        com.tridion.meta.ComponentMeta facade = from.getComponentMetaFacade();
        to.setCustomMeta(convert(facade.getCustomMeta()));
        to.setLastModified(facade.getModificationDate());
        to.setLastPublished(facade.getLastPublicationDate());
        to.setMultimedia(facade.isMultimedia());
        to.setSchemaId(facade.getSchemaId());
        to.setTitle(facade.getTitle());
    }

    /**
     * Convert Tridion Component meta to Toolkit ComponentMetaImpl model
     *
     * @param from ComponentMeta the Tridion source model
     * @param to   ComponentMetaImpl the Toolkit destination model
     */
    public static void convert(com.tridion.meta.ComponentMeta from, ComponentMetaImpl to) {
        log.debug("Convert Component from:{} to:{}", from, to);

        to.setCustomMeta(convert(from.getCustomMeta()));
        to.setLastModified(from.getModificationDate());
        to.setLastPublished(from.getLastPublicationDate());
        to.setMultimedia(from.isMultimedia());
        to.setSchemaId(from.getSchemaId());
        to.setTitle(from.getTitle());
    }

    /**
     * Convert Tridion ComponentPresentation models to Toolkit ComponentPresentationMeta models
     *
     * @param iterator Iterator the Tridion source models iterator
     * @return List of Toolkit ComponentPresentationMeta destination models
     */
    public static List<ComponentPresentationMeta> convert(Iterator<ComponentPresentationKey> iterator) {
        log.debug("Convert ComponentPresentationKeys {}", iterator);

        if (iterator == null || !iterator.hasNext()) {
            return null;
        }

        List<ComponentPresentationMeta> toMetas = new ArrayList<>();
        for (; iterator.hasNext(); ) {
            ComponentPresentationKey from = iterator.next();
            TCMURI componentUri = from.getComponentId();
            toMetas.add(new ComponentPresentationMetaImpl(
                    componentUri.getPublicationId(),
                    componentUri.getItemId(),
                    from.getTemplateId().getItemId(),
                    from.getPriority()));
        }

        return toMetas;
    }

    /**
     * Convert Tridion ComponentPresentationMeta models to Toolkit ComponentPresentationMeta models
     *
     * @param fromMetas Collection of ComponentPresentationMeta the Tridion source models
     * @return List of Toolkit ComponentPresentationMeta destination models
     */
    public static List<ComponentPresentationMeta> convert(Collection<com.tridion.meta.ComponentPresentationMeta> fromMetas) {
        log.debug("Convert ComponentPresentationMetas {}", fromMetas);

        if (fromMetas == null || fromMetas.size() == 0) {
            return null;
        }

        List<ComponentPresentationMeta> toMetas = new ArrayList<>();
        for (com.tridion.meta.ComponentPresentationMeta from : fromMetas) {
            toMetas.add(new ComponentPresentationMetaImpl(
                    from.getPublicationId(),
                    from.getComponentId(),
                    from.getTemplateId(),
                    from.getTemplatePriority()));
        }

        return toMetas;
    }

    /**
     * Convert Tridion LinkInfo models to Toolkit LinkInfo models
     *
     * @param fromInfos List of LinkInfo the Tridion source models
     * @return List of Toolkit LinkInfo destination models
     */
    public static List<LinkInfo> convert(List<com.tridion.storage.LinkInfo> fromInfos) {
        log.debug("Convert LinkInfos {}", fromInfos);

        if (fromInfos == null || fromInfos.size() == 0) {
            return null;
        }

        List<LinkInfo> toInfos = new ArrayList<>();
        for (com.tridion.storage.LinkInfo from : fromInfos) {
            LinkInfoImpl to = new LinkInfoImpl();
            to.setComponent(from.getComponentId());
            to.setPage(from.getPageId());
            to.setPriority(from.getTemplatePriority());
            to.setPublication(from.getPublicationId());
            to.setUrl(from.getUrl());
            toInfos.add(to);
        }

        return toInfos;
    }

    /**
     * Convert Tridion BinartVariant models to Toolkit LinkInfo models
     *
     * @param fromBinaryVariants List of BinaryVariant the Tridion source models
     * @return List of Toolkit LinkInfo destination models
     */
    public static List<LinkInfo> convertBinaryVariants(List<BinaryVariant> fromBinaryVariants) {
        log.debug("Convert BinaryVariant {}", fromBinaryVariants);

        if (fromBinaryVariants == null || fromBinaryVariants.size() == 0) {
            return null;
        }

        List<LinkInfo> toInfos = new ArrayList<>();
        for (BinaryVariant from : fromBinaryVariants) {
            LinkInfoImpl to = new LinkInfoImpl();
            to.setComponent(from.getBinaryId());
            to.setPublication(from.getPublicationId());
            to.setUrl(from.getUrl());
            to.setVariant(from.getVariantId());
            toInfos.add(to);
        }

        return toInfos;
    }

    /**
     * Convert Tridion CustoMeta model to Toolkit CustomMeta model
     *
     * @param from CustomMeta the Tridion source models
     * @return CustomMeta the Toolkit LinkInfo destination models
     */
    public static CustomMeta convert(com.tridion.meta.CustomMeta from) {
        log.debug("Convert CustomMeta {}", from);

        if (from == null || from.isEmpty()) {
            log.debug("CustomMeta is Empty");
            return null;
        }

        CustomMetaImpl to = new CustomMetaImpl();
        for (Map.Entry<String, NameValuePair> entry : from.getNameValues().entrySet()) {
            String name = entry.getKey();
            NameValuePair valuePair = entry.getValue();
            for (Object value : valuePair.getMultipleValues()) {
                switch (valuePair.getMetadataType()) {
                    case DATE:
                        to.add(name, (Date) value);
                        break;

                    case FLOAT:
                        to.add(name, (Float) value);
                        break;

                    default:
                        to.add(name, (String) value);
                        break;
                }
            }
        }

        return to;
    }
}
