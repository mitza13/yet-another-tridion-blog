package mitza.dynamic.compile;

import java.text.ParseException;

import mitza.dynamic.compile.cache.CacheEntry;
import mitza.dynamic.compile.cache.ClassLoaderCache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tridion.dcp.ComponentPresentation;
import com.tridion.dcp.ComponentPresentationFactory;
import com.tridion.meta.ComponentMeta;
import com.tridion.meta.ComponentMetaFactory;
import com.tridion.util.TCMURI;

/**
 * @author Mihai Cadariu
 */
public class DcpClassLoader extends ClassLoader {

	private final String className;
	private final long lastModified;
	private final ComponentPresentation cp;
	private final Logger log = LoggerFactory.getLogger(DcpClassLoader.class);

	public DcpClassLoader(String componentUri, String componentTemplateUri) throws ParseException {
		super(DcpClassLoader.class.getClassLoader());

		cp = getComponentPresentation(componentUri, componentTemplateUri);
		lastModified = getLastPublicationDate(cp);
		className = String.format("Dcp_%d_%d_%d", cp.getPublicationId(), cp.getComponentId(),
				cp.getComponentTemplateId());
		log.debug("Loader className '{}'", className);
	}

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		ClassLoaderCache cache = ClassLoaderCache.getInstance();
		CacheEntry cacheEntry = cache.get(name);
		if (cacheEntry != null && cacheEntry.getLastModified() > lastModified) {
			log.debug("Return class '{}' from cache", name);
			return cacheEntry.getClazz();
		}

		Class<?> clazz = createExecutorClass(name);
		cache.put(name, clazz);
		log.debug("Add class '{}' to cache, size {}", name, cache.size());

		return clazz;
	}

	public Executable getExecutable() throws ClassNotFoundException {
		try {
			Class<?> clazz = loadClass(className);
			return (Executable) clazz.newInstance();
		} catch (Exception e) {
			log.error("Exception occurred", e);
		}

		return null;
	}

	public String getClassName() {
		return className;
	}

	private ComponentPresentation getComponentPresentation(String componentUri, String componentTemplateUri)
			throws ParseException {
		int publicationId = new TCMURI(componentUri).getPublicationId();
		ComponentPresentationFactory cpFactory = new ComponentPresentationFactory(publicationId);

		return cpFactory.getComponentPresentation(componentUri, componentTemplateUri);
	}

	private long getLastPublicationDate(ComponentPresentation cp) {
		ComponentMetaFactory factory = new ComponentMetaFactory(cp.getPublicationId());
		ComponentMeta meta = factory.getMeta(cp.getComponentId());

		return meta.getLastPublicationDate().getTime();
	}

	private Class<?> createExecutorClass(String name) throws ClassFormatError {
		DcpExecutor executor = new DcpExecutor(name, cp.getContent());
		byte[] classBytes = executor.compile();

		return defineClass(name, classBytes, 0, classBytes.length);
	}
}
