package net.mitza.rel.parser;

import net.mitza.rel.parser.expression.ExpressionNode;

/**
 * @author Mihai Cadariu
 */
public class CacheEntry {

	private long lastModified;
	private ExpressionNode expression;

	public CacheEntry(long lastModified, ExpressionNode expression) {
		this.lastModified = lastModified;
		this.expression = expression;
	}

	public long getLastModified() {
		return lastModified;
	}

	public ExpressionNode getExpression() {
		return expression;
	}

	@Override
	public String toString() {
		return String.format("%s, %s", lastModified, expression);
	}
}
