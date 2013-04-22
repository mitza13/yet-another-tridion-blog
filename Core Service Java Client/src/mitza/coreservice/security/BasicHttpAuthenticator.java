package mitza.coreservice.security;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

/**
 * @author Mihai Cadariu
 */
public class BasicHttpAuthenticator extends Authenticator {

	private String user;
	private String password;

	public BasicHttpAuthenticator(String user, String password) {
		this.user = user;
		this.password = password;
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(user, password.toCharArray());
	}
}
