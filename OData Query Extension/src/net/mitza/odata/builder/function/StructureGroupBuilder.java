package net.mitza.odata.builder.function;

import java.util.List;

import net.mitza.odata.parser.FieldOperatorNode;
import net.mitza.odata.parser.ParametersExpression;

import com.tridion.broker.querying.criteria.structuregroups.StructureGroupCriteria;

/**
 * @author Mihai Cadariu
 */
public class StructureGroupBuilder extends FunctionBuilder {

	public StructureGroupBuilder(ParametersExpression parametersExpression) {
		build(parametersExpression);
	}

	@Override
	public void build(ParametersExpression parametersExpression) {
		List<FieldOperatorNode> fieldOperatorNodes = parametersExpression.getFieldOperatorNodes();

		String structureGroupUri = fieldOperatorNodes.get(0).getValue();
		if (fieldOperatorNodes.size() == 1) {
			criteria = new StructureGroupCriteria(structureGroupUri);
		} else {
			boolean includeChildStructureGroups = Boolean.parseBoolean(fieldOperatorNodes.get(1).getValue());
			criteria = new StructureGroupCriteria(structureGroupUri, includeChildStructureGroups);
		}
	}
}