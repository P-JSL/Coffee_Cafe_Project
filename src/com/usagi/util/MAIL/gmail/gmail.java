package com.usagi.util.MAIL.gmail;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.usagi.util.MAIL.mailhub.SMTPAuthenticator;

public class gmail {
	// 인증 목록
	// 마이페이지
	// 회원가입 이메일 인증
	//
	public gmail(HttpServletRequest request, HttpServletResponse response,String url) throws UnsupportedEncodingException {

		request.setCharacterEncoding("UTF-8");

		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		String email = (String) session.getAttribute("email");

		if (email == null) {
			email = (String) request.getParameter("email");
		}
		int user = Integer.parseInt((String) session.getAttribute("user")); // 기본 인증 페이지

		System.out.println(user);

		StringBuffer temp = auth_random();
		String AuthentificationKey = temp.toString();
		System.out.println(AuthentificationKey);
		try {

			String mail_from = "althsuwpfl";
			String mail_to = email;
			String title = "인증번호 발송 안내입니다.";

			mail_from = new String(mail_from.getBytes("UTF-8"), "UTF-8");
			mail_to = new String(mail_to.getBytes("UTF-8"), "UTF-8");

			Properties prop = new Properties();
			prop.put("mail.smtp.starttls.enable", "true");
			prop.put("mail.smtp.host", "smtp.gmail.com");
			prop.put("mail.smtp.auth", "true");
			prop.put("mail.smtp.port", "587");

			Authenticator auth = new SMTPAuthenticator();

			Session sess = Session.getDefaultInstance(prop, auth);

			MimeMessage msg = new MimeMessage(sess);

			msg.setFrom(new InternetAddress(mail_from));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(mail_to));
			msg.setSubject(title, "UTF-8");
			msg.setContent("인증번호 : " + temp, "text/html; charset=UTF-8"); // 인증번호
			msg.setHeader("Content-type", "text/html; charset=UTF-8");

			Transport.send(msg);

			HttpSession saveKey = request.getSession();
			saveKey.setAttribute("AuthenticationKey", AuthentificationKey);
		
			RequestDispatcher rd=  request.getRequestDispatcher(url);
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

	}

	public StringBuffer auth_random() {
		// 인증번호 생성
		StringBuffer temp = new StringBuffer();
		Random rnd = new Random();
		for (int i = 0; i < 10; i++) {
			int rIndex = rnd.nextInt(3);
			switch (rIndex) {
			case 0:
				// a-z
				temp.append((char) ((int) rnd.nextInt(26)) + 97);
				break;
			// A-Z
			case 1:
				temp.append((char) ((int) rnd.nextInt(26)) + 65);
				break;
			case 2:
				// 0-9
				temp.append((char) ((int) rnd.nextInt(26)) + 65);
				break;
			}
		}
		return temp;

	}
}
