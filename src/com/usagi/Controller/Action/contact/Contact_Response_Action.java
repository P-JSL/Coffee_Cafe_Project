package com.usagi.Controller.Action.contact;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.ContactDAO.ContactDAO;

public class Contact_Response_Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		String res = new String(request.getParameter("response").getBytes("iso-8859-1"),"utf-8");
		String num = request.getParameter("num");
		System.out.println(num);
		ContactDAO.getInstance().response_ok(num);
		ContactDAO.getInstance().Response(res, num);
		
		response.sendRedirect("admin?command=adminPage");
		
	}

}
