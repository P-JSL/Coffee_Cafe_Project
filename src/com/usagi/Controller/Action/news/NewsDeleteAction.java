package com.usagi.Controller.Action.news;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.NewsDAO.NewsDAO;

public class NewsDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String num = request.getParameter("num");
		System.out.println(num);
		NewsDAO ndao = NewsDAO.getInstance();
		ndao.NewsDelete(num);

		// RequestDispatcher rd = request.getRequestDispatcher("header?command=News");
		// rd.forward(request, response);
		response.sendRedirect("header?command=News");

	}

}
