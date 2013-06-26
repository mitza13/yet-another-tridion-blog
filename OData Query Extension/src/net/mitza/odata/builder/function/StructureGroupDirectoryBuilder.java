package net.mitza.odata.builder.function;

import java.util.List;

import net.mitza.odata.parser.FieldOperatorNode;
import net.mitza.odata.parser.ParametersExpression;

import com.tridion.broker.querying.criteria.FieldOperator;
import com.tridion.broker.querying.criteria.structuregroups.StructureGroupDirectoryCriteria;

/**
 * @author Mihai Cadariu
 */
public class StructureGroupDirectoryBuilder extends FunctionBuilder {

	public StructureGroupDirectoryBuilder(ParametersExpression parametersExpression) {
		build(parametersExpression);
	}

	@Override
	public void build(ParametersExpression parametersExpression) {
		List<FieldOperatorNode> fieldOperatorNodes = parametersExpression.getFieldOperatorNodes();

		String structureGroupUri = fieldOperatorNodes.get(0).getValue();
		FieldOperator operator = fieldOperatorNodes.get(0).getFieldOperator();
		if (fieldOperatorNodes.size() == 1) {
			if (operator == FieldOperator.EQUAL) {
				criteria = new StructureGroupDirectoryCriteria(structureGroupUri);
			} else {
				criteria = new StructureGroupDirectoryCriteria(structureGroupUri, operator);
			}
		} else {
			boolean includeChildStructureGroups = Boolean.parseBoolean(fieldOperatorNodes.get(1).getValue());
			criteria = new StructureGroupDirectoryCriteria(structureGroupUri, operator, includeChildStructureGroups);
		}
	}
}