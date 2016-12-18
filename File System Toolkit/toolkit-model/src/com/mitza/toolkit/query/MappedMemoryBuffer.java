package com.mitza.toolkit.query;

import com.mitza.toolkit.configuration.ToolkitConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Wraps a java.nio.MappedByteBuffer and implements the operations defined in MemoryBuffer infterface
 * in order to provide a custom memory buffer that can be closed.
 * <p/>
 * Uses introspection to call private method 'close' from the MappedByteBuffer. What a hack!
 * <p/>
 * This class only closes the wrapped buffer if the code is executed on a Windows operation system.
 * Other operating system don't keep the byte buffers open until the Garbage Collection recycles them.
 *
 * @author Mihai Cadariu
 * @since 17.01.2016
 */
public class MappedMemoryBuffer implements MemoryBuffer {

    private final MappedByteBuffer buffer;
    private final FileChannel fileChannel;
    private final Logger log = LoggerFactory.getLogger(MappedMemoryBuffer.class);

    /**
     * Create a new memory buffer for the given FileChannel and mode
     *
     * @param fileChannel the FileChannel to create a buffer from
     * @param mode
     * @throws IOException
     */
    public MappedMemoryBuffer(FileChannel fileChannel, FileChannel.MapMode mode) throws IOException {
        this.fileChannel = fileChannel;
        buffer = fileChannel.map(mode, 0, fileChannel.size());
    }

    /**
     * Return the size of the wrapped buffer
     *
     * @return int the size of the wrapped buffer
     */
    @Override
    public int capacity() {
        return buffer.capacity();
    }

    /**
     * Read the byte in the wrapped buffer at the given position
     *
     * @param position int the position in the wrapped buffer to read from
     * @return byte the value at the given position in the wrapped buffer
     */
    @Override
    public byte get(int position) {
        return buffer.get(position);
    }

    /**
     * Close the current wrapped memory byte buffer (only if Windows)
     */
    @Override
    public void close() {
        if (ToolkitConfiguration.INSTANCE.isWindows()) {
            try {
                // what a hack!
                Class<?> clazz = fileChannel.getClass();
                Method method = clazz.getDeclaredMethod("unmap", new Class[]{MappedByteBuffer.class});
                method.setAccessible(true);
                method.invoke(null, new Object[]{buffer});
            } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                log.error("Error accessing FileChannel.unmap()", e);
            }
        }
    }
}
