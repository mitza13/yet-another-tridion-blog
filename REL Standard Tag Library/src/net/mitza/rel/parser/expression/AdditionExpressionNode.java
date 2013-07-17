/*
 * This software and all files contained in it are distrubted under the MIT license.
 * 
 * Copyright (c) 2013 Cogito Learning Ltd
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package net.mitza.rel.parser.expression;

import net.mitza.rel.parser.TokenTypes;

/**
 * An ExpressionNode that handles additions and subtractions. The node can hold an arbitrary number of terms that are
 * either added or subtraced from the sum.
 * 
 */
public class AdditionExpressionNode extends SequenceExpressionNode {

	/**
	 * Constructor to create an addition with the first term already added.
	 * 
	 * @param node
	 *            the term to be added
	 * @param positive
	 *            a flag indicating whether the term is added or subtracted
	 */
	public AdditionExpressionNode(ExpressionNode node, boolean positive) {
		super(node, positive);
	}

	/**
	 * Returns the type of the node, in this case ExpressionNode.ADDITION
	 */
	@Override
	public TokenTypes getType() {
		return TokenTypes.ADDITION;
	}

	/**
	 * Returns the value of the sub-expression that is rooted at this node.
	 * 
	 * All the terms are evaluated and added or subtracted from the total sum.
	 */
	@Override
	public Object getValue() {
		double sumNumber = 0.0;
		boolean isAllNumber = true;
		String sumString = "";

		for (Term term : terms) {
			Object value = term.expression.getValue();
			double doubleValue = 0.0;
			String stringValue = value.toString();

			try {
				doubleValue = Double.valueOf(stringValue);
			} catch (NumberFormatException nfe) {
				isAllNumber = false;
			}

			if (term.positive) {
				sumNumber += doubleValue;
				sumString += stringValue;
			} else {
				if (value instanceof Double) {
					sumNumber -= (Double) value;
				} else {
					throw new EvaluationException(
							"Substraction operation only defined for numbers, but instead found " + value);
				}
			}
		}

		return isAllNumber ? sumNumber : sumString;
	}

	/**
	 * Implementation of the visitor design pattern.
	 * 
	 * Calls visit on the visitor and then passes the visitor on to the accept method of all the terms in the sum.
	 * 
	 * @param visitor
	 *            the visitor
	 */
	@Override
	public void accept(ExpressionNodeVisitor visitor) {
		visitor.visit(this);
		for (Term term : terms) {
			term.expression.accept(visitor);
		}
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer("Sum[");
		boolean first = true;
		for (Term term : terms) {
			result.append(first ? "" : ", ");
			result.append(String.format("[%s, %s]", term.expression, term.positive ? "+" : "-"));
			first = false;
		}
		result.append("]");
		return result.toString();
	}
}
