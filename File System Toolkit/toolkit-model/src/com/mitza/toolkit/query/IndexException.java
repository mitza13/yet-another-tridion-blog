package com.mitza.toolkit.query;

/**
 * Exception indicating an error related to the file indexes
 *
 * @author Mihai Cadariu
 * @since 26.11.2015
 */
public class IndexException extends RuntimeException {

    /**
     * Create new instance wrapping the specified Throwable
     *
     * @param throwable Throwable to wrap
     */
    public IndexException(Throwable throwable) {
        super(throwable);
    }
}
