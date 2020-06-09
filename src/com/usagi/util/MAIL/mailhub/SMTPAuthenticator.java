package com.usagi.util.MAIL.mailhub;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SMTPAuthenticator extends Authenticator {
	public SMTPAuthenticator() {
		super();
	}
	public PasswordAuthentication getPasswordAuthentication() {
        String username = "althsuwpfl@gmail.com";
        String password = "magese0n$@!$";
        return new PasswordAuthentication(username, password);
    }

}
