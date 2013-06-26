package net.mitza.odata.builder.function;

import java.util.List;

import net.mitza.odata.parser.FieldOperatorNode;
import net.mitza.odata.parser.ParametersExpression;

import com.tridion.broker.querying.criteria.metadata.NumericalRangeCriteria;

/**
 * @author Mihai Cadariu
 */
public class CustomMetaNumericalRangeBuilder extends FunctionBuilder {

	public CustomMetaNumericalRangeBuilder(ParametersExpression parametersExpression) {
		build(parametersExpression);
	}

	@Override
	public void build(ParametersExpression parametersExpression) {
		List<FieldOperatorNode> fieldOperatorNodes = parametersExpression.getFieldOperatorNodes();

		if (fieldOperatorNodes.size() == 2) {
			float beginRange = Float.parseFloat(fieldOperatorNodes.get(0).getValue());
			float endRange = Float.parseFloat(fieldOperatorNodes.get(1).getValue());
			criteria = new NumericalRangeCriteria(beginRange, endRange);
		} else if (fieldOperatorNodes.size() == 3) {
			float beginRange = Float.parseFloat(fieldOperatorNodes.get(0).getValue());
			float endRange = Float.parseFloat(fieldOperatorNodes.get(1).getValue());
			boolean rangeIncluded = Boolean.parseBoolean(fieldOperatorNodes.get(2).getValue());
			criteria = new NumericalRangeCriteria(beginRange, endRange, rangeIncluded);
		} else {
			String metaDataFieldName = fieldOperatorNodes.get(0).getValue();
			float beginRange = Float.parseFloat(fieldOperatorNodes.get(1).getValue());
			float endRange = Float.parseFloat(fieldOperatorNodes.get(2).getValue());
			boolean rangeIncluded = Boolean.parseBoolean(fieldOperatorNodes.get(3).getValue());
			criteria = new NumericalRangeCriteria(metaDataFieldName, beginRange, endRange, rangeIncluded);
		}
	}
}