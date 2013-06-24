package net.mitza.odata.parser;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Mihai Cadariu
 */
public class Tokenizer {

	private LinkedList<TokenInfo> tokenInfos;
	private LinkedList<Token> tokens;

	public Tokenizer() {
		tokenInfos = new LinkedList<TokenInfo>();
		tokens = new LinkedList<Token>();
		add("\\(", TokenTypes.OPEN_BRACKET);
		add("\\)", TokenTypes.CLOSE_BRACKET);
		add("or\\s", TokenTypes.OR_OPERATOR);
		add("and\\s", TokenTypes.AND_OPERATOR);
		add("(eq|neq|gt|ge|lt|le|like)\\s", TokenTypes.FIELD_OPERATOR);
		add("'.+?[^\\\\]'", TokenTypes.STRING);
		add("([0-9]+(.[0-9]+)?|true|false)", TokenTypes.VALUE);
		add("(BinaryType|ItemCreationDate|ItemInitialPublishDate|ItemLastPublishedDate|ItemModificationDate|ItemReference|ItemSchema|ItemTitle|Multimedia|PageTemplate|PageURL|Publication|SchemaTitle|"
				+ "PublicationKey|PublicationMultimediaPath|PublicationMultimediaURL|PublicationPath|PublicationTitle|PublicationURL|"
				+ "StructureGroup|StructureGroupDirectory|StructureGroupTitle|Taxonomy|CustomMetaKey|CustomMetaValue)\\s",
				TokenTypes.CRITERIA);
	}

	public void add(String regex, TokenTypes stringLiteral) {
		tokenInfos.add(new TokenInfo(Pattern.compile("^" + regex), stringLiteral));
	}

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
				throw new ParserException("Unexpected token \"" + s.split("\\s")[0] + "\" in input: " + str);
			}
		}
	}

	public LinkedList<Token> getTokens() {
		return tokens;
	}

	private class TokenInfo {
		public final Pattern regex;
		public final TokenTypes tokenType;

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
