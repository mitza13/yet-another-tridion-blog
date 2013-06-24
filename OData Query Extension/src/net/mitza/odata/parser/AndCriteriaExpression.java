package net.mitza.odata.parser;

import com.tridion.broker.querying.criteria.Criteria;
import com.tridion.broker.querying.criteria.operators.AndCriteria;

/**
 * @author Mihai Cadariu
 */
public class AndCriteriaExpression extends LogicalExpression {

	public AndCriteriaExpression(Expression node) {
		super(node);
	}

	@Override
	public ExpressionTypes getType() {
		return ExpressionTypes.AND_CRITERIA;
	}

	@Override
	public Criteria getCritera() {
		return new AndCriteria(criterias.toArray(new Criteria[0]));
	}
}
