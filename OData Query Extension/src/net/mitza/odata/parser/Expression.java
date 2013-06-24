package net.mitza.odata.parser;

import com.tridion.broker.querying.criteria.Criteria;

public interface Expression {

	public ExpressionTypes getType();

	public Criteria getCritera();
}
