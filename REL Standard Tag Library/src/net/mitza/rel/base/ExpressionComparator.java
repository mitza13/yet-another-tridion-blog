package net.mitza.rel.base;

import net.mitza.rel.parser.Parser;
import net.mitza.rel.parser.expression.ExpressionNode;

import com.tridion.tcdl.TransformContext;

/**
 * @author Mihai Cadariu
 */
public class ExpressionComparator {

	private final TransformContext context;

	public ExpressionComparator(TransformContext context) {
		this.context = context;
	}

	public boolean evaluate(String condition) {
		if (condition == null) {
			return false;
		}

		Parser parser = new Parser(context);
		ExpressionNode expressionNode = parser.parseCondition(condition);
		return expressionNode.getBooleanValue();
	}
}
