package com.usagi.Controller.Action.ajax;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.UserDAO.UserDAO;

public class SignUpIdCheckAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		List<String> list = UserDAO.getInstance().User();
		String userid = request.getParameter("id");
		System.out.println(userid);
		JSONObject obj = new JSONObject();
		for(String id : list) {
			System.out.println(id.equals(userid)); //false
			if(id.equals(userid)) {
				obj.put("ok", 1); // 중복인경우
			}
		}
		response.setContentType("application/x-json, charset=utf-8");
		response.getWriter().print(obj);
		
	}

}
