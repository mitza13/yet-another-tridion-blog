package com.mitza.toolkit.cache;

import com.mitza.toolkit.configuration.ConfigurationException;
import com.mitza.toolkit.configuration.ToolkitConfiguration;
import com.mitza.toolkit.domain.IdentifiableObject;
import com.mitza.toolkit.util.PathMapper;
import com.mitza.util.TcmUri;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Singleton factory implementation handling interaction with the underlying EHCache system.
 *
 * @author Mihai Cadariu
 * @since 15.11.2015
 */
public enum CacheFactory {

    INSTANCE;
    private static final String CACHE_NAME = "toolkit-cache";
    private final Cache cache;
    private final int cacheMonitorInterval; // milliseconds
    private final Logger log = LoggerFactory.getLogger(CacheFactory.class);
    private final boolean enabled;

    CacheFactory() {
        log.debug("Create new instance");

        ToolkitConfiguration toolkitConfiguration = ToolkitConfiguration.INSTANCE;
        enabled = toolkitConfiguration.isCacheEnabled();
        log.debug("Using cache enabled: {}", enabled);

        if (enabled) {
            CacheManager cacheManager = CacheManager.create();
            for (String name : cacheManager.getCacheNames()) {
                log.debug("Cache found: {}", name);
            }

            if (!cacheManager.cacheExists(CACHE_NAME)) {
                log.debug("Add cache programmatically: {}", CACHE_NAME);
                Cache cache = new Cache(
                        new CacheConfiguration(CACHE_NAME, toolkitConfiguration.getCacheMaxEntriesLocalHeap())
                                .memoryStoreEvictionPolicy(MemoryStoreEvictionPolicy.LRU)
                                .eternal(false)
                                .timeToLiveSeconds(toolkitConfiguration.getCacheTimeToLiveSeconds())
                                .timeToIdleSeconds(toolkitConfiguration.getCacheTimeToIdleSeconds())
                );
                cacheManager.addCache(cache);
            }

            cache = cacheManager.getCache(CACHE_NAME);

            if (cache == null) {
                String message = "Cannot find definition for EHCache cache '" + CACHE_NAME +
                        "'. Make sure that file 'ehcache.xml' is in the application class-path and that it contains a definition for a cache named '" +
                        CACHE_NAME + "'";
                log.error(message);
                throw new ConfigurationException(message);
            }

            log.debug("Using cache: {}", cache);

            cacheMonitorInterval = toolkitConfiguration.getCacheMonitorSeconds() * 1000;
            log.debug("Using cacheMonitorInterval {} seconds", cacheMonitorInterval / 1000);
        } else {
            log.debug("Not using cache");
            cache = null;
            cacheMonitorInterval = -1;
        }
    }

    /**
     * Return the CacheElement from the cache identified by the given key
     *
     * @param key String the key to read the cache entry for
     * @param <T> Type of the payload in the CacheElement
     * @return CacheElement the entry in cache or null, if not cached
     */
    public <T> CacheElement<T> get(String key) {
        if (!enabled) {
            return null;
        }

        Element element = cache.get(key);
        if (element == null) {
            log.debug("Key {} not found in cache", key);
            return null;
        } else {
            if (isStale(element)) {
                remove(key);
                return null;
            }

            CacheElement<T> result = (CacheElement<T>) element.getObjectValue();

            log.debug("Return {} from cache for key {}", result, key);
            return result;
        }
    }

    /**
     * Store the payload in the cache under the given key
     *
     * @param key     String the key to use
     * @param payload the object to store in cache
     * @param <T>     type of the payload object
     */
    public <T> void put(String key, T payload) {
        if (!enabled) {
            return;
        }

        Element element = new Element(key, new CacheElement<>(payload));

        if (cache.isKeyInCache(key)) {
            log.debug("Update key {} in cache", key);
            cache.replace(element);
        } else {
            log.debug("Add key {} to cache", key);
            cache.put(element);
        }
    }

    /**
     * Remove the entry corresponding to the give key from cache
     *
     * @param key String the key to use
     * @return boolean true, if the entry was removed from cache
     */
    public boolean remove(String key) {
        if (!enabled) {
            return false;
        }

        log.debug("Remove key {} from cache", key);

        return cache.remove(key);
    }

    /**
     * Return a cache key from the given TcmUri
     *
     * @param tcmUri TcmUri the id to use
     * @return String the resulting cache key
     */
    public String getKey(TcmUri tcmUri) {
        return tcmUri.toString();
    }

    private boolean isStale(Element element) {
        CacheElement<Object> cacheElement = (CacheElement<Object>) element.getObjectValue();
        long lastCheck = cacheElement.getLastCheck();
        long now = System.currentTimeMillis();

        if (now - lastCheck > cacheMonitorInterval) {
            cacheElement.setLastCheck(now);
            Object value = cacheElement.getPayload();

            if (value instanceof IdentifiableObject) {
                IdentifiableObject identifiableObject = (IdentifiableObject) value;
                TcmUri tcmUri = identifiableObject.getTcmUri();
                PathMapper pathMapper = new PathMapper();
                File file = new File(pathMapper.getModelAbsolutePath(tcmUri));

                boolean result = !file.exists() || file.lastModified() > lastCheck;
                log.debug("Stale check: {}", result);

                return result;
            }
        }

        return false;
    }
}
