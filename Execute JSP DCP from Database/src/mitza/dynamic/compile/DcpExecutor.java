package mitza.dynamic.compile;

import java.util.ArrayList;
import java.util.List;

import javax.tools.JavaFileObject;

/**
 * @author Mihai Cadariu
 */
public class DcpExecutor {

	private static final String sourceSkeleton = 
			"import java.io.ByteArrayOutputStream;\r\n" +
			"import java.io.PrintStream;\r\n" + 
			"import mitza.dynamic.compile.Executable;\r\n" + 
			"public class %s implements Executable {\r\n" +
			"	public String execute() {\r\n" +
			"		ByteArrayOutputStream output = new ByteArrayOutputStream();\r\n" +
			"		System.setOut(new PrintStream(output));\r\n" +
			"		%s\r\n" +
			"		return output.toString();\r\n" +
			"	}\r\n" +
			"}";

	private final String className;
	private final String javaSource;

	public DcpExecutor(String className, String javaSource) {
		this.className = className;
		this.javaSource = String.format(sourceSkeleton, className, javaSource);
	}

	public byte[] compile() {
		JavaMemoryCompiler compiler = new JavaMemoryCompiler();
		JavaFileObject javaObject = new JavaMemoryObject(className, javaSource);
		List<Class<? extends Object>> classPath = new ArrayList<Class<? extends Object>>();
		classPath.add(Executable.class);

		return compiler.compile(javaObject, classPath);
	}

	public String getClassName() {
		return className;
	}

	public String getJavaSource() {
		return javaSource;
	}
}
