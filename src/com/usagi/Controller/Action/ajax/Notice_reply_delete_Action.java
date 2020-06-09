package com.usagi.Controller.Action.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.Reply.Notice.Reply_NoticeDAO;
import com.usagi.dto.Reply.Notice.Reply_NoticeVo;

public class Notice_reply_delete_Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		Reply_NoticeDAO rndao = Reply_NoticeDAO.getInstance();
		Reply_NoticeVo rnvo = new Reply_NoticeVo();
		
		String id = request.getParameter("id");
		String num = request.getParameter("num");
		
		int ok = rndao.Reply_Delete(id,num);
		JSONObject obj = new JSONObject();
		obj.put("complete", ok);
		
		response.setContentType("application/x-json, charset=utf-8");
		response.getWriter().print(obj);

	}

}
