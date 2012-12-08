package mitza.coreservice.client;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

public class BasicHttpAuthenticator extends Authenticator {

	private String user;
	private String password;

	public BasicHttpAuthenticator(String user, String password) {
		this.user = user;
		this.password = password;
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		PasswordAuthentication auth = new PasswordAuthentication(user, password.toCharArray());
		return auth;
	}
}
