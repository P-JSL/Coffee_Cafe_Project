package com.usagi.Controller.Action.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.NoticeDAO.NoticeDAO;
import com.usagi.dto.NoticeVo.NoticeVo;

public class Notice_Hit_Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String num = request.getParameter("num");
		
		NoticeDAO ndao = NoticeDAO.getInstance();
		int result = ndao.Notice_Hitup(num);
		
		NoticeVo nvo = ndao.NoticeViewer(num);
		
		JSONObject obj = new JSONObject();
		obj.put("o", result);
		obj.put("nc", nvo.getN_count());
		response.setContentType("application/x-json, charset=utf-8");
		response.getWriter().print(obj);

	}

}
