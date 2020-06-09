package com.usagi.Controller.Action.Gallery;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;

public class Gallery_Insert_Move implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		
		RequestDispatcher rd = request.getRequestDispatcher("Gallery/Gallery_Insert.jsp");
		rd.forward(request, response);
		
		//response.sendRedirect("Gallery/Gallery_Insert.jsp");
	}

}
