package mitza.dynamic.compile.cache;

/**
 * @author Mihai Cadariu
 */
public class CacheEntry {

	private long lastModified;
	private Class<?> clazz;

	public CacheEntry(long lastModified, Class<?> clazz) {
		this.lastModified = lastModified;
		this.clazz = clazz;
	}

	public long getLastModified() {
		return lastModified;
	}

	public Class<?> getClazz() {
		return clazz;
	}
}
