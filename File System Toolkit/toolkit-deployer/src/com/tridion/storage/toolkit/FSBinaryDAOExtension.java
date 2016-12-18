package com.tridion.storage.toolkit;

import com.mitza.toolkit.storage.StorageFactory;
import com.tridion.broker.StorageException;
import com.tridion.storage.dao.BinaryContentDAO;
import com.tridion.storage.filesystem.FSBinaryContentDAO;
import com.tridion.storage.filesystem.FSEntityManager;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * Define a file system binary DAO extension that handles unpublishing of Multimedia Components
 *
 * @author Mihai Cadariu
 * @since 15.12.2015
 */
@Component("FSBinaryDAOExtension")
@Scope("prototype")
public class FSBinaryDAOExtension extends FSBinaryContentDAO implements BinaryContentDAO {

    public FSBinaryDAOExtension(String storageId, String storageName, File storageLocation) {
        super(storageId, storageName, storageLocation);
    }

    public FSBinaryDAOExtension(String storageId, String storageName, File storageLocation, FSEntityManager entityManager) {
        super(storageId, storageName, storageLocation, entityManager);
    }

    /**
     * Called by the framework when a binary is being removed
     */
    @Override
    public void remove(int publicationId, int binaryId, String variantId, String relativePath) throws StorageException {
        super.remove(publicationId, binaryId, variantId, relativePath);

        StorageFactory.INSTANCE.undeployBinary(publicationId, binaryId, variantId);
    }
}
