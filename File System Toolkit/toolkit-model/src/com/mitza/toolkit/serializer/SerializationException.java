package com.mitza.toolkit.serializer;

/**
 * Exception indicating an error related to serialization.
 *
 * @author Mihai Cadariu
 * @since 05.11.2015
 */
public class SerializationException extends RuntimeException {

    /**
     * Create new instance wrapping the given Throwable
     *
     * @param throwable Throwable to wrap
     */
    public SerializationException(Throwable throwable) {
        super(throwable);
    }
}
