package com.mitza.toolkit.cache;

/**
 * Class representing an entry in the cache. It wraps a generic payload object and a timestamp of when this entry
 * was last checked for staleness.
 *
 * @author Mihai Cadariu
 * @since 23.11.2015
 */
public class CacheElement<T> {

    private long lastCheck;
    private T payload;

    /**
     * Create new instance using the given payload object
     *
     * @param payload T the payload to cache
     */
    public CacheElement(T payload) {
        this.payload = payload;
        lastCheck = System.currentTimeMillis();
    }

    /**
     * Return the last check timestamp
     *
     * @return int the timestamp in milliseconds when this entry was last checked for staleness
     */
    public long getLastCheck() {
        return lastCheck;
    }

    /**
     * Set last check to the given timestamp
     *
     * @param lastCheck long the new timestamp to set
     */
    public void setLastCheck(long lastCheck) {
        this.lastCheck = lastCheck;
    }

    /**
     * Return the cached payload
     *
     * @return T generic cached payload object
     */
    public T getPayload() {
        return payload;
    }

    /**
     * Set the payload to the given object
     *
     * @param payload T the new payload to set
     */
    public void setPayload(T payload) {
        this.payload = payload;
    }
}
