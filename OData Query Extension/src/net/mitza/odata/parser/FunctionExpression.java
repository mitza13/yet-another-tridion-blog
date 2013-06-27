package net.mitza.odata.parser;

import net.mitza.odata.builder.function.FunctionBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mihai Cadariu
 */
public class FunctionExpression extends CriteriaExpression {

	private static final Logger log = LoggerFactory.getLogger(FunctionExpression.class);

	private String functionName;
	private ParametersExpression parametersExpression;

	public FunctionExpression(String functionName, ParametersExpression parametersExpression) {
		this.functionName = functionName;
		this.parametersExpression = parametersExpression;
		criteria = FunctionBuilder.parseCriteria(this);
		log.debug("Add " + criteria);
	}

	@Override
	public ExpressionTypes getType() {
		return ExpressionTypes.FUNCTION;
	}

	public String getFunctionName() {
		return functionName;
	}

	public ParametersExpression getParameters() {
		return parametersExpression;
	}
}
