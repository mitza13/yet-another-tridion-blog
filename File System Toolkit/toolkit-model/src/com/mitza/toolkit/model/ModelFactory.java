package com.mitza.toolkit.model;

import com.mitza.toolkit.cache.CacheElement;
import com.mitza.toolkit.cache.CacheFactory;
import com.mitza.toolkit.domain.ItemMeta;
import com.mitza.toolkit.provider.ModelProvider;
import com.mitza.toolkit.provider.fs.FileSystemProvider;
import com.mitza.util.TcmUri;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Singleton factory implementation providing CRUD access to Tridion item models and the underlying storage system.
 * Depending on the Toolkit configuration, the storage can be either JSON files on the file system or records in a
 * relational database.
 *
 * @author Mihai Cadariu
 * @since 02.11.2015
 */
public enum ModelFactory {

    INSTANCE;
    private final Logger log = LoggerFactory.getLogger(ModelFactory.class);
    private final CacheFactory cacheFactory;
    private final ModelProvider modelProvider;

    ModelFactory() {
        log.debug("Create new instance");

        modelProvider = FileSystemProvider.INSTANCE;
        log.debug("Using model provider {}", modelProvider);

        cacheFactory = CacheFactory.INSTANCE;
    }

    /**
     * Create or get the model identified by the givem TcmUri. If the model doesn't exist, an new model is created and
     * the only properties that is populated is TcmUri.
     *
     * @param tcmUri TcmUri identifying the model
     * @param <T>    specialization class of ItemMeta (only ComponentMeta and PageMeta are supported)
     * @return the model corresponding to the given TcmUri
     */
    public <T extends ItemMeta> T getOrCreateModel(TcmUri tcmUri) {
        log.debug("Fetch or create model for {}", tcmUri);

        T model;
        String key = cacheFactory.getKey(tcmUri);
        CacheElement<T> cacheElement = cacheFactory.get(key);

        if (cacheElement == null) {
            model = modelProvider.read(tcmUri);
        } else {
            model = cacheElement.getPayload();
        }

        if (model == null) {
            model = modelProvider.create(tcmUri);
            cacheFactory.put(key, model);
            log.debug("Created model {}", model);
        }

        return model;
    }

    /**
     * Get the model identified by the givem TcmUri, or null if the model doesn't exist
     *
     * @param tcmUri TcmUri identifying the model
     * @param <T>    specialization class of ItemMeta (only ComponentMeta and PageMeta are supported)
     * @return the model corresponding to the given TcmUri
     */
    public <T extends ItemMeta> T getModel(TcmUri tcmUri) {
        log.debug("Fetch model {}", tcmUri);

        T model;
        String key = cacheFactory.getKey(tcmUri);
        CacheElement<T> cacheElement = cacheFactory.get(key);

        if (cacheElement == null) {
            model = modelProvider.read(tcmUri);
            if (model != null && model.getLastPublished() == null) {
                model = null;
            }
            cacheFactory.put(key, model);
        } else {
            model = cacheElement.getPayload();
            log.debug("Return model {} from cache", model);
        }

        return model;
    }

    /**
     * Persist the given model to the underlying storage system
     *
     * @param model the model to persist
     * @param <T>   specialization class of ItemMeta (only ComponentMeta and PageMeta are supported)
     */
    public <T extends ItemMeta> void updateModel(T model) {
        log.debug("Update model {}", model);

        TcmUri tcmUri = model.getTcmUri();
        String key = cacheFactory.getKey(tcmUri);
        model = modelProvider.update(model);
        cacheFactory.put(key, model);
    }

    /**
     * Delete the model identified by the given TcmUri from the underlying storage system
     *
     * @param tcmUri TcmUri identifying the model
     * @return boolean true, if the model has been deleted
     */
    public boolean removeModel(TcmUri tcmUri) {
        log.debug("Delete model {}", tcmUri);

        String key = cacheFactory.getKey(tcmUri);
        cacheFactory.remove(key);

        return modelProvider.delete(tcmUri);
    }
}
