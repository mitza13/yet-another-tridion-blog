package com.mitza.toolkit.query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * Singleton factory implementation that provides a MemoryBuffer for the given FileChannel and MapMode.
 *
 * @author Mihai Cadariu
 * @since 17.01.2016
 */
public enum MemoryBufferFactory {

    INSTANCE;
    private final Logger log = LoggerFactory.getLogger(MemoryBufferFactory.class);

    MemoryBufferFactory() {
        log.debug("Create new instance");
    }

    /**
     * Return a MappedMemoryBuffer for the given FileChannel and MapMode
     *
     * @param fileChannel FileChannel the file channel to create memory buffer for
     * @param mode        FileChannel.MapMode the mode to use
     * @return MappedMemoryBuffer the memory buffer
     */
    public MemoryBuffer getBuffer(FileChannel fileChannel, FileChannel.MapMode mode) throws IOException {
        return new MappedMemoryBuffer(fileChannel, mode);
    }
}
