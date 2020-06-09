package com.usagi.Controller.Action.news;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.Reply.news.Reply_NewsDAO;

public class NewsReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String comment = request.getParameter("comment");
		String n_num = request.getParameter("num");
		
		int o = Reply_NewsDAO.getInstance().NewsReply(id, comment, n_num);

		JSONObject obj = new JSONObject();
		obj.put("ok", o);
		
		response.setContentType("application/x-json, charset=utf-8");
		response.getWriter().print(obj);
		
	}

}
