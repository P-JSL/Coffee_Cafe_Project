package com.usagi.Controller.Action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.UserDAO.UserDAO;

public class Admin_User_Unregister_Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		String userid=  request.getParameter("id");
		
		UserDAO.getInstance().C_User_Delete(userid);
		
		response.sendRedirect("admin?command=adminPage");

	}

}
