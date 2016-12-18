package com.mitza.toolkit.configuration;

/**
 * Exception indicating an error related to the configuration of the Toolkit.
 * Most likely the file toolkit.properties is not available in the class-path or
 * it doesn't contain the right configuration entry.
 *
 * @author Mihai Cadariu
 * @since 03.11.2015
 */
public class ConfigurationException extends RuntimeException {

    /**
     * Create a new instance wrapping the given message
     *
     * @param message String representing the message to wrap
     */
    public ConfigurationException(String message) {
        super(message);
    }

    /**
     * Create a new instance wrapping the given throwable
     *
     * @param throwable Throwable representing the object to wrap
     */
    public ConfigurationException(Throwable throwable) {
        super(throwable);
    }
}
