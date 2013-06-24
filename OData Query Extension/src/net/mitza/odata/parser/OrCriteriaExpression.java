package net.mitza.odata.parser;

import com.tridion.broker.querying.criteria.Criteria;
import com.tridion.broker.querying.criteria.operators.OrCriteria;

/**
 * @author Mihai Cadariu
 */
public class OrCriteriaExpression extends LogicalExpression {

	public OrCriteriaExpression(Expression node) {
		super(node);
	}

	@Override
	public ExpressionTypes getType() {
		return ExpressionTypes.OR_CRITERIA;
	}

	@Override
	public Criteria getCritera() {
		return new OrCriteria(criterias.toArray(new Criteria[0]));
	}
}
