package net.mitza.odata.parser;

/**
 * @author Mihai Cadariu
 */
public class ValueNode {

	private String value;

	public ValueNode(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}
}
