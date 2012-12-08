package mitza.dynamic.compile;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mihai Cadariu
 */
public class JavaMemoryCompiler {

	private final Logger log = LoggerFactory.getLogger(JavaMemoryCompiler.class);

	public byte[] compile(String fullyQualifiedClassName, String javaSource) {
		JavaFileObject javaObject = new JavaMemoryObject(fullyQualifiedClassName, javaSource);
		return compile(javaObject);
	}

	public byte[] compile(JavaFileObject javaObject) {
		return compile(javaObject, null);
	}

	public byte[] compile(JavaFileObject javaObject, Iterable<Class<?>> classPaths) {
		long startMillis = System.currentTimeMillis();
		log.debug("Compile '{}'", javaObject.getName());
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		JavaMemoryManager manager = new JavaMemoryManager(compiler.getStandardFileManager(null, null, null));
		Iterable<JavaFileObject> javaObjects = Arrays.asList(javaObject);
		List<String> options = new ArrayList<String>();

		if (classPaths != null) {
			options.add("-cp");
			String classPath = buildClassPath(classPaths);
			options.add(classPath);
		}

		CompilationTask task = compiler.getTask(null, manager, null, options, null, javaObjects);
		if (!task.call()) { // compile error
			log.error("Compilation error");
			throw new RuntimeException("Compilation error");
		}

		long duration = System.currentTimeMillis() - startMillis;
		log.debug("Compile took {}s", duration / 1000.0);
		return manager.getBytes();
	}

	private String buildClassPath(Iterable<Class<?>> classPaths) {
		Set<String> pathSet = new HashSet<String>();
		for (Class<?> clazz : classPaths) {
			pathSet.add(getCompilationPath(clazz));
		}
		StringBuilder classPathBuilder = new StringBuilder();
		for (String path : pathSet) {
			classPathBuilder.append(path).append(";");
		}

		return classPathBuilder.toString();
	}

	private String getCompilationPath(Class<?> clazz) {
		String className = clazz.getName();
		className = className.replace('.', '/') + ".class";
		URL classUrl = getClass().getClassLoader().getResource(className);
		String filePath = classUrl.getPath();

		try {
			int exclamationIndex = filePath.indexOf("!");
			if (exclamationIndex >= 0) { // is jar
				filePath = filePath.substring(0, exclamationIndex);
				classUrl = new URL(filePath);
			} else { // is class
				int extensionIndex = filePath.lastIndexOf(className);
				filePath = filePath.substring(0, extensionIndex);
				classUrl = new URL(classUrl.getProtocol(), classUrl.getHost(), filePath);
			}

			File classFile = new File(classUrl.toURI());
			String path = classFile.getPath();

			return path;
		} catch (Exception e) {
			log.error("Exception occurred", e);
		}

		return null;
	}
}
