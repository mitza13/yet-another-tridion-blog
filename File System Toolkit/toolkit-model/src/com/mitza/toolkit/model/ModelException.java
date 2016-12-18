package com.mitza.toolkit.model;

/**
 * Exception indicating an error related to a model.
 *
 * @author Mihai Cadariu
 * @since 05.11.2015
 */
public class ModelException extends RuntimeException {

    /**
     * Create new instance using the given message
     *
     * @param message String the message to use
     */
    public ModelException(String message) {
        super(message);
    }

    /**
     * Create new instance wrapping the given Throwable
     *
     * @param throwable Throwable to wrap
     */
    public ModelException(Throwable throwable) {
        super(throwable);
    }
}
