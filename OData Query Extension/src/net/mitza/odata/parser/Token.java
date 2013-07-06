package net.mitza.odata.parser;

/**
 * @author Mihai Cadariu
 */
public class Token {

	final TokenTypes tokenType;
	final String sequence;

	public Token(TokenTypes tokenType, String sequence) {
		this.tokenType = tokenType;
		this.sequence = sequence;
	}

	@Override
	public String toString() {
		return String.format("[%s, %s]", tokenType, sequence);
	}
}
