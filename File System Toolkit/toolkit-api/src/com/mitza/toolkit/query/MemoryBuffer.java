package com.mitza.toolkit.query;

/**
 * Interface defining the operations permitted on a custom memory buffer
 *
 * @author Mihai Cadariu
 * @since 17.01.2016
 */
public interface MemoryBuffer {

    /**
     * Return the size of this buffer
     *
     * @return int the size of this buffer
     */
    int capacity();

    /**
     * Read the byte in the buffer at the given position
     *
     * @param position int the position in the buffer to read from
     * @return byte the value at the given position in the buffer
     */
    byte get(int position);

    /**
     * Close the current memory buffer
     */
    void close();
}
