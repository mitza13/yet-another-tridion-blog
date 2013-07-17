package net.mitza.rel.base;

import net.mitza.rel.parser.Parser;
import net.mitza.rel.parser.expression.ExpressionNode;

import com.tridion.tcdl.TransformContext;

/**
 * @author Mihai Cadariu
 */
public class ExpressionEvaluator {

	private final TransformContext context;

	public ExpressionEvaluator(TransformContext context) {
		this.context = context;
	}

	public Object evaluate(String expression) {
		if (expression == null) {
			return "";
		}

		Parser parser = new Parser(context);
		ExpressionNode expressionNode = parser.parseExpression(expression);
		return expressionNode.getValue();
	}
}
