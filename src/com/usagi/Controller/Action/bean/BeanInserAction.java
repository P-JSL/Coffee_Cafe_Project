package com.usagi.Controller.Action.bean;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.service.bean.BeanDAO;

public class BeanInserAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		String id = new String(request.getParameter("id").getBytes("iso-8859-1"), "utf-8");
		String title =  new String(request.getParameter("title").getBytes("iso-8859-1"), "utf-8");
		String content = new String(request.getParameter("content").getBytes("iso-8859-1"), "utf-8");
		
		
		BeanDAO bdao = BeanDAO.getInstance();
		bdao.BeanInsert(id, title, content);
		
		response.sendRedirect("header?command=Bean");
		
	}

}
