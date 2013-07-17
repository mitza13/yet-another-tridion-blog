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

import java.util.Collection;

import net.mitza.rel.parser.TokenTypes;

/**
 * An interface for expression nodes.
 * 
 * Every concrete type of expression node has to implement this interface.
 */
public abstract class ExpressionNode {

	/**
	 * Returns the type of the node.ExpressionNode
	 * 
	 * Each class derived from ExpressionNode representing a specific role in the expression should return the type
	 * according to that role.
	 * 
	 * @return type of the node
	 */
	public abstract TokenTypes getType();

	/**
	 * Calculates and returns the value of the sub-expression represented by the node.
	 * 
	 * @return value of expression
	 */
	public abstract Object getValue();

	/**
	 * Method needed for the visitor design pattern
	 * 
	 * @param visitor
	 *            the visitor
	 */
	public abstract void accept(ExpressionNodeVisitor visitor);

	/**
	 * Applies type to the given parameter value. It tries to convert value to Double, is possible.
	 * 
	 * @param value
	 *            Object representing the value
	 * @return Object representing a parsed Double, if possible; or the original object, otherwise
	 */
	public Object applyType(Object value) {
		if (value == null) {
			return null;
		} else if (value instanceof Double) {
			return value;
		} else if (value instanceof Number) {
			return ((Number) value).doubleValue();
		} else if (value instanceof String) {
			try {
				return Double.valueOf((String) value);
			} catch (NumberFormatException nfe) {
				return value;
			}
		} else {
			return value;
		}
	}

	/**
	 * Gets the boolean value of the current value. Calls getValue() internally and evaluates its boolean value.
	 * 
	 * Nulls return false.
	 * 
	 * Numbers returns true, if their double representation is not 0.0.
	 * 
	 * Strings return false, if their length is 0 or if their value is "false". All other Strings return true.
	 * 
	 * Booleans return their value.
	 * 
	 * Collections return false, if they are empty.
	 * 
	 * Anything else returns true.
	 * 
	 * @return boolean value of getValue()
	 */
	public boolean getBooleanValue() {
		Object value = applyType(getValue());
		if (value == null) {
			return false;
		} else if (value instanceof Double) {
			return (Double) value != 0.0;
		} else if (value instanceof String) {
			String stringValue = (String) value;
			return stringValue.length() > 0 && !stringValue.equalsIgnoreCase("false");
		} else if (value instanceof Boolean) {
			return (Boolean) value;
		} else if (value instanceof Object[]) {
			return ((Object[]) value).length > 0;
		} else if (value instanceof Collection) {
			return ((Collection<?>) value).size() > 0;
		}

		return true;
	}
}
