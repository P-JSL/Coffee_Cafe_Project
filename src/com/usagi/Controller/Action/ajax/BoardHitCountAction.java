package com.usagi.Controller.Action.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.BoardDAO.BoardDAO;
import com.usagi.dto.BoardVo.BoardVo;

public class BoardHitCountAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		BoardDAO bdao = BoardDAO.getInstance();
		String b_num = request.getParameter("num");
		System.out.println(b_num);
		
		int hit = bdao.BoardHitCount(b_num);

		BoardVo bvo = bdao.NumSearch(b_num);
		JSONObject obj = new JSONObject();
		obj.put("hit", hit);
		obj.put("bc", bvo.getB_count());
		
		response.setContentType("application/x-json, charset=utf-8");
		response.getWriter().print(obj);
		
	}

}
