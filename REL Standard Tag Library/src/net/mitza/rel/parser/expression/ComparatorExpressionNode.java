package net.mitza.rel.parser.expression;

import net.mitza.rel.parser.TokenTypes;

public class ComparatorExpressionNode extends ExpressionNode {

	private final ExpressionNode leftHand;
	private final ExpressionNode rightHand;
	private final String operator;

	public ComparatorExpressionNode(ExpressionNode leftHand, ExpressionNode rightHand, String operator) {
		this.leftHand = leftHand;
		this.rightHand = rightHand;
		this.operator = operator;
	}

	@Override
	public TokenTypes getType() {
		return TokenTypes.COMPARATOR;
	}

	@Override
	public Object getValue() {
		return getBooleanValue();
	}

	@Override
	public boolean getBooleanValue() {
		if (leftHand == null && rightHand == null) {
			return true;
		} else if (leftHand == null ^ rightHand == null) {
			return false;
		}

		return compare();
	}

	@Override
	public void accept(ExpressionNodeVisitor visitor) {
		visitor.visit(this);
		leftHand.accept(visitor);
		rightHand.accept(visitor);
	}

	private boolean compare() {
		Object v1 = applyType(leftHand.getValue());
		Object v2 = applyType(rightHand.getValue());

		int result = 0;
		if (v1 instanceof Number && v2 instanceof Number) {
			result = Double.compare(((Number) v1).doubleValue(), ((Number) v2).doubleValue());
		} else if (v1 instanceof String && v2 instanceof String) {
			result = ((String) v1).compareTo((String) v2);
		}

		return compareOperation(result);
	}

	private boolean compareOperation(int result) {
		if ("==".equals(operator) || "eq".equals(operator)) {
			return result == 0;
		} else if ("!=".equals(operator) || "neq".equals(operator)) {
			return result != 0;
		} else if (">".equals(operator) || "gt".equals(operator)) {
			return result > 0;
		} else if (">=".equals(operator) || "ge".equals(operator)) {
			return result >= 0;
		} else if ("<".equals(operator) || "lt".equals(operator)) {
			return result < 0;
		} else if ("<=".equals(operator) || "le".equals(operator)) {
			return result <= 0;
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("Comparator[%s, %s, %s]", leftHand, rightHand, operator);
	}
}
