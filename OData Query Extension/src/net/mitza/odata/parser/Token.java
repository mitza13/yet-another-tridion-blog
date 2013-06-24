package net.mitza.odata.parser;

/**
 * @author Mihai Cadariu
 */
public class Token {
	public final TokenTypes tokenType;
	public final String sequence;

	public Token(TokenTypes tokenType, String sequence) {
		super();
		this.tokenType = tokenType;
		this.sequence = sequence;
	}

	@Override
	public String toString() {
		return String.format("[%s, %s]", tokenType, sequence);
	}
}
