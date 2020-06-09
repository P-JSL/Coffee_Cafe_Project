package com.usagi.Controller.Action.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.Reply.Notice.Reply_NoticeDAO;

public class NoticeReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		Reply_NoticeDAO rndao = Reply_NoticeDAO.getInstance();
		String b_num = request.getParameter("num");
		String comment = request.getParameter("msg");
		String userid = request.getParameter("id");
		rndao.reply_Notice_insert(b_num, comment, userid);

		JSONObject obj = new JSONObject();
		obj.put("ok", "1");
		obj.put("no", "1");
		response.setContentType("application/x-json, charset=utf-8");
		response.getWriter().print(obj);
		
	}

}
