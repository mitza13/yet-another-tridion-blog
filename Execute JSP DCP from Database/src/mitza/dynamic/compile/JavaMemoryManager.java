package mitza.dynamic.compile;

import java.io.IOException;

import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileObject.Kind;
import javax.tools.StandardJavaFileManager;

/**
 * @author Mihai Cadariu
 */
public class JavaMemoryManager extends ForwardingJavaFileManager<StandardJavaFileManager> {

	private JavaMemoryObject javaMemoryObject;

	protected JavaMemoryManager(StandardJavaFileManager fileManager) {
		super(fileManager);
	}

	@Override
	public JavaFileObject getJavaFileForOutput(Location location, String className, Kind kind, FileObject sibling)
			throws IOException {
		javaMemoryObject = new JavaMemoryObject(className, kind);

		return javaMemoryObject;
	}

	public byte[] getBytes() {
		return javaMemoryObject.getBytes();
	}
}
