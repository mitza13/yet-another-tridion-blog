package net.mitza.rel.parser;

import net.mitza.rel.parser.expression.ExpressionNodeVisitorAdapter;
import net.mitza.rel.parser.expression.VariableExpressionNode;

import com.tridion.tcdl.TransformContext;

/**
 * A visitor that sets the context for variable expression nodes
 */
public class SetContextVisitor extends ExpressionNodeVisitorAdapter {

	private TransformContext context;

	public SetContextVisitor(TransformContext context) {
		this.context = context;
	}

	@Override
	public void visit(VariableExpressionNode node) {
		node.setContext(context);
	}
}
