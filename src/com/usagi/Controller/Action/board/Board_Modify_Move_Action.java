package com.usagi.Controller.Action.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.BoardDAO.BoardDAO;
import com.usagi.dto.BoardVo.BoardVo;

public class Board_Modify_Move_Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String num = request.getParameter("num");
		BoardVo bvo = BoardDAO.getInstance().NumSearch(num);
		
		request.setAttribute("bvo", bvo);
		RequestDispatcher rd = request.getRequestDispatcher("community_another/board/board_modify.jsp");
		rd.forward(request, response);
		

	}

}
