package com.mitza.toolkit.query;

/**
 * Exception indicating an error while Query execution
 *
 * @author Mihai Cadariu
 * @since 03.12.2015
 */
public class QueryException extends RuntimeException {

    /**
     * Create new instance using the given message
     *
     * @param message String the message to use
     */
    public QueryException(String message) {
        super(message);
    }
}
