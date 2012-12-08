package mitza.dynamic.compile.cache;

import java.util.Collections;
import java.util.Map;

import mitza.dynamic.util.LruCache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mihai Cadariu
 */
public class ClassLoaderCache {

	private static final int MAX_SIZE = 100;
	private Map<String, CacheEntry> cache;
	private static ClassLoaderCache instance;
	private final Logger log = LoggerFactory.getLogger(ClassLoaderCache.class);

	private ClassLoaderCache() {
		log.debug("Create new cache with MAX_SIZE=" + MAX_SIZE);
		cache = Collections.synchronizedMap(new LruCache<String, CacheEntry>(MAX_SIZE));
	}

	public CacheEntry get(String className) {
		return cache.get(className);
	}

	public CacheEntry put(String className, CacheEntry cacheEntry) {
		return cache.put(className, cacheEntry);
	}

	public CacheEntry put(String className, Class<?> clazz) {
		CacheEntry cacheEntry = new CacheEntry(System.currentTimeMillis(), clazz);
		return cache.put(className, cacheEntry);
	}

	public int size() {
		return cache.size();
	}

	public static ClassLoaderCache getInstance() {
		if (instance == null) {
			instance = new ClassLoaderCache();
		}

		return instance;
	}
}
