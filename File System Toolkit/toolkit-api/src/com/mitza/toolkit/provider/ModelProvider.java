package com.mitza.toolkit.provider;

import com.mitza.toolkit.domain.ItemMeta;
import com.mitza.util.TcmUri;

/**
 * Interface defining CRUD operations for model providers. Implementations must adhere to the given method signatures.
 *
 * @author Mihai Cadariu
 * @since 04.02.2016
 */
public interface ModelProvider {

    /**
     * Create and return an empty specialization class of ItemMeta for the given TcmUri
     *
     * @param tcmUri TcmUri identifing the model
     * @param <T>    specialization of ItemMeta
     * @return the newly created empty model
     */
    <T extends ItemMeta> T create(TcmUri tcmUri);

    /**
     * Return a specialization class of ItemMeta by reading it from the storage layer for the given TcmUri
     *
     * @param tcmUri TcmUri identifing the model
     * @param <T>    specialization of ItemMeta
     * @return the newly created empty model
     */
    <T extends ItemMeta> T read(TcmUri tcmUri);

    /**
     * Persist the given model to the underlying storage
     *
     * @param model the model to be persisted
     * @param <T>   specialization of ItemMeta
     * @return the updated model
     */
    <T extends ItemMeta> T update(T model);

    /**
     * Delete the model identified by the given TcmUri from the underlying storage
     *
     * @param tcmUri TcmUri identifying the model to delete
     * @return boolean true, if the model was deleted
     */
    boolean delete(TcmUri tcmUri);
}
