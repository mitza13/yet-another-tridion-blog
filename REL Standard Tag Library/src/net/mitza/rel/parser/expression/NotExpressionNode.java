package net.mitza.rel.parser.expression;

import net.mitza.rel.parser.TokenTypes;

/**
 * @author Mihai Cadariu
 */
public class NotExpressionNode extends ExpressionNode {

	private ExpressionNode node;

	public NotExpressionNode(ExpressionNode node) {
		this.node = node;
	}

	@Override
	public TokenTypes getType() {
		return TokenTypes.NOT;
	}

	@Override
	public Object getValue() {
		return getBooleanValue();
	}

	@Override
	public boolean getBooleanValue() {
		return !node.getBooleanValue();
	}

	@Override
	public void accept(ExpressionNodeVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public String toString() {
		return String.format("Not[%s]", node);
	}
}
