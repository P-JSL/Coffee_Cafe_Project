package com.usagi.Controller.Action.HMC;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;

public class HmcWriteMoveAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
		RequestDispatcher rd = request.getRequestDispatcher("services/HMC/write/HMCwrite.jsp");
		rd.forward(request, response);
		
		//response.sendRedirect("services/HMC/write/HMCwrite.jsp");

	}

}
