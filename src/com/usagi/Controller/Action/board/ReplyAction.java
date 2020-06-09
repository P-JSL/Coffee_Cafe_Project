package com.usagi.Controller.Action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.Reply.Board.Reply_BoardDAO;

public class ReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");

		String b_num = request.getParameter("num");
	
		String userid = request.getParameter("id");
		String comment = request.getParameter("msg");
		int result = 0;
		Reply_BoardDAO rbdao = Reply_BoardDAO.getInstance();
		JSONObject obj = new JSONObject();
		
		
		if (b_num != null && userid != null && comment != null) {

			result = rbdao.reply_board_insert(b_num, comment, userid);
		}

		
		if (result != 1) {
			System.out.println("에러");
			obj.put("rt", result);
		} else {
			obj.put("rt", result);
			System.out.println("성공");
		}
		response.setContentType("application/x-json, charset=utf-8");
		response.getWriter().print(obj);
		//response.sendRedirect("board?command=boardView");
		//RequestDispatcher rd = request.getRequestDispatcher("board?command=boardView");
		//rd.forward(request, response);
		
		

	}

}
