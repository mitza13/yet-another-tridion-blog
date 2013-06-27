package net.mitza.odata.parser;

import java.util.ArrayList;
import java.util.List;

import com.tridion.broker.querying.criteria.Criteria;

/**
 * @author Mihai Cadariu
 */
public class ParametersExpression extends CriteriaExpression {

	private List<FieldOperatorNode> fieldOperatorNodes;

	public ParametersExpression() {
		fieldOperatorNodes = new ArrayList<FieldOperatorNode>();
	}

	public ParametersExpression(Criteria nestedCriteria, List<FieldOperatorNode> parameters) {
		this.criteria = nestedCriteria;
		this.fieldOperatorNodes = parameters;
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}

	public void addParameter(FieldOperatorNode parameter) {
		fieldOperatorNodes.add(0, parameter);
	}

	public List<FieldOperatorNode> getFieldOperatorNodes() {
		return fieldOperatorNodes;
	}
}
