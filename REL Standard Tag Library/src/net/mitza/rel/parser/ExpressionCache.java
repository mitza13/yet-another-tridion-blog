package net.mitza.rel.parser;

import java.util.Collections;
import java.util.Map;

import net.mitza.rel.parser.expression.ExpressionNode;
import net.mitza.rel.util.LruCache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mihai Cadariu
 */
public class ExpressionCache {

	private static final int MAX_SIZE = 100;
	private Map<String, ExpressionNode> cache;
	private static ExpressionCache instance;
	private final Logger log = LoggerFactory.getLogger(ExpressionCache.class);

	private ExpressionCache() {
		log.debug("Create cache with MAX_SIZE=" + MAX_SIZE);
		cache = Collections.synchronizedMap(new LruCache<String, ExpressionNode>(MAX_SIZE));
	}

	public ExpressionNode get(String name) {
		return cache.get(name);
	}

	public ExpressionNode put(String name, ExpressionNode expression) {
		return cache.put(name, expression);
	}

	public int size() {
		return cache.size();
	}

	public static ExpressionCache getInstance() {
		if (instance == null) {
			instance = new ExpressionCache();
		}

		return instance;
	}
}
