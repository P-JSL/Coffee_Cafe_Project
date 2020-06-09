package com.usagi.Controller.Action.news;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.NewsDAO.NewsDAO;
import com.usagi.dao.Reply.news.Reply_NewsDAO;
import com.usagi.dto.NewsVo.NewsVo;
import com.usagi.dto.Reply.news.Reply_NewsVo;

public class NewsViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String num = request.getParameter("num");
		
		NewsDAO ndao = NewsDAO.getInstance();
		NewsVo nvo = ndao.NewsView(num);
		
		request.setAttribute("nvo", nvo);
		
		List<Reply_NewsVo> list = Reply_NewsDAO.getInstance().NewsReply_View(num);
		int count = Reply_NewsDAO.getInstance().News_Reply_Count(num);
		request.setAttribute("rnvo", list);
		request.setAttribute("comc", count);
		RequestDispatcher rd = request.getRequestDispatcher("newsAction/newsview.jsp");
		rd.forward(request, response);
	}

}
