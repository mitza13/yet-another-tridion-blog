package net.mitza.odata.parser;

import net.mitza.odata.builder.CriteriaBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tridion.broker.querying.criteria.Criteria;

/**
 * @author Mihai Cadariu
 */
public class CriteriaExpression implements Expression {

	private static final Logger log = LoggerFactory.getLogger(CriteriaExpression.class);

	protected Criteria criteria;

	public CriteriaExpression() {
	}

	public CriteriaExpression(String criteriaName, FieldOperatorNode fieldOperator) {
		criteria = CriteriaBuilder.parseCriteria(criteriaName, fieldOperator.getValue(),
				fieldOperator.getFieldOperator());
		log.debug("Add " + criteria);
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
