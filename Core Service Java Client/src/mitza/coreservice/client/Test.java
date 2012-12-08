package mitza.coreservice.client;

import java.net.Authenticator;
import java.net.URL;

import javax.xml.namespace.QName;

import com.sdltridion.contentmanager.coreservice.CoreService2011;
import com.sdltridion.contentmanager.coreservice.ICoreService;
import com.sdltridion.contentmanager.r6.ComponentData;
import com.sdltridion.contentmanager.r6.FolderData;
import com.sdltridion.contentmanager.r6.ItemType;
import com.sdltridion.contentmanager.r6.ReadOptions;
import com.sdltridion.contentmanager.r6.UserData;

/**
 * @author Mihai Cadariu
 */
public class Test {

	private static final QName Q_NAME = new QName("http://www.sdltridion.com/ContentManager/CoreService",
			"CoreService2011");

	public static void main(String[] args) throws Exception {
		BasicHttpAuthenticator basicHttpAuthenticator = new BasicHttpAuthenticator(args[0], args[1]);
		Authenticator.setDefault(basicHttpAuthenticator);

		URL url = new URL("http://localhost/webservices/CoreService2011.svc?wsdl");
		CoreService2011 service = new CoreService2011(url, Q_NAME);
		ICoreService client = service.getBasicHttp();

		UserData currentUser = client.getCurrentUser();
		System.out.println(String.format("'%s' %s", currentUser.getTitle(), currentUser.getId()));

		ReadOptions readOptions = new ReadOptions();
		ComponentData component = (ComponentData) client.read("tcm:1-852", readOptions);
		System.out.println(String.format("'%s' %s", component.getTitle(), component.getId()));

		FolderData folder = (FolderData) client.getDefaultData(ItemType.FOLDER, "tcm:1-1-2");
		folder = (FolderData) client.save(folder, readOptions);
		System.out.println(String.format("'%s' %s", folder.getTitle(), folder.getId()));
	}
}
