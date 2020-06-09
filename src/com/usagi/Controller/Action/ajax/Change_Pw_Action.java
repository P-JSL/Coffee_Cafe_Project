package com.usagi.Controller.Action.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.UserDAO.UserDAO;
import com.usagi.util.SHA256.SHA256;

public class Change_Pw_Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pw = SHA256.getEncrypt(request.getParameter("pw"), "COFFEE");
		String email = request.getParameter("email");
		
		UserDAO udao = UserDAO.getInstance();
		int updating = udao.PassWord_Update(id,pw,email);
		
		JSONObject obj = new JSONObject();
		obj.put("update", updating);
		response.setContentType("application/x-json, charset=utf-8");
		response.getWriter().print(obj);

	}

}
