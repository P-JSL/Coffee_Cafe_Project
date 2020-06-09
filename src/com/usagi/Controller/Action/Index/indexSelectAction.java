package com.usagi.Controller.Action.Index;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.usagi.Controller.Action.Action;

public class indexSelectAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		String user = request.getParameter("user");
		System.out.println(user);
		if(user == null) {
			user = (String) session.getAttribute("user");
		}
		session.setAttribute("user", user);
		if (user.equals("0")) {

			RequestDispatcher rd = request.getRequestDispatcher("notAllowMember/NotAllow.jsp");
			rd.forward(request, response);
			// response.sendRedirect("notAllowMember/NotAllow.jsp");
		} else if (user.equals("1")) {
			RequestDispatcher rd = request.getRequestDispatcher("login/user/login.jsp");
			rd.forward(request, response);
//			response.sendRedirect("login/user/login.jsp");
		} else if (user.equals("2")) {
			RequestDispatcher rd = request.getRequestDispatcher("login/admin/login.jsp");
			rd.forward(request, response);
//			response.sendRedirect("login/admin/login.jsp");
		}

	}

}
