package com.mitza.toolkit.dynamic;

/**
 * Exception indicating an error that occurred during tag execution in the content of a Dynamic Component Presentation
 *
 * @author Mihai Cadariu
 * @since 06.01.2016
 */
public class TagException extends RuntimeException {

    /**
     * Create new instance wrapping another throwable
     *
     * @param throwable the wrapped Throwable
     */
    public TagException(Throwable throwable) {
        super(throwable);
    }
}
