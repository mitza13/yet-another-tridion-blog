package net.mitza.odata.builder.function;

import java.util.List;

import net.mitza.odata.parser.FieldOperatorNode;
import net.mitza.odata.parser.ParametersExpression;

import com.tridion.broker.querying.criteria.CriteriaException;
import com.tridion.broker.querying.criteria.metadata.CustomMetaDateRangeCriteria;

/**
 * @author Mihai Cadariu
 */
public class CustomMetaDateRangeBuilder extends FunctionBuilder {

	public CustomMetaDateRangeBuilder(ParametersExpression parametersExpression) throws CriteriaException {
		build(parametersExpression);
	}

	@Override
	public void build(ParametersExpression parametersExpression) throws CriteriaException {
		List<FieldOperatorNode> fieldOperatorNodes = parametersExpression.getFieldOperatorNodes();

		if (fieldOperatorNodes.size() == 2) {
			String beginRange = fieldOperatorNodes.get(0).getValue();
			String endRange = fieldOperatorNodes.get(1).getValue();
			criteria = new CustomMetaDateRangeCriteria(beginRange, endRange);
		} else if (fieldOperatorNodes.size() == 3) {
			String beginRange = fieldOperatorNodes.get(0).getValue();
			String endRange = fieldOperatorNodes.get(1).getValue();
			boolean rangeIncluded = Boolean.parseBoolean(fieldOperatorNodes.get(2).getValue());
			criteria = new CustomMetaDateRangeCriteria(beginRange, endRange, rangeIncluded);
		} else {
			String metaDataFieldName = fieldOperatorNodes.get(0).getValue();
			String beginRange = fieldOperatorNodes.get(1).getValue();
			String endRange = fieldOperatorNodes.get(2).getValue();
			boolean rangeIncluded = Boolean.parseBoolean(fieldOperatorNodes.get(3).getValue());
			criteria = new CustomMetaDateRangeCriteria(metaDataFieldName, beginRange, endRange, rangeIncluded);
		}
	}
}