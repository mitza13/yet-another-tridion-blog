package test;

import java.io.File;
import java.io.IOException;

import net.sf.jni4net.Bridge;
import tridion.contentmanager.Session;
import tridion.contentmanager.TcmUri;
import tridion.contentmanager.communicationmanagement.ComponentPresentation;
import tridion.contentmanager.communicationmanagement.ComponentTemplate;
import tridion.contentmanager.communicationmanagement.Page;
import tridion.contentmanager.contentmanagement.Component;
import tridion.contentmanager.contentmanagement.fields.ItemFields;
import tridion.contentmanager.contentmanagement.fields.TextField;

/**
 * @author Mihai Cadariu
 */
public class Main {

	private final String dllFolder = "C:\\Users\\Administrator\\Desktop\\Community Webinar\\Tom.Java\\Tom.Java Test\\lib\\";
	private Session session;
	private Log log;

	public static void main(String[] args) throws IOException {
		Main program = new Main();
		program.getPage();
		program.getComponent();
	}

	public Main() throws IOException {
		log = new Log();
		log.debug("Start");

		Bridge.init();
		Bridge.LoadAndRegisterAssemblyFrom(new File(dllFolder + "Tom.Java.Proxy.dll"));
		log.debug("JNI bridge initialized");

		session = new Session();
		log.debug("Tridion session created");
	}

	public void getPage() {
		Page page = new Page(new TcmUri("tcm:1-99-64"), session);
		log.debug("Page title: " + page.getTitle());

		for (ComponentPresentation cp : page.getComponentPresentationsList()) {
			Component component = cp.getComponent();
			ComponentTemplate componentTemplate = cp.getComponentTemplate();
			System.out.println(String.format("\tCP: Component: '%s' %s | Component Template: '%s' %s",
					component.getTitle(), component.getId(), componentTemplate.getTitle(), componentTemplate.getId()));
		}

		log.debug("Page done");
	}

	public void getComponent() {
		Component component = new Component(new TcmUri("tcm:1-36"), session);
		log.debug("Component title: " + component.getTitle());

		ItemFields itemFields = new ItemFields(component.getContent(), component.getSchema());
		log.debug("ItemFields created");

		TextField summaryField = (TextField) itemFields.getItem("Summary");
		log.debug("TextField created");

		System.out.println("\tSummary: " + summaryField.getValue());

		log.debug("Component done");
	}
}
