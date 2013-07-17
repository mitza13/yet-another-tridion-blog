package net.mitza.rel.util;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @see http://stackoverflow.com/questions/221525/how-would-you-implement-an-lru-cache-in-java-6
 */
public class LruCache<K, V> extends LinkedHashMap<K, V> {

	private final int maxEntries;
	private static final long serialVersionUID = -6999821847235826338L;
	private final Logger log = LoggerFactory.getLogger(LruCache.class);

	public LruCache(final int maxEntries) {
		super(maxEntries + 1, 1.0f, true);
		this.maxEntries = maxEntries;
	}

	/**
	 * Returns <tt>true</tt> if this <code>LruCache</code> has more entries than the maximum specified when it was
	 * created.
	 * 
	 * <p>
	 * This method <em>does not</em> modify the underlying <code>Map</code>; it relies on the implementation of
	 * <code>LinkedHashMap</code> to do that, but that behavior is documented in the JavaDoc for
	 * <code>LinkedHashMap</code>.
	 * </p>
	 * 
	 * @param eldest
	 *            the <code>Entry</code> in question; this implementation doesn't care what it is, since the
	 *            implementation is only dependent on the size of the cache
	 * @return <tt>true</tt> if the oldest
	 * @see java.util.LinkedHashMap#removeEldestEntry(Map.Entry)
	 */
	@Override
	protected boolean removeEldestEntry(final Map.Entry<K, V> eldest) {
		boolean result = super.size() > maxEntries;
		if (result) {
			log.debug("Removing eldest entry " + eldest);
		}

		return result;
	}
}
