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

package net.mitza.rel.parser;

import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import net.mitza.rel.parser.expression.ExpressionNode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tridion.tcdl.TransformContext;

/**
 * Test the Parser
 */
public class Test {

	private static final Logger log = LoggerFactory.getLogger(Test.class);

	/**
	 * The main method to test the functionality of the parser
	 */
	public static void main(String[] args) {
		log.debug("Start");
		TransformContext context = new TransformContext("", "");
		Map<String, Date> map = new TreeMap<String, Date>();
		map.put("b", new Date());
		context.set("a", map);

		Parser parser = new Parser(context);
		// ExpressionNode expr = parser.parseExpression("sin(pi/2)");
		// expr.accept(new SetVariable("pi", Math.PI));
		// System.out.println("The value of the expression is " + expr.getValue());

		long t = System.currentTimeMillis();
		ExpressionNode expr = null;
		for (int i = 0; i < 1000; i++) {
			expr = parser.parseCondition("2.8 + 0.1*2 == 3 && 22 > 21 + 0.5");
			expr.getBooleanValue();
			expr = parser.parseExpression("a['b'] + ' o\\'clock' + (1 + 2 * 3 - sin(3) / 2 + 2 ^ 3)");
			expr.getValue();
			expr = parser.parseCondition("2.8 + 0.1*2 == 3 && 22 > 21 + 0.6");
			expr.getBooleanValue();
			expr = parser.parseExpression("a['b'] + ' o\\'clock' + (1 + 2 * 3 - sin(3) / 2 + 2 ^ 4)");
			expr.getValue();
		}

		t = System.currentTimeMillis() - t;
		log.debug("Finish. Execution took " + (t / 1000.0) + "s");

		// expr.accept(new SetVariable("a", 1.1));
		// expr.accept(new SetVariable("b", 2));
		// System.out.println("The value of the expression is " + expr.getValue());
		// System.out.println("The boolean value of the expression is " + expr.getBooleanValue());
	}
}