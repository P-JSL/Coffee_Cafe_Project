package com.usagi.Controller.Action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.NoticeDAO.NoticeDAO;

public class Admin_Notice_Delete_Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String num = request.getParameter("num");
		
		NoticeDAO.getInstance().Notice_Delete(num);
		
		response.sendRedirect("admin?command=adminPage");

	}

}
