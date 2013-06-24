package net.mitza.odata.parser;

@SuppressWarnings("serial")
public class ParserException extends RuntimeException {

	public ParserException(String messsage) {
		super(messsage);
	}

	public ParserException(Throwable throwable) {
		super(throwable);
	}

	public ParserException(String messsage, Throwable throwable) {
		super(messsage, throwable);
	}
}
