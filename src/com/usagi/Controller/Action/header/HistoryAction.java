package com.usagi.Controller.Action.header;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;

public class HistoryAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//response.sendRedirect("services/history/history.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("services/history/history.jsp");
		rd.forward(request, response);

	}

}
