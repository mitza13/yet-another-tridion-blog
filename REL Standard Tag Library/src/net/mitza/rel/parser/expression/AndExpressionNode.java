package net.mitza.rel.parser.expression;

import net.mitza.rel.parser.TokenTypes;

/**
 * @author Mihai Cadariu
 */
public class AndExpressionNode extends SequenceExpressionNode {

	public AndExpressionNode(ExpressionNode node) {
		super(node);
	}

	@Override
	public TokenTypes getType() {
		return TokenTypes.AND;
	}

	@Override
	public Object getValue() {
		return getBooleanValue();
	}

	@Override
	public boolean getBooleanValue() {
		for (Term term : terms) {
			if (!term.expression.getBooleanValue()) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void accept(ExpressionNodeVisitor visitor) {
		visitor.visit(this);
		for (Term term : terms) {
			term.expression.accept(visitor);
		}
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer("And[");
		boolean first = true;
		for (Term term : terms) {
			result.append(first ? "" : ", ");
			result.append(term.expression);
			first = false;
		}
		result.append("]");
		return result.toString();
	}
}
