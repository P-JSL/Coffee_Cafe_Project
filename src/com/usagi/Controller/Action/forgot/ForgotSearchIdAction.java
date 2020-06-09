package com.usagi.Controller.Action.forgot;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;
import com.usagi.util.MAIL.gmail.gmail;
import com.usagi.util.MAIL.naver.naver;

public class ForgotSearchIdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		String email = request.getParameter("email");

		String mails = email.substring((email.indexOf("@") + 1)).toLowerCase();

		String url = "";
		// 12자리 비밀번호
		
		//ID 찾기 이전에 이메일 인증 ==> 인증 후 ==> 아이디 나오는 화면
		// 인증화면은 따로 추가
		// 인증 후, ID나오는건 AJAX 처리
		if (mails.equals("gmail.com")) {
			
			new gmail(request, response, url);
			
		} else if (mails.equals("naver.com")) {

			new naver(request, response, url);
		}

	}

}
