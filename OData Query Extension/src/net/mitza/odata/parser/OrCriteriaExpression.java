package net.mitza.odata.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tridion.broker.querying.criteria.Criteria;
import com.tridion.broker.querying.criteria.operators.OrCriteria;

/**
 * @author Mihai Cadariu
 */
public class OrCriteriaExpression extends LogicalExpression {

	private final Logger log = LoggerFactory.getLogger(OrCriteriaExpression.class);

	public OrCriteriaExpression(Expression node) {
		super(node);
	}

	@Override
	public ExpressionTypes getType() {
		return ExpressionTypes.OR_CRITERIA;
	}

	@Override
	public Criteria getCritera() {
		if (log.isDebugEnabled()) {
			log.debug("Perform OR between:");
			for (Criteria criteria : criterias) {
				log.debug("\t" + criteria);
			}
		}
		return new OrCriteria(criterias.toArray(new Criteria[0]));
	}
}
