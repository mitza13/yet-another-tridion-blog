package com.mitza.toolkit.storage;

import com.mitza.toolkit.domain.ComponentMeta;
import com.mitza.toolkit.domain.CustomMeta;
import com.mitza.toolkit.domain.CustomMetaItem;
import com.mitza.toolkit.domain.PageMeta;
import com.mitza.toolkit.query.IndexAbstract;
import com.mitza.toolkit.query.IndexFactory;
import com.mitza.util.TcmUri;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Map;

/**
 * Singleton implementation of handler that updates the file system indexes
 *
 * @author Mihai Cadariu
 * @since 29.11.2015
 */
public enum IndexHandler {

    INSTANCE;
    private final IndexAbstract customMetaStringIndex;
    private final IndexAbstract customMetaDateIndex;
    private final IndexAbstract customMetaNumericIndex;
    private final IndexAbstract schemaIndex;

    private final Logger log = LoggerFactory.getLogger(IndexHandler.class);

    IndexHandler() {
        IndexFactory indexFactory = IndexFactory.INSTANCE;
        customMetaDateIndex = indexFactory.getCustomMetaDateIndex();
        customMetaNumericIndex = indexFactory.getCustomMetaNumericIndex();
        customMetaStringIndex = indexFactory.getCustomMetaStringIndex();
        schemaIndex = indexFactory.getSchemaIndex();
    }

    /**
     * Updates the Schema index performing either a put or remove from the Schema index
     *
     * @param componentMeta ComponentMeta the model to put or remove from Schema index
     * @param publishType   PublishType enumeration representing the action to perform on the index
     */
    public void updateIndexSchema(ComponentMeta componentMeta, PublishType publishType) {
        int schemaId = componentMeta.getSchemaId();
        if (schemaId == 0) {
            return;
        }

        String key = String.format("%d", schemaId);
        TcmUri tcmUri = componentMeta.getTcmUri();
        String value = String.format("%d-%d", tcmUri.getPublicationId(), tcmUri.getItemId());

        switch (publishType) {
            case Deploy:
                if (schemaIndex.put(key, value)) {
                    log.debug("Added component {} to index 'schema'", value);
                }
                break;

            case Undeploy:
                if (schemaIndex.remove(key, value)) {
                    log.debug("Removed component {} from index 'schema'", value);
                }
                break;
        }
    }

    /**
     * Updates the Component CustomMeta performing either a put or remove from the index
     *
     * @param componentMeta ComponentMeta the model to use the CustomMeta from
     * @param publishType   PublishType enumeration representing the action to perform on the index
     */
    public void updateIndexCustomMeta(ComponentMeta componentMeta, PublishType publishType) {
        updateIndexCustomMeta(componentMeta.getCustomMeta(), componentMeta.getTcmUri(), publishType);
    }

    /**
     * Updates the Page CustomMeta performing either a put or remove from the index
     *
     * @param pageMeta    PageMeta the model to use the CustomMeta from
     * @param publishType PublishType enumeration representing the action to perform on the index
     */
    public void updateIndexCustomMeta(PageMeta pageMeta, PublishType publishType) {
        updateIndexCustomMeta(pageMeta.getCustomMeta(), pageMeta.getTcmUri(), publishType);
    }

    private void updateIndexCustomMeta(CustomMeta customMeta, TcmUri tcmUri, PublishType publishType) {
        if (customMeta == null) {
            return;
        }

        String indexValue;
        switch (tcmUri.getType()) {
            case COMPONENT:
                indexValue = String.format("%d-%d", tcmUri.getPublicationId(), tcmUri.getItemId());
                break;

            case PAGE:
                indexValue = String.format("%d-%d-64", tcmUri.getPublicationId(), tcmUri.getItemId());
                break;

            default:
                return;
        }

        for (Map.Entry<String, CustomMetaItem> entry : customMeta.getAll().entrySet()) {
            String name = entry.getKey();
            CustomMetaItem meta = entry.getValue();

            switch (meta.getType()) {
                case DATE:
                    for (Date dateValue : meta.getDateValues()) {
                        String key = customMetaDateIndex.buildKey(name, dateValue.getTime());
                        switch (publishType) {
                            case Deploy:
                                if (customMetaDateIndex.put(key, indexValue)) {
                                    log.debug("Added item {} to index 'custom meta date'", indexValue);
                                }
                                break;

                            case Undeploy:
                                if (customMetaDateIndex.remove(key, indexValue)) {
                                    log.debug("Removed item {} from index 'custom meta date'", indexValue);
                                }
                                break;
                        }
                    }
                    break;

                case NUMERIC:
                    for (float floatValue : meta.getNumericValues()) {
                        String key = customMetaNumericIndex.buildKey(name, floatValue);
                        switch (publishType) {
                            case Deploy:
                                if (customMetaNumericIndex.put(key, indexValue)) {
                                    log.debug("Added item {} to index 'custom meta numeric'", indexValue);
                                }
                                break;

                            case Undeploy:
                                if (customMetaNumericIndex.remove(key, indexValue)) {
                                    log.debug("Removed item {} from index 'custom meta numeric'", indexValue);
                                }
                                break;
                        }
                    }
                    break;

                case STRING:
                    for (String stringValue : meta.getStringValues()) {
                        String key = customMetaStringIndex.buildKey(name, stringValue);
                        switch (publishType) {
                            case Deploy:
                                if (customMetaStringIndex.put(key, indexValue)) {
                                    log.debug("Added item {} to index 'custom meta string'", indexValue);
                                }
                                break;

                            case Undeploy:
                                if (customMetaStringIndex.remove(key, indexValue)) {
                                    log.debug("Removed item {} from index 'custom meta string'", indexValue);
                                }
                                break;
                        }
                    }
                    break;
            }
        }
    }

    enum PublishType {
        Deploy, Undeploy
    }
}
