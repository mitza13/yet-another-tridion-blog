package net.mitza.odata.builder.function;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import net.mitza.odata.parser.FieldOperatorNode;
import net.mitza.odata.parser.ParametersExpression;

import com.tridion.broker.querying.criteria.FieldOperator;
import com.tridion.broker.querying.criteria.metadata.CustomMetaKeyCriteria;
import com.tridion.broker.querying.criteria.metadata.CustomMetaValueCriteria;
import com.tridion.util.TimeUtils;

/**
 * @author Mihai Cadariu
 */
public class CustomMetaValueBuilder extends FunctionBuilder {

	public CustomMetaValueBuilder(ParametersExpression parametersExpression) {
		build(parametersExpression);
	}

	@Override
	public void build(ParametersExpression parametersExpression) {
		CustomMetaKeyCriteria keyCriteria = (CustomMetaKeyCriteria) parametersExpression.getCritera();
		List<FieldOperatorNode> fieldOperatorNodes = parametersExpression.getFieldOperatorNodes();

		FieldOperator operator = fieldOperatorNodes.get(0).getFieldOperator();
		String valueString = fieldOperatorNodes.get(0).getValue();
		try {
			Date valueDate = TimeUtils.parseDate(valueString, DATE_FORMAT);
			criteria = new CustomMetaValueCriteria(keyCriteria, valueDate, operator);
			return;
		} catch (ParseException e) { // ignore
		}
		try {
			Float valueFloat = Float.parseFloat(valueString);
			criteria = new CustomMetaValueCriteria(keyCriteria, valueFloat, operator);
			return;
		} catch (NumberFormatException e) { // ignore
		}

		criteria = new CustomMetaValueCriteria(keyCriteria, valueString, operator);
	}
}