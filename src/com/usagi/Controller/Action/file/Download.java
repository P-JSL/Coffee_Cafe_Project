package com.usagi.Controller.Action.file;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.usagi.Controller.Action.Action;

public class Download implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setAttribute("id", request.getParameter("id"));
		System.out.println(request.getParameter("id"));

		// RequestDispatcher rd = request.getRequestDispatcher("File/Upload.jsp");
		// rd.forward(request, response);
		String id = request.getParameter("id");
		JSONObject obj = new JSONObject();
		obj.put("urls", "File/download.jsp");
		obj.put("id", id);
		//
	
		response.setContentType("application/x-json, charset=utf-8");
		response.getWriter().print(obj);
		// response.sendRedirect("File/download.jsp");
	}

}
