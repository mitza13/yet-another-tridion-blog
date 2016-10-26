package com.mihaiconsulting.cache;

/**
 * @author Mihai Cadariu
 * @since 07.03.2016
 */
public interface CacheInvalidator {

    void invalidate(String key);
}
