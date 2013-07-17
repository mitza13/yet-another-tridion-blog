/**
 * This parser is based on the CogPar implementation with additional logical expression parsing features.
 *
 * CogPar is lightweight but versatile parser for mathematical expressions. 
 *
 * It can be used to analyse expressions and store them in an internal data structure for later
 * evaluation. Repeated evaluation of the same expression using CogPar is fast.
 *
 * CogPar comes with a highly configurable tokenizer which can be adapted for your own needs.
 *
 * Arbitrary named variables are supported and values can be assigned in a single line of code.
 *
 * The parser, it's grammar an the tokenizer are well documented. You can read more about the internal 
 * workings of CogPar <a href="http://cogitolearning.co.uk/?p=523" alt="CogPar tutorial">in these posts</a>.
 *
 * CogPar is distributed under the MIT license, so feel free to use it in your own projects.
 *
 * To download CogPar, <a href="" alt="Download CogPar">follow this link.</a>
 */
package net.mitza.rel.parser;

import java.util.LinkedList;

import net.mitza.rel.parser.expression.AdditionExpressionNode;
import net.mitza.rel.parser.expression.AndExpressionNode;
import net.mitza.rel.parser.expression.ComparatorExpressionNode;
import net.mitza.rel.parser.expression.ConstantExpressionNode;
import net.mitza.rel.parser.expression.ExponentiationExpressionNode;
import net.mitza.rel.parser.expression.ExpressionNode;
import net.mitza.rel.parser.expression.FunctionExpressionNode;
import net.mitza.rel.parser.expression.MultiplicationExpressionNode;
import net.mitza.rel.parser.expression.NotExpressionNode;
import net.mitza.rel.parser.expression.OrExpressionNode;
import net.mitza.rel.parser.expression.VariableExpressionNode;

import com.tridion.tcdl.TransformContext;

/**
 * A parser for mathematical and logical expressions. The parser class defines a method parseExpression() which takes a
 * string and returns an ExpressionNode that holds a representation of the mathematical expression. The method
 * parseCondition() parses a logical expression to a 'true' or 'false' value.
 * 
 * Parsing is implemented in the form of a recursive descent parser.
 */
public class Parser {

	// logical -> or_term or_op
	// or_op -> OR or_term or_op
	// or_op -> EPSILON
	//
	// or_term -> and_term and_op
	// and_op -> AND and_term and_op
	// and_op -> EPSILON
	//
	// and_term -> not_term
	// and_term -> NOT not_term
	//
	// not_term -> OPEN_PARENTHESIS logical CLOSE_PARENTHESIS
	// not_term -> proposition
	//
	// proposition -> expression comp_op
	// comp_op -> COMPARATOR expression
	// comp_op -> EPSILON
	//
	//
	// expression -> signed_term sum_op
	// sum_op -> PLUSMINUS term sum_op
	// sum_op -> EPSILON
	//
	// signed_term -> PLUSMINUS term
	// signed_term -> term
	//
	// term -> factor prod_op
	// prod_op -> MULTDIV factor prod_op
	// prod_op -> EPSILON
	//
	// factor -> FUNCTION factor
	// factor -> argument raise_op
	// raise_op -> RAISED argument
	// raise_op -> EPSILON
	//
	// argument -> value
	// argument -> OPEN_PARENTHESIS expression CLOSE_PARENTHESIS
	//
	// value -> NUMBER
	// value -> variable
	//
	// variable -> bean bean_op
	// bean_op -> DOT property bean_op
	// bean_op -> OPEN_BRACKET expression CLOSE_BRACKET bean_op
	// bean_op -> EPSILON

	private final boolean USE_CACHE = true; // performance gain with caching x3.6

	/** the tokens to parse */
	LinkedList<Token> tokens;
	/** the next token */
	Token lookahead;
	private TransformContext context;
	private ExpressionCache cache;

	public Parser() {
		if (USE_CACHE) {
			cache = ExpressionCache.getInstance();
		}
	}

	public Parser(TransformContext context) {
		this();
		this.context = context;
	}

	public ExpressionNode parseCondition(String expression) {
		ExpressionNode logicalExpression = null;
		if (USE_CACHE) {
			logicalExpression = cache.get(expression);
		}

		if (logicalExpression == null) {
			Tokenizer tokenizer = Tokenizer.getExpressionTokenizer();
			tokenizer.tokenize(expression);
			LinkedList<Token> tokens = tokenizer.getTokens();
			logicalExpression = parseCondition(tokens);
			if (USE_CACHE) {
				cache.put(expression, logicalExpression);
			}
		} else {
			logicalExpression.accept(new SetContextVisitor(context));
		}

		return logicalExpression;
	}

	public ExpressionNode parseCondition(LinkedList<Token> tokens) {
		this.tokens = new LinkedList<Token>(tokens);
		lookahead = this.tokens.getFirst();

		ExpressionNode logicalExpression = logicalExpression();
		logicalExpression.accept(new SetContextVisitor(context));

		return logicalExpression;
	}

	/**
	 * Parse a mathematical expression in a string and return an ExpressionNode.
	 * 
	 * This is a convenience method that first converts the string into a linked list of tokens using the expression
	 * tokenizer provided by the Tokenizer class.
	 * 
	 * @param expression
	 *            the string holding the input
	 * @return the internal representation of the expression in form of an expression tree made out of ExpressionNode
	 *         objects
	 */
	public ExpressionNode parseExpression(String expression) {
		ExpressionNode mathematicalExpression = null;
		if (USE_CACHE) {
			mathematicalExpression = cache.get(expression);
		}

		if (mathematicalExpression == null) {
			Tokenizer tokenizer = Tokenizer.getExpressionTokenizer();
			tokenizer.tokenize(expression);
			LinkedList<Token> tokens = tokenizer.getTokens();
			mathematicalExpression = parseExpression(tokens);
			if (USE_CACHE) {
				cache.put(expression, mathematicalExpression);
			}
		} else {
			mathematicalExpression.accept(new SetContextVisitor(context));
		}

		return mathematicalExpression;
	}

	/**
	 * Parse a mathematical expression in contained in a list of tokens and return an ExpressionNode.
	 * 
	 * @param tokens
	 *            a list of tokens holding the tokenized input
	 * @return the internal representation of the expression in form of an expression tree made out of ExpressionNode
	 *         objects
	 */
	public ExpressionNode parseExpression(LinkedList<Token> tokens) {
		this.tokens = new LinkedList<Token>(tokens);
		lookahead = this.tokens.getFirst();

		ExpressionNode mathematicalExpression = mathematicalExpression();
		mathematicalExpression.accept(new SetContextVisitor(context));

		return mathematicalExpression;
	}

	// logical -> or_term or_op
	private ExpressionNode logicalExpression() {
		// only one rule
		// logical -> or_term or_op
		ExpressionNode expression = orTerm();
		expression = orOperation(expression);
		return expression;
	}

	// or_op -> OR or_term or_op
	// or_op -> EPSILON
	private ExpressionNode orOperation(ExpressionNode expression) {
		// or_op -> OR or_term or_op
		if (lookahead.tokenType == TokenTypes.OR) {
			OrExpressionNode disjunction;
			// This means we are actually dealing with an OR
			// If expr is not already an OR, we have to create one
			if (expression.getType() == TokenTypes.OR) {
				disjunction = (OrExpressionNode) expression;
			} else {
				disjunction = new OrExpressionNode(expression);
			}

			nextToken();
			ExpressionNode term = orTerm();
			disjunction.add(term);

			return orOperation(disjunction);
		}

		// or_op -> EPSILON
		return expression;
	}

	// or_term -> and_term and_op
	private ExpressionNode orTerm() {
		// or_term -> and_term and_op
		ExpressionNode term = andTerm();
		return andOperation(term);
	}

	// and_op -> AND and_term and_op
	// and_op -> EPSILON
	private ExpressionNode andOperation(ExpressionNode expression) {
		// and_op -> AND and_term and_op
		if (lookahead.tokenType == TokenTypes.AND) {
			AndExpressionNode conjunction;
			// This means we are actually dealing with an AND
			// If expr is not already an AND, we have to create one
			if (expression.getType() == TokenTypes.AND) {
				conjunction = (AndExpressionNode) expression;
			} else {
				conjunction = new AndExpressionNode(expression);
			}

			nextToken();
			ExpressionNode term = andTerm();
			conjunction.add(term);

			return andOperation(conjunction);
		}

		// and_op -> EPSILON
		return expression;
	}

	// and_term -> not_term
	// and_term -> NOT not_term
	private ExpressionNode andTerm() {
		// and_term -> NOT not_term
		if (lookahead.tokenType == TokenTypes.NOT) {
			nextToken();
			ExpressionNode term = notTerm();
			return new NotExpressionNode(term);
		}

		// and_term -> not_term
		return notTerm();
	}

	// not_term -> OPEN_PARENTHESIS logical CLOSE_PARENTHESIS
	// not_term -> proposition
	private ExpressionNode notTerm() {
		// not_term -> OPEN_PARENTHESIS logical CLOSE_PARENTHESIS
		if (lookahead.tokenType == TokenTypes.OPEN_PARENTHESIS) {
			nextToken();
			ExpressionNode logicalExpression = logicalExpression();
			if (lookahead.tokenType != TokenTypes.CLOSE_PARENTHESIS) {
				throw new ParserException("Closing parenthesis expected", lookahead);
			}
			nextToken();
			return logicalExpression;
		}

		// not_term -> proposition
		return logicalProposition();
	}

	// proposition -> expression comp_op
	private ExpressionNode logicalProposition() {
		// proposition -> expression comp_op
		ExpressionNode expression = mathematicalExpression();
		expression = comparisonOperation(expression);
		return expression;
	}

	// comp_op -> COMPARATOR expression
	// comp_op -> EPSILON
	private ExpressionNode comparisonOperation(ExpressionNode leftHand) {
		// comp_op -> COMPARATOR expression comp_op
		if (lookahead.tokenType == TokenTypes.COMPARATOR) {
			String operator = lookahead.sequence;
			nextToken();
			ExpressionNode rightHand = mathematicalExpression();
			return new ComparatorExpressionNode(leftHand, rightHand, operator);
		}

		// comp_op -> EPSILON
		return leftHand;
	}

	// expression -> signed_term sum_op
	private ExpressionNode mathematicalExpression() {
		// only one rule
		// expression -> signed_term sum_op
		ExpressionNode signedTerm = signedTerm();
		signedTerm = sumOperation(signedTerm);
		return signedTerm;
	}

	// sum_op -> PLUSMINUS term sum_op
	// sum_op -> EPSILON
	private ExpressionNode sumOperation(ExpressionNode expression) {
		// sum_op -> PLUSMINUS term sum_op
		if (lookahead.tokenType == TokenTypes.ADDITION) {
			AdditionExpressionNode sum;
			// This means we are actually dealing with a sum
			// If expr is not already a sum, we have to create one
			if (expression.getType() == TokenTypes.ADDITION) {
				sum = (AdditionExpressionNode) expression;
			} else {
				sum = new AdditionExpressionNode(expression, true);
			}

			// reduce the input and recursively call sum_op
			boolean positive = lookahead.sequence.equals("+");
			nextToken();
			ExpressionNode term = term();
			sum.add(term, positive);

			return sumOperation(sum);
		}

		// sum_op -> EPSILON
		return expression;
	}

	// signed_term -> PLUSMINUS term
	// signed_term -> term
	private ExpressionNode signedTerm() {
		// signed_term -> PLUSMINUS term
		if (lookahead.tokenType == TokenTypes.ADDITION) {
			boolean positive = lookahead.sequence.equals("+");
			nextToken();
			ExpressionNode term = term();
			if (positive) {
				return term;
			} else {
				return new AdditionExpressionNode(term, false);
			}
		}

		// signed_term -> term
		return term();
	}

	// term -> factor prod_op
	private ExpressionNode term() {
		// term -> factor prod_op
		ExpressionNode factor = factor();
		return prodOperation(factor);
	}

	// prod_op -> MULTDIV factor prod_op
	// prod_op -> EPSILON
	private ExpressionNode prodOperation(ExpressionNode expression) {
		// prod_op -> MULTDIV factor prod_op
		if (lookahead.tokenType == TokenTypes.MULTIPLICATION) {
			MultiplicationExpressionNode prod;
			// This means we are actually dealing with a product
			// If expr is not already a product, we have to create one
			if (expression.getType() == TokenTypes.MULTIPLICATION) {
				prod = (MultiplicationExpressionNode) expression;
			} else {
				prod = new MultiplicationExpressionNode(expression, true);
			}

			// reduce the input and recursively call prod_op
			boolean positive = lookahead.sequence.equals("*");
			nextToken();
			ExpressionNode factor = factor();
			prod.add(factor, positive);

			return prodOperation(prod);
		}

		// prod_op -> EPSILON
		return expression;
	}

	// factor -> FUNCTION factor
	// factor -> argument raise_op
	private ExpressionNode factor() {
		// factor -> FUNCTION argument
		if (lookahead.tokenType == TokenTypes.FUNCTION) {
			int function = FunctionExpressionNode.stringToFunction(lookahead.sequence);
			if (function < 0) {
				throw new ParserException("Unexpected Function '%s' found", lookahead);
			}
			nextToken();
			ExpressionNode factor = factor();
			return new FunctionExpressionNode(function, factor);
		}

		// factor -> argument raise_op
		ExpressionNode argument = argument();
		return raiseOperation(argument);
	}

	// raise_op -> RAISED argument
	// raise_op -> EPSILON
	private ExpressionNode raiseOperation(ExpressionNode expression) {
		// raise_op -> RAISED argument
		if (lookahead.tokenType == TokenTypes.EXPONENTIATION) {
			nextToken();
			ExpressionNode exponent = argument();

			return new ExponentiationExpressionNode(expression, exponent);
		}

		// raise_op -> EPSILON
		return expression;
	}

	// argument -> value
	// argument -> OPEN_PARENTHESIS expression CLOSE_PARENTHESIS
	private ExpressionNode argument() {
		// argument -> OPEN_PARENTHESIS expression CLOSE_PARENTHESIS
		if (lookahead.tokenType == TokenTypes.OPEN_PARENTHESIS) {
			nextToken();
			ExpressionNode expression = mathematicalExpression();
			if (lookahead.tokenType != TokenTypes.CLOSE_PARENTHESIS) {
				throw new ParserException("Closing parentehesis expected", lookahead);
			}
			nextToken();
			return expression;
		}

		// argument -> value
		return value();
	}

	// value -> NUMBER
	// value -> VARIABLE
	private ExpressionNode value() {
		// value -> NUMBER
		if (lookahead.tokenType == TokenTypes.VALUE) {
			ExpressionNode constant = new ConstantExpressionNode(lookahead.sequence);
			nextToken();
			return constant;
		}

		// value -> VARIABLE
		if (lookahead.tokenType == TokenTypes.VARIABLE) {
			ExpressionNode variable = variable();
			return variable;
		}

		if (lookahead.tokenType == TokenTypes.EPSILON) {
			throw new ParserException("Unexpected end of input");
		} else {
			throw new ParserException("Unexpected symbol '%s' found", lookahead);
		}
	}

	// variable -> bean bean_op
	private ExpressionNode variable() {
		VariableExpressionNode bean = new VariableExpressionNode(lookahead.sequence);
		nextToken();
		beanOperation(bean);
		return bean;
	}

	// bean_op -> DOT property bean_op
	// bean_op -> OPEN_BRACKET variable CLOSE_BRACKET bean_op
	// bean_op -> EPSILON
	private void beanOperation(VariableExpressionNode bean) {
		// bean_op -> DOT property bean_op
		if (lookahead.tokenType == TokenTypes.DOT) {
			nextToken();
			VariableExpressionNode property = new VariableExpressionNode(lookahead.sequence);
			bean.setProperty(property);
			nextToken();
			beanOperation(property);
			return;
		}

		// bean_op -> OPEN_BRACKET expression CLOSE_BRACKET bean_op
		if (lookahead.tokenType == TokenTypes.OPEN_BRACKET) {
			nextToken();
			ExpressionNode index = mathematicalExpression();
			bean.setIndex(index);
			if (lookahead.tokenType != TokenTypes.CLOSE_BRACKET) {
				throw new ParserException("Closing bracket expected", lookahead);
			}
			nextToken();
			beanOperation(bean);
			return;
		}

		// bean_op -> EPSILON
		return;
	}

	/**
	 * Remove the first token from the list and store the next token in lookahead
	 */
	private void nextToken() {
		tokens.pop();
		// at the end of input we return an epsilon token
		if (tokens.isEmpty()) {
			lookahead = new Token(TokenTypes.EPSILON, "");
		} else {
			lookahead = tokens.getFirst();
		}
	}
}
