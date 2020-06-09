package com.usagi.Controller.Action.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.Reply.Board.Reply_BoardDAO;

public class My_Reply_Delete_Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String num = request.getParameter("num");

		Reply_BoardDAO.getInstance().Board_Comment_Delete(num);
		
		response.sendRedirect("user?command=mypage");
		
	}

}
