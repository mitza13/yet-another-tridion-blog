package com.mitza.toolkit.provider.fs;

import com.mitza.toolkit.configuration.ToolkitConfiguration;
import com.mitza.toolkit.domain.ItemMeta;
import com.mitza.toolkit.model.ModelException;
import com.mitza.toolkit.provider.ModelProvider;
import com.mitza.toolkit.serializer.JSonSerializer;
import com.mitza.toolkit.serializer.SerializationException;
import com.mitza.toolkit.serializer.SerializerFactory;
import com.mitza.toolkit.util.ModelUtils;
import com.mitza.toolkit.util.PathMapper;
import com.mitza.util.TcmUri;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Implementation of the ModelProvider interface that uses a file system storage to implement the CRUD operations for
 * Tridion models. It is only implemented for Component and Page models.
 *
 * @author Mihai Cadariu
 * @since 04.02.2016
 */
public enum FileSystemProvider implements ModelProvider {

    INSTANCE;
    private final String jsonRootPath;
    private final PathMapper pathMapper;
    private final JSonSerializer serializer;
    private final boolean isCleanup;

    private final Logger log = LoggerFactory.getLogger(FileSystemProvider.class);

    FileSystemProvider() {
        log.debug("Create new instance");

        ToolkitConfiguration configuration = ToolkitConfiguration.INSTANCE;
        File jsonRootFile = new File(configuration.getJsonRoot());
        jsonRootPath = jsonRootFile.getAbsolutePath();
        log.debug("Using jsonRootPath {}", jsonRootPath);

        isCleanup = configuration.isCleanup();
        pathMapper = new PathMapper();
        serializer = SerializerFactory.INSTANCE.getSerializer();
    }

    /**
     * Create new Component or Page model without persisting it to file system and populates only its TcmUri
     *
     * @param tcmUri TcmUri identifing the model to create
     * @return ComponentMeta or PageMeta newly created
     */
    @Override
    public <T extends ItemMeta> T create(TcmUri tcmUri) {
        log.debug("Create model for {}", tcmUri);

        T result;
        Class<T> aClass = ModelUtils.getClass(tcmUri);
        try {
            result = aClass.newInstance();
            Method setTcmUri = aClass.getMethod("setTcmUri", TcmUri.class);
            setTcmUri.invoke(result, tcmUri);
        } catch (InstantiationException | IllegalAccessException |
                NoSuchMethodException | InvocationTargetException e) {
            log.error("Error instantiating model for type " + aClass, e);
            throw new ModelException(e);
        }

        return result;
    }

    /**
     * Return fully resolved Component or Page model based on the given TcmUri by reading and deserializing JSON file
     * from the file system
     *
     * @param tcmUri TcmUri identifing the model to retrieve
     * @return ComponentMeta or PageMeta the fully resolved model; or null, if not found
     */
    @Override
    public <T extends ItemMeta> T read(TcmUri tcmUri) {
        log.debug("Read model for {}", tcmUri);

        String path = pathMapper.getModelAbsolutePath(tcmUri);
        File file = new File(path);
        if (!file.exists()) {
            log.debug("File with TcmUri {} not found at path file {}", tcmUri, path);
            return null;
        }

        try {
            Class<T> aClass = ModelUtils.getClass(tcmUri);
            T model = serializer.deserialize(file, aClass);
            log.debug("Return model {} from file {}", model, file);
            return model;
        } catch (SerializationException se) {
            log.error("Error deserializing model " + tcmUri + " from file " + path, se);
            throw new ModelException(se);
        }
    }

    /**
     * Persist the given Component or Page model by serializing it to JSON and writing it to the file system
     *
     * @param model ComponentMeta or PageMeta to persist
     * @return ComponentMeta or PageMeta the persisted model
     */
    @Override
    public <T extends ItemMeta> T update(T model) {
        log.debug("Update model {}", model);

        TcmUri tcmUri = model.getTcmUri();
        String path = pathMapper.getModelAbsolutePath(tcmUri);
        File file = new File(path);

        if (!file.exists()) {
            File directory = file.getParentFile();
            if (!directory.exists()) {
                if (!directory.mkdirs()) {
                    log.error("Directory {} was not created", directory);
                }
            }
        }

        serializer.serialize(file, model);
        log.debug("Done update model {} to file {}", tcmUri, file);

        return model;
    }

    /**
     * Delete a Component or Page JSON file from the file system storage
     *
     * @param tcmUri TcmUri identifing the model to delete
     * @return boolean true, if the operation was successful
     */
    @Override
    public boolean delete(TcmUri tcmUri) {
        log.debug("Delete model {}", tcmUri);

        String path = pathMapper.getModelAbsolutePath(tcmUri);
        File file = new File(path);

        if (file.exists()) {
            log.debug("Delete model file {}", file);
            if (file.delete()) {
                if (isCleanup) {
                    deleteEmptyFolders(file.getParentFile());
                }
                return true;
            } else {
                log.error("Cannot delete model {} with path {}", tcmUri, path);
            }
        }

        return false;
    }

    private void deleteEmptyFolders(File directory) {
        if (directory.isDirectory() && directory.list().length == 0 && isUnderRoot(directory)) {
            if (directory.delete()) {
                log.debug("Deleted empty folder {}", directory);
                deleteEmptyFolders(directory.getParentFile());
            } else {
                log.error("Unable to delete empty folder {}", directory);
            }
        } else {
            log.debug("Not eligible for deletion {}", directory);
        }
    }

    private boolean isUnderRoot(File directory) {
        if (directory == null) {
            return false;
        }

        String directoryPath = directory.getAbsolutePath();
        return directoryPath.startsWith(jsonRootPath) && !directoryPath.equals(jsonRootPath);
    }
}
