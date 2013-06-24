package net.mitza.odata.parser;

import java.util.LinkedList;
import java.util.List;

public class Parser {

	// Terminal symbols:

	// CRITERIA
	// FIELD_OPERATOR
	// AND_OPERATOR
	// OR_OPERATOR
	// VALUE
	// OPEN_BRACKET
	// CLOSE_BRACKET

	// Non-terminal symbols:

	// expression -> or_term or_op
	// or_op -> OR_OPERATOR or_term or_op
	// or_op -> EPSILON

	// or_term -> and_term and_op
	// and_op -> AND_OPERATOR and_term and_op
	// and_op -> EPSILON

	// and_term -> CRITERIA field_op
	// and_term -> argument
	// field_op -> FIELD_OPERATOR value

	// argument -> OPEN_BRACKET expression CLOSE_BRACKET

	// value -> VALUE

	LinkedList<Token> tokens;
	Token lookahead;

	public Expression parse(String expression) {
		Tokenizer tokenizer = new Tokenizer();
		tokenizer.tokenize(expression);
		return parse(tokenizer.getTokens());
	}

	public Expression parse(List<Token> tokens) {
		this.tokens = new LinkedList<Token>(tokens);
		lookahead = this.tokens.getFirst();
		return expression();
	}

	private void nextToken() {
		tokens.pop();
		if (tokens.isEmpty()) {
			lookahead = new Token(TokenTypes.EPSILON, "");
		} else {
			lookahead = tokens.getFirst();
		}
	}

	// expression -> or_term or_op
	// or_op -> OR_OPERATOR or_term or_op
	// or_op -> EPSILON
	private Expression expression() {
		// expression -> or_term or_op
		Expression orTermExpression = orTerm();
		return orOp(orTermExpression);
	}

	// or_op -> OR_OPERATOR or_term or_op
	// or_op -> EPSILON
	private Expression orOp(Expression expression) {
		if (lookahead.tokenType == TokenTypes.OR_OPERATOR) {
			// or_op -> OR_OPERATOR or_term or_op
			OrCriteriaExpression orCriteria;
			if (expression.getType() == ExpressionTypes.OR_CRITERIA) {
				orCriteria = (OrCriteriaExpression) expression;
			} else {
				orCriteria = new OrCriteriaExpression(expression);
			}
			nextToken();
			Expression orTermExpression = orTerm();
			orCriteria.add(orTermExpression);
			return orOp(orCriteria);
		} else {
			// or_op -> EPSILON
			return expression;
		}
	}

	// or_term -> and_term and_op
	// and_op -> AND_OPERATOR and_term and_op
	// and_op -> EPSILON
	private Expression orTerm() {
		// or_term -> and_term and_op
		Expression andTermExpression = andTerm();
		return andOp(andTermExpression);
	}

	// and_op -> AND_OPERATOR and_term and_op
	// and_op -> EPSILON
	private Expression andOp(Expression expression) {
		if (lookahead.tokenType == TokenTypes.AND_OPERATOR) {
			// and_op -> AND_OPERATOR and_term and_op
			AndCriteriaExpression andCriteria;
			if (expression.getType() == ExpressionTypes.AND_CRITERIA) {
				andCriteria = (AndCriteriaExpression) expression;
			} else {
				andCriteria = new AndCriteriaExpression(expression);
			}
			nextToken();
			Expression andTermExpression = andTerm();
			andCriteria.add(andTermExpression);
			return andOp(andCriteria);
		} else {
			// and_op -> EPSILON
			return expression;
		}
	}

	// and_term -> CRITERIA field_op
	// and_term -> argument
	// field_op -> FIELD_OPERATOR value
	private Expression andTerm() {
		if (lookahead.tokenType == TokenTypes.CRITERIA) {
			// and_term -> CRITERIA field_op
			String criteria = lookahead.sequence;
			nextToken();
			FieldOperatorNode fieldOperator = fieldOp();
			return new CriteriaExpression(criteria, fieldOperator);
		} else {
			// and_term -> argument
			return argument();
		}
	}

	// field_op -> FIELD_OPERATOR value
	private FieldOperatorNode fieldOp() {
		if (lookahead.tokenType == TokenTypes.FIELD_OPERATOR) {
			// field_op -> FIELD_OPERATOR value
			String fieldOperator = lookahead.sequence;
			nextToken();
			ValueNode valueNode = value();
			return new FieldOperatorNode(fieldOperator, valueNode);
		} else {
			throw new ParserException("FieldOperator expected and " + lookahead.sequence + " found instead");
		}
	}

	// argument -> OPEN_BRACKET expression CLOSE_BRACKET
	private Expression argument() {
		if (lookahead.tokenType == TokenTypes.OPEN_BRACKET) {
			// argument -> OPEN_BRACKET expression CLOSE_BRACKET
			nextToken();
			Expression result = expression();
			if (lookahead.tokenType != TokenTypes.CLOSE_BRACKET) {
				throw new ParserException("Closing bracket expected and " + lookahead.sequence + " found instead");
			}
			nextToken();
			return result;
		} else {
			throw new ParserException("Open bracket expected and " + lookahead.sequence + " found instead");
		}
	}

	// value -> VALUE
	private ValueNode value() {
		if (lookahead.tokenType == TokenTypes.VALUE) {
			// value -> VALUE
			ValueNode result = new ValueNode(lookahead.sequence);
			nextToken();
			return result;
		} else {
			throw new ParserException("String, number or date expected and " + lookahead.sequence + " found instead");
		}
	}
}
