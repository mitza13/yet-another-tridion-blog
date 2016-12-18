package com.tridion.storage.toolkit;

import com.mitza.toolkit.storage.StorageFactory;
import com.tridion.broker.StorageException;
import com.tridion.storage.dao.BinaryContentDAO;
import com.tridion.storage.persistence.JPABinaryContentDAO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Define a JPA binary DAO extension that handles unpublishing of Multimedia Components
 *
 * @author Mihai Cadariu
 * @since 15.12.2015
 */
@Component("JPABinaryDAOExtension")
@Scope("prototype")
public class JPABinaryDAOExtension extends JPABinaryContentDAO implements BinaryContentDAO {

    public JPABinaryDAOExtension(String storageId, EntityManagerFactory entityManagerFactory, String storageName) {
        super(storageId, entityManagerFactory, storageName);
    }

    public JPABinaryDAOExtension(String storageId, EntityManagerFactory entityManagerFactory, EntityManager entityManager, String storageName) {
        super(storageId, entityManagerFactory, entityManager, storageName);
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
