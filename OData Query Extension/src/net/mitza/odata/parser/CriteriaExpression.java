package net.mitza.odata.parser;

import net.mitza.odata.builder.CriteriaBuilder;

import com.tridion.broker.querying.criteria.Criteria;

public class CriteriaExpression implements Expression {

	private Criteria criteria;

	public CriteriaExpression(String criteriaName, FieldOperatorNode fieldOperator) {
		criteria = CriteriaBuilder.parseCriteria(criteriaName, fieldOperator.getValue(),
				fieldOperator.getFieldOperator());
	}

	@Override
	public ExpressionTypes getType() {
		return ExpressionTypes.CRITERIA;
	}

	@Override
	public Criteria getCritera() {
		return criteria;
	}
}
