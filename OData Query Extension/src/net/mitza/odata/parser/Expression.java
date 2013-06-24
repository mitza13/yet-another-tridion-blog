package net.mitza.odata.parser;

import com.tridion.broker.querying.criteria.Criteria;

/**
 * @author Mihai Cadariu
 */
public interface Expression {

	public ExpressionTypes getType();

	public Criteria getCritera();
}
