package com.usagi.Controller.Action.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.UserDAO.UserDAO;
import com.usagi.util.SHA256.SHA256;

public class PassWordConfirmAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");

		String id = request.getParameter("userid");
		String pw = SHA256.getEncrypt(request.getParameter("userpw"), "COFFEE");

		UserDAO udao = UserDAO.getInstance();

		String userpw = udao.C_UserPwSearch(id);

		if (pw.equals(userpw)) {
			JSONObject obj = new JSONObject();
			obj.put("ok", 1);
			response.setContentType("application/x-json, charset=utf-8");
			response.getWriter().print(obj);
		} else {
			JSONObject obj = new JSONObject();
			obj.put("ok", 0);
			response.setContentType("application/x-json, charset=utf-8");
			response.getWriter().print(obj);
		}
	}

}
