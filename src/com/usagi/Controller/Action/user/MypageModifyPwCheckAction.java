package com.usagi.Controller.Action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.UserDAO.UserDAO;
import com.usagi.util.SHA256.SHA256;

public class MypageModifyPwCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String userid = request.getParameter("userid");
		String userpw1 = request.getParameter("userpw");
		String userpw = SHA256.getEncrypt(userpw1, "COFFEE");
		
		UserDAO udao = UserDAO.getInstance();
		JSONObject obj = null;
		
		String password = "";
		password = udao.C_UserPwSearch(userid);
		if (password.equals(userpw)) {
			 obj = new JSONObject();
			obj.put("success", "1");
			response.setContentType("application/x-json, charset=utf-8");
			response.getWriter().print(obj);
		}else {
			obj = new JSONObject();
			obj.put("success", "0");
			response.setContentType("application/x-json, charset=utf-8");
			response.getWriter().print(obj);
		}
	}

}
