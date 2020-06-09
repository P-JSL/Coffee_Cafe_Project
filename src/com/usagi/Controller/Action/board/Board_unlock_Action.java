package com.usagi.Controller.Action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.BoardDAO.BoardDAO;
import com.usagi.dao.Reply.Board.Reply_BoardDAO;
import com.usagi.dto.BoardVo.BoardVo;
import com.usagi.dto.Reply.Board.Reply_BoardVo;
import com.usagi.util.SHA256.SHA256;

public class Board_unlock_Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String confirm = SHA256.getEncrypt(request.getParameter("b_pw"), "COFFEE");
		String num = request.getParameter("num");
		BoardDAO bdao = BoardDAO.getInstance();
		BoardVo bvo = bdao.NumSearch(num);

		request.setAttribute("bvo", bvo);

		Reply_BoardDAO rbdao = Reply_BoardDAO.getInstance();
		int count = rbdao.Reply_Num_Count(num); // 개수
		List<Reply_BoardVo> list = rbdao.Reply_Comment_Search(num); // 코멘트

		// bdao.BoardHitCount(b_num);
		System.out.println(bvo.getB_pw());
		System.out.println(bvo.getB_pw().equals(confirm));
		request.setAttribute("commentlist", list);
		request.setAttribute("count", count);
		if(confirm.equals(bvo.getB_pw())) {
			RequestDispatcher rd = request.getRequestDispatcher("community_another/board/board_view.jsp");
			rd.forward(request, response);
		}else {
			response.sendRedirect("header?command=Board");
		}
	}

}
