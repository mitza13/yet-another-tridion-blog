package com.mitza.util;

/**
 * Exception indicating an error related to a TcmUri. Most likely the TcmUri processed was malformed.
 *
 * @author Mihai Cadariu
 * @since 14.11.2015
 */
public class TcmUriException extends RuntimeException {

    /**
     * Create new exception that wraps the given message
     *
     * @param message String representing the message to wrap
     */
    public TcmUriException(String message) {
        super(message);
    }
}
