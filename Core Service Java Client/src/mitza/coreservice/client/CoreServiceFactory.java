package mitza.coreservice.client;

import java.net.Authenticator;
import java.net.URL;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import mitza.coreservice.security.BasicHttpAuthenticator;

import com.sdltridion.contentmanager.coreservice.CoreService2011;
import com.sdltridion.contentmanager.coreservice.ICoreService;
import com.sdltridion.contentmanager.coreservice.IStreamDownload;
import com.sdltridion.contentmanager.coreservice.IStreamUpload;

/**
 * @author Mihai Cadariu
 */
public class CoreServiceFactory {

	private static final QName Q_NAME = new QName("http://www.sdltridion.com/ContentManager/CoreService",
			"CoreService2011");
	private static final String CORE_SERVICE_PATH = "/webservices/CoreService2011.svc";

	private static String coreServiceBaseUrl = "http://localhost";
	private static String userName;
	private static String password;

	private static CoreService2011 service;
	private static ICoreService basicHttpClient;
	private static IStreamDownload streamDownloadBasicHttpClient;
	private static IStreamUpload streamUploadBasicHttpClient;

	/**
	 * Get the singleton CoreService2011 service object. This method is used internally by the get*Client methods. The
	 * logic uses a WSDL local to the JAR rather than connecting and downloading the WSDL from the remote Core Service
	 * server.
	 * 
	 * @return CoreService2011 the service singleton
	 */
	public static CoreService2011 getService() {
		if (service == null) {
			if (userName != null && password != null) {
				BasicHttpAuthenticator basicHttpAuthenticator = new BasicHttpAuthenticator(userName, password);
				Authenticator.setDefault(basicHttpAuthenticator);
			}

			URL url = CoreServiceFactory.class.getResource("/CoreService2011.wsdl");
			service = new CoreService2011(url, Q_NAME);
		}

		return service;
	}

	/**
	 * Get the singleton CoreService client for the BasicHttp endpoint
	 * 
	 * @return ICoreService the BasicHttp CoreService client
	 */
	public static ICoreService getBasicHttpClient() {
		if (basicHttpClient == null) {
			CoreService2011 service = getService();
			basicHttpClient = service.getBasicHttp();
			setEndpointAddress((BindingProvider) basicHttpClient, "basicHttp");
		}

		return basicHttpClient;
	}

	/**
	 * Get the singleton CoreService client for the StreamDownload endpoint
	 * 
	 * @return IStreamDownload the StreamDownload CoreService client
	 */
	public static IStreamDownload getStreamDownloadBasicHttpClientClient() {
		if (streamDownloadBasicHttpClient == null) {
			CoreService2011 service = getService();
			streamDownloadBasicHttpClient = service.getStreamDownloadBasicHttp();
			setEndpointAddress((BindingProvider) streamDownloadBasicHttpClient, "streamDownload_basicHttp");
		}

		return streamDownloadBasicHttpClient;
	}

	/**
	 * Get the singleton CoreService client for the StreamUpload endpoint
	 * 
	 * @return IStreamUpload the StreamUpload CoreService client
	 */
	public static IStreamUpload getStreamUploadBasicHttpClientClient() {
		if (streamUploadBasicHttpClient == null) {
			CoreService2011 service = getService();
			streamUploadBasicHttpClient = service.getStreamUploadBasicHttp();
			setEndpointAddress((BindingProvider) streamUploadBasicHttpClient, "streamUpload_basicHttp");
		}

		return streamUploadBasicHttpClient;
	}

	/**
	 * Set the default CoreService URL. The user name and password are omitted in this case -- the currently logged in
	 * user is used implicitely.
	 * 
	 * @param coreServiceBaseUrl
	 *            String representing the base URL of the Core Service server to connect to. Most of the times, this is
	 *            the CME URL (e.g. http://contentmanager.url.com).
	 */
	public static void setDefault(String coreServiceBaseUrl) {
		setDefault(coreServiceBaseUrl, null, null);
	}

	/**
	 * Set the default CoreService user and password. The Core Service base URL is omitted in this case -- the URL
	 * http://localhost is used implicitely.
	 * 
	 * @param userName
	 *            String representing the user name to use with authentication. Both simple user names and domain
	 *            prefixed user names are accepted.
	 * @param password
	 *            String representing the password to use with authentication
	 */
	public static void setDefault(String userName, String password) {
		setDefault(null, userName, password);
	}

	/**
	 * Set the default CoreService URL, user name and password.
	 * 
	 * @param coreServiceBaseUrl
	 *            String representing the base URL of the Core Service server to connect to. Most of the times, this is
	 *            the CME URL (e.g. http://contentmanager.url.com).
	 * @param userName
	 *            String representing the user name to use with authentication. Both simple user names and domain
	 *            prefixed user names are accepted.
	 * @param password
	 *            String representing the password to use with authentication
	 */
	public static void setDefault(String coreServiceBaseUrl, String userName, String password) {
		if (coreServiceBaseUrl.endsWith("/")) {
			coreServiceBaseUrl = coreServiceBaseUrl.substring(0, coreServiceBaseUrl.length() - 1);
		}
		CoreServiceFactory.coreServiceBaseUrl = coreServiceBaseUrl;
		CoreServiceFactory.userName = userName;
		CoreServiceFactory.password = password;
	}

	private static void setEndpointAddress(BindingProvider binding, String endpoint) {
		Map<String, Object> context = binding.getRequestContext();
		String address = coreServiceBaseUrl + CORE_SERVICE_PATH + "/" + endpoint;
		context.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, address);
	}
}
