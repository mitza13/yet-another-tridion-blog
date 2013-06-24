package net.mitza.odata.parser;

import com.tridion.broker.querying.criteria.FieldOperator;

public class FieldOperatorNode {

	private String fieldOperator;
	private String value;

	public FieldOperatorNode(String fieldOperation, ValueNode value) {
		this.fieldOperator = fieldOperation;
		this.value = value.getValue();
	}

	public String getValue() {
		return value;
	}

	public FieldOperator getFieldOperator() {
		if ("like".equals(fieldOperator)) {
			return FieldOperator.LIKE;
		} else if ("eq".equals(fieldOperator)) {
			return FieldOperator.EQUAL;
		} else if ("neq".equals(fieldOperator)) {
			return FieldOperator.NOT_EQUAL;
		} else if ("gt".equals(fieldOperator)) {
			return FieldOperator.GREATER_THAN;
		} else if ("ge".equals(fieldOperator)) {
			return FieldOperator.GREATER_OR_EQUAL_THAN;
		} else if ("lt".equals(fieldOperator)) {
			return FieldOperator.LESS_THAN;
		} else if ("le".equals(fieldOperator)) {
			return FieldOperator.LESS_OR_EQUAL_THAN;
		}

		throw new ParserException("Invalid FieldOperator found " + fieldOperator);
	}
}
