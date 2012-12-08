package mitza.dynamic.compile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

import javax.tools.SimpleJavaFileObject;

/**
 * @author Mihai Cadariu
 */
public class JavaMemoryObject extends SimpleJavaFileObject {

	private final String javaSource;
	private final ByteArrayOutputStream bos = new ByteArrayOutputStream();

	public JavaMemoryObject(String className, String javaSource) {
		super(getUri(className, Kind.SOURCE), Kind.SOURCE);
		this.javaSource = javaSource;
	}

	public JavaMemoryObject(String className, Kind kind) {
		super(getUri(className, kind), kind);
		this.javaSource = null;
	}

	public byte[] getBytes() {
		return bos.toByteArray();
	}

	@Override
	public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
		return javaSource;
	}

	@Override
	public OutputStream openOutputStream() throws IOException {
		return bos;
	}

	private static URI getUri(String className, Kind kind) {
		return URI.create("string:///" + className.replace('.', '/') + kind.extension);
	}
}
