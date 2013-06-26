package net.mitza.odata.builder.function;

import java.util.List;

import net.mitza.odata.parser.FieldOperatorNode;
import net.mitza.odata.parser.ParametersExpression;

import com.tridion.broker.querying.criteria.metadata.CustomMetaStringRangeCriteria;

/**
 * @author Mihai Cadariu
 */
public class CustomMetaStringRangeBuilder extends FunctionBuilder {

	public CustomMetaStringRangeBuilder(ParametersExpression parametersExpression) {
		build(parametersExpression);
	}

	@Override
	public void build(ParametersExpression parametersExpression) {
		List<FieldOperatorNode> fieldOperatorNodes = parametersExpression.getFieldOperatorNodes();

		if (fieldOperatorNodes.size() == 2) {
			String beginRange = fieldOperatorNodes.get(0).getValue();
			String endRange = fieldOperatorNodes.get(1).getValue();
			criteria = new CustomMetaStringRangeCriteria(beginRange, endRange);
		} else if (fieldOperatorNodes.size() == 3) {
			String beginRange = fieldOperatorNodes.get(0).getValue();
			String endRange = fieldOperatorNodes.get(1).getValue();
			boolean rangeIncluded = Boolean.parseBoolean(fieldOperatorNodes.get(2).getValue());
			criteria = new CustomMetaStringRangeCriteria(beginRange, endRange, rangeIncluded);
		} else {
			String metaDataFieldName = fieldOperatorNodes.get(0).getValue();
			String beginRange = fieldOperatorNodes.get(1).getValue();
			String endRange = fieldOperatorNodes.get(2).getValue();
			boolean rangeIncluded = Boolean.parseBoolean(fieldOperatorNodes.get(3).getValue());
			criteria = new CustomMetaStringRangeCriteria(metaDataFieldName, beginRange, endRange, rangeIncluded);
		}
	}
}