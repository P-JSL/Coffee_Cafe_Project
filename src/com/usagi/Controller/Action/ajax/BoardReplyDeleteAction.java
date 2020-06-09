package com.usagi.Controller.Action.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.BoardDAO.BoardDAO;

public class BoardReplyDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String num = request.getParameter("num");
		System.out.println("id="+id+"  num="+num);
		
		BoardDAO bdao = BoardDAO.getInstance();
		int ok = bdao.BoardReplyDelete(id,num);

		JSONObject obj = new JSONObject();
		obj.put("ok", ok);
		response.setContentType("application/x-json, charset=utf-8");
		response.getWriter().print(obj);
		
	}

}
