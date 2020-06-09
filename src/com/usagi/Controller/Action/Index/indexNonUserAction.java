package com.usagi.Controller.Action.Index;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.usagi.Controller.Action.Action;

public class indexNonUserAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		String user = request.getParameter("user");
		System.out.println(user);
		session.setAttribute("user", user);
		if(user.equals("0")) {
			
			request.getRequestDispatcher("shed.jsp").forward(request, response);
		}else {
			response.sendRedirect("login?command=loginSelect");
		}

	}

}
