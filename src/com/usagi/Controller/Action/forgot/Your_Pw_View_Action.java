package com.usagi.Controller.Action.forgot;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;

public class Your_Pw_View_Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		String id= request.getParameter("id");
		String email = request.getParameter("email");
		
		request.setAttribute("id", id);
		request.setAttribute("email", email);
		
		RequestDispatcher rd =request.getRequestDispatcher("forgot/user/your_pw.jsp");
		rd.forward(request, response);

	}

}
