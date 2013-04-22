package mitza.coreservice.client;

import mitza.coreservice.util.Utils;

import org.w3c.dom.Element;

import com.sdltridion.contentmanager.coreservice.ICoreService;
import com.sdltridion.contentmanager.coreservice._2012.GetSystemWideListXmlResponse.GetSystemWideListXmlResult;
import com.sdltridion.contentmanager.r6.ArrayOfIdentifiableObjectData;
import com.sdltridion.contentmanager.r6.IdentifiableObjectData;
import com.sdltridion.contentmanager.r6.PublicationData;
import com.sdltridion.contentmanager.r6.PublicationsFilterData;
import com.sdltridion.contentmanager.r6.UserData;

/**
 * @author Mihai Cadariu
 */
public class Test {

	public static void main(String[] args) throws Exception {
		long duration = System.currentTimeMillis();
		System.out.println("Starting...");

		// Fiddler proxy
		// System.setProperty("http.proxyHost", "localhost");
		// System.setProperty("http.proxyPort", "8888");

		if (args.length == 1) { // URL
			CoreServiceFactory.setDefault(args[0]);
		} else if (args.length == 2) { // username, password
			CoreServiceFactory.setDefault(args[0], args[1]);
		} else if (args.length == 3) { // URL, username, password
			CoreServiceFactory.setDefault(args[0], args[1], args[2]);
		} else {
			CoreServiceFactory.setDefault("http://t2013.playground");
		}
		ICoreService client = CoreServiceFactory.getBasicHttpClient();

		duration = System.currentTimeMillis() - duration;
		System.out.println(String.format("Client initialized in %.3fs", duration / 1000.0));
		duration = System.currentTimeMillis();

		System.out.println("Api version: " + client.getApiVersion());

		UserData currentUser = client.getCurrentUser();
		System.out.println("Current user: '" + currentUser.getTitle() + "' '" + currentUser.getDescription() + "' " +
				currentUser.getId());

		System.out.println("Publication objects:");
		PublicationsFilterData filter = new PublicationsFilterData();
		ArrayOfIdentifiableObjectData systemWideList = client.getSystemWideList(filter);
		for (IdentifiableObjectData iod : systemWideList.getIdentifiableObjectData()) {
			PublicationData publication = (PublicationData) iod;
			System.out.println("\t" + publication.getTitle());
		}

		System.out.println("Publications XML:");
		GetSystemWideListXmlResult resultXml = client.getSystemWideListXml(filter);
		Element element = (Element) resultXml.getAny();
		Utils.printDocument(element.getOwnerDocument(), System.out);

		duration = System.currentTimeMillis() - duration;
		System.out.println(String.format("Execution took %.3fs", duration / 1000.0));
	}
}
