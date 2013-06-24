package net.mitza.odata.parser;

import java.util.ArrayList;
import java.util.List;

import com.tridion.broker.querying.criteria.Criteria;

public abstract class LogicalExpression implements Expression {

	protected List<Criteria> criterias;

	public LogicalExpression() {
		criterias = new ArrayList<Criteria>();
	}

	public LogicalExpression(Expression node) {
		criterias = new ArrayList<Criteria>();
		add(node);
	}

	public void add(Expression node) {
		criterias.add(node.getCritera());
	}
}
