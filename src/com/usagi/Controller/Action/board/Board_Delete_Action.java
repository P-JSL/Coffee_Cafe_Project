package com.usagi.Controller.Action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.BoardDAO.BoardDAO;

public class Board_Delete_Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String num = request.getParameter("num");
		
		BoardDAO.getInstance().BoardDelete(num);
		
		response.sendRedirect("user?command=mypage");
		
	}

}
