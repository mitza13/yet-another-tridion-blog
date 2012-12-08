package mitza.dynamic.tag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import mitza.dynamic.compile.DcpClassLoader;
import mitza.dynamic.compile.Executable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Mihai Cadariu
 */
public class ComponentPresentationTag extends SimpleTagSupport {

	private String componentUri;
	private String componentTemplateUri;

	private final Logger log = LoggerFactory.getLogger(ComponentPresentationTag.class);

	@Override
	public void doTag() throws JspException {
		try {
			log.debug("componentUri={}, componentTemplateUri={}", componentUri, componentTemplateUri);

			DcpClassLoader loader = new DcpClassLoader(componentUri, componentTemplateUri);
			Executable dcpExecutable = loader.getExecutable();
			log.debug("Got Executable '{}'", dcpExecutable);
			String result = dcpExecutable.execute();

			JspContext context = getJspContext();
			JspWriter out = context.getOut();
			out.write(result);
		} catch (Exception e) {
			log.error("Exception occurred", e);
			throw new JspException(e);
		}
	}

	public String getComponentUri() {
		return componentUri;
	}

	public void setComponentUri(String componentUri) {
		this.componentUri = componentUri;
	}

	public String getComponentTemplateUri() {
		return componentTemplateUri;
	}

	public void setComponentTemplateUri(String componentTemplateUri) {
		this.componentTemplateUri = componentTemplateUri;
	}
}
