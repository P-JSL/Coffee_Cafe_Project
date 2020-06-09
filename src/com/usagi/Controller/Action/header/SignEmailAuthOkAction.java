package com.usagi.Controller.Action.header;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.usagi.Controller.Action.Action;

public class SignEmailAuthOkAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String auth = request.getParameter("auth");
		System.out.println(auth);
		HttpSession sessioned = request.getSession();

		String authconfirm = (String) sessioned.getAttribute("AuthenticationKey");

		JSONObject obj = new JSONObject();

		if (auth.equals(authconfirm)) { // 인증번호 입력값 == 인증번호 발생값
			obj.put("OK", "1");
			response.setContentType("application/x-json, charset=utf-8");

			response.getWriter().print(obj);
		} else {
			obj.put("OK", "0");
			response.setContentType("application/x-json, charset=utf-8");

			response.getWriter().print(obj);
		}

	}

}
