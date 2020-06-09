package com.usagi.Controller.Action.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.NoticeDAO.NoticeDAO;

public class NoticeInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		String title = new String(request.getParameter("title").getBytes("iso-8859-1"), "utf-8");
		String content = new String(request.getParameter("content").getBytes("iso-8859-1"), "utf-8");
		String id = request.getParameter("id");
		NoticeDAO ndao = NoticeDAO.getInstance();
		ndao.NoticeInsert(title, content,id);
		
		response.sendRedirect("header?command=Notice");

	}

}
