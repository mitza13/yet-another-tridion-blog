package net.mitza.odata.builder.function;

import java.util.List;

import net.mitza.odata.parser.FieldOperatorNode;
import net.mitza.odata.parser.ParametersExpression;

import com.tridion.broker.querying.criteria.FieldOperator;
import com.tridion.broker.querying.criteria.structuregroups.StructureGroupTitleCriteria;

/**
 * @author Mihai Cadariu
 */
public class StructureGroupTitleBuilder extends FunctionBuilder {

	public StructureGroupTitleBuilder(ParametersExpression parametersExpression) {
		build(parametersExpression);
	}

	@Override
	public void build(ParametersExpression parametersExpression) {
		List<FieldOperatorNode> fieldOperatorNodes = parametersExpression.getFieldOperatorNodes();

		String title = fieldOperatorNodes.get(0).getValue();
		FieldOperator operator = fieldOperatorNodes.get(0).getFieldOperator();
		if (fieldOperatorNodes.size() == 1) {
			if (operator == FieldOperator.EQUAL) {
				criteria = new StructureGroupTitleCriteria(title);
			} else {
				criteria = new StructureGroupTitleCriteria(title, operator);
			}
		} else {
			boolean includeChildStructureGroups = Boolean.parseBoolean(fieldOperatorNodes.get(2).getValue());
			criteria = new StructureGroupTitleCriteria(title, operator, includeChildStructureGroups);
		}
	}
}