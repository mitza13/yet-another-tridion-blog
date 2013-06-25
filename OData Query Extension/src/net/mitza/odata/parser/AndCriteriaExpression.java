package net.mitza.odata.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tridion.broker.querying.criteria.Criteria;
import com.tridion.broker.querying.criteria.operators.AndCriteria;

/**
 * @author Mihai Cadariu
 */
public class AndCriteriaExpression extends LogicalExpression {

	private final Logger log = LoggerFactory.getLogger(AndCriteriaExpression.class);

	public AndCriteriaExpression(Expression node) {
		super(node);
	}

	@Override
	public ExpressionTypes getType() {
		return ExpressionTypes.AND_CRITERIA;
	}

	@Override
	public Criteria getCritera() {
		if (log.isDebugEnabled()) {
			log.debug("Perform AND between:");
			for (Criteria criteria : criterias) {
				log.debug("\t" + criteria);
			}
		}
		return new AndCriteria(criterias.toArray(new Criteria[0]));
	}
}
