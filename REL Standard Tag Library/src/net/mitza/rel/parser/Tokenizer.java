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

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.mitza.rel.parser.expression.FunctionExpressionNode;

/**
 * A class for reading an input string and separating it into tokens that can be fed into Parser.
 * 
 * The user can add regular expressions that will be matched against the front of the string. Regular expressions should
 * not contain beginning-of-string or end-of-string anchors or any capturing groups as these will be added by the
 * tokenizer itslef.
 */
public class Tokenizer {

	/**
	 * a list of TokenInfo objects
	 * 
	 * Each token type corresponds to one entry in the list
	 */
	private LinkedList<TokenInfo> tokenInfos;

	/** the list of tokens produced when tokenizing the input */
	private LinkedList<Token> tokens;

	/** a tokenizer that can handle mathematical expressions */
	private static Tokenizer expressionTokenizer = null;

	/**
	 * Default constructor
	 */
	public Tokenizer() {
		super();
		tokenInfos = new LinkedList<TokenInfo>();
		tokens = new LinkedList<Token>();
	}

	/**
	 * A static method that returns a tokenizer for mathematical expressions
	 * 
	 * @return a tokenizer that can handle mathematical expressions
	 */
	public static Tokenizer getExpressionTokenizer() {
		if (expressionTokenizer == null) {
			expressionTokenizer = createExpressionTokenizer();
		}
		return expressionTokenizer;
	}

	/**
	 * A static method that actually creates a tokenizer for mathematical expressions
	 * 
	 * @return a tokenizer that can handle mathematical expressions
	 */
	private static Tokenizer createExpressionTokenizer() {
		Tokenizer tokenizer = new Tokenizer();

		tokenizer.add("[+-]", TokenTypes.ADDITION);
		tokenizer.add("[*/]", TokenTypes.MULTIPLICATION);
		tokenizer.add("\\^", TokenTypes.EXPONENTIATION);

		String funcs = FunctionExpressionNode.getAllFunctions();
		tokenizer.add("(" + funcs + ")(?!\\w)", TokenTypes.FUNCTION);

		tokenizer.add("(==|!=|>=|>|<=|<|eq |neq |lt |le |gt |ge )", TokenTypes.COMPARATOR);
		tokenizer.add("(not|\\!)", TokenTypes.NOT);
		tokenizer.add("(and|&&)", TokenTypes.AND);
		tokenizer.add("(or|\\|\\|)", TokenTypes.OR);
		tokenizer.add("\\(", TokenTypes.OPEN_PARENTHESIS);
		tokenizer.add("\\)", TokenTypes.CLOSE_PARENTHESIS);
		tokenizer.add("(?:\\d+\\.?|\\.\\d)\\d*(?:[Ee][-+]?\\d+)?", TokenTypes.VALUE);
		tokenizer.add("'.*?[^\\\\]'", TokenTypes.STRING);

		tokenizer.add("[\\w-]+", TokenTypes.VARIABLE);
		tokenizer.add("\\.", TokenTypes.DOT);
		tokenizer.add("\\[", TokenTypes.OPEN_BRACKET);
		tokenizer.add("\\]", TokenTypes.CLOSE_BRACKET);

		return tokenizer;
	}

	/**
	 * Add a regular expression and a token id to the internal list of recognized tokens
	 * 
	 * @param regex
	 *            the regular expression to match against
	 * @param token
	 *            the token id that the regular expression is linked to
	 */
	public void add(String regex, TokenTypes token) {
		tokenInfos.add(new TokenInfo(Pattern.compile("^" + regex), token));
	}

	/**
	 * Tokenize an input string.
	 * 
	 * The reult of tokenizing can be accessed via getTokens
	 * 
	 * @param str
	 *            the string to tokenize
	 */
	public void tokenize(String str) {
		String tok;
		String s = str.trim();
		tokens.clear();
		while (!s.equals("")) {
			boolean match = false;
			for (TokenInfo info : tokenInfos) {
				Matcher m = info.regex.matcher(s);
				if (m.find()) {
					match = true;
					TokenTypes tokenType;
					tok = m.group(0).trim();
					if (info.tokenType == TokenTypes.STRING) {
						tok = tok.substring(1, tok.length() - 1).replaceAll("\\\\'", "'");
						tokenType = TokenTypes.VALUE;
					} else {
						tokenType = info.tokenType;
					}

					s = m.replaceFirst("").trim();
					tokens.add(new Token(tokenType, tok));
					break;
				}
			}
			if (!match) {
				throw new ParserException("Unexpected character in input: " + s);
			}
		}
	}

	/**
	 * Get the tokens generated in the last call to tokenize.
	 * 
	 * @return a list of tokens to be fed to Parser
	 */
	public LinkedList<Token> getTokens() {
		return tokens;
	}

	/**
	 * Internal class holding the information about a token type.
	 */
	private class TokenInfo {
		/** the regular expression to match against */
		public final Pattern regex;
		/** the token id that the regular expression is linked to */
		public final TokenTypes tokenType;

		/**
		 * Construct TokenInfo with its values
		 */
		public TokenInfo(Pattern regex, TokenTypes tokenType) {
			super();
			this.regex = regex;
			this.tokenType = tokenType;
		}

		@Override
		public String toString() {
			return String.format("[%s, %s]", regex, tokenType);
		}
	}
}
