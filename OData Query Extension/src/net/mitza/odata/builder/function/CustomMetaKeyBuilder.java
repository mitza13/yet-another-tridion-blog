package net.mitza.odata.builder.function;

import java.util.List;

import net.mitza.odata.parser.FieldOperatorNode;
import net.mitza.odata.parser.ParametersExpression;

import com.tridion.broker.querying.criteria.FieldOperator;
import com.tridion.broker.querying.criteria.metadata.CustomMetaKeyCriteria;

/**
 * @author Mihai Cadariu
 */
public class CustomMetaKeyBuilder extends FunctionBuilder {

	public CustomMetaKeyBuilder(ParametersExpression parametersExpression) {
		build(parametersExpression);
	}

	@Override
	public void build(ParametersExpression parametersExpression) {
		List<FieldOperatorNode> fieldOperatorNodes = parametersExpression.getFieldOperatorNodes();
		String keyName = fieldOperatorNodes.get(0).getValue();
		FieldOperator operator = fieldOperatorNodes.get(0).getFieldOperator();
		criteria = new CustomMetaKeyCriteria(keyName, operator);
	}
}