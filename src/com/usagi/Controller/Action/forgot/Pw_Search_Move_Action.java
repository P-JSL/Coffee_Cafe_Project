package com.usagi.Controller.Action.forgot;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;

public class Pw_Search_Move_Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//response.sendRedirect("forgot/user/email_pw_check.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("forgot/user/email_pw_check.jsp");
		rd.forward(request, response);
		

	}

}
