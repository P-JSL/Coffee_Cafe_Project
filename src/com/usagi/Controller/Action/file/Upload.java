package com.usagi.Controller.Action.file;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.usagi.Controller.Action.Action;

public class Upload implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		 request.setAttribute("id", request.getParameter("id"));
		 System.out.println(request.getParameter("id"));

		// RequestDispatcher rd = request.getRequestDispatcher("File/Upload.jsp");
		// rd.forward(request, response);

		// response.sendRedirect("File/Upload.jsp");
		JSONObject obj = new JSONObject();
		obj.put("urls","File/Upload.jsp");
		obj.put("id", request.getParameter("id"));
		
		response.setContentType("application/x-json, charset=utf-8");
		response.getWriter().print(obj);
		
	}

}
