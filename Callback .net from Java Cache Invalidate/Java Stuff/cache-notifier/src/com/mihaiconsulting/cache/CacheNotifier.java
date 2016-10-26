package com.mihaiconsulting.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mihai Cadariu
 * @since 08.03.2016
 */
public class CacheNotifier {

    private static final Logger log = LoggerFactory.getLogger(CacheNotifier.class);
    private static final CacheNotifier instance = new CacheNotifier();
    private CacheInvalidator invalidator = new CacheInvalidator() {
        @Override
        public void invalidate(String key) {
            log.warn("Using empty CacheInvalidator. Called with key: {}", key);
        }
    };

    private CacheNotifier() {
        log.debug("Create new instance");
    }

    public static CacheNotifier getInstance() {
        return instance;
    }

    public void setInvalidator(CacheInvalidator invalidator) {
        log.debug("Set invalidator {}", invalidator);

        if (invalidator == null) {
            log.error("Cannot set null CacheInvalidator");
            throw new IllegalStateException("Invalid null CacheInvalidator");
        }

        this.invalidator = invalidator;
    }

    public void notify(String key) {
        log.debug("Notify key {}", key);

        if (invalidator == null) {
            log.error("Must set invalidator first");
            throw new IllegalStateException("Invalidator has not been set");
        }

        invalidator.invalidate(key);
    }
}
