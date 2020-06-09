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

public class BoardViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String b_num = request.getParameter("num"); // board에서 받아온 num

		BoardDAO bdao = BoardDAO.getInstance();
		BoardVo bvo = bdao.NumSearch(b_num);

		request.setAttribute("bvo", bvo);

		Reply_BoardDAO rbdao = Reply_BoardDAO.getInstance();
		int count = rbdao.Reply_Num_Count(b_num); // 개수
		List<Reply_BoardVo> list = rbdao.Reply_Comment_Search(b_num); // 코멘트

		// bdao.BoardHitCount(b_num);

		request.setAttribute("commentlist", list);
		request.setAttribute("count", count);

		try {
			String onoff = request.getParameter("onoff");
			if (onoff.equals("on")) {
				RequestDispatcher rd = request.getRequestDispatcher("community_another/board/board_lock.jsp");
				rd.forward(request, response);
			} else if (onoff.equals("off")) {
				RequestDispatcher rd = request.getRequestDispatcher("community_another/board/board_view.jsp");
				rd.forward(request, response);
			}
		} catch (NullPointerException e) {
			RequestDispatcher rd = request.getRequestDispatcher("community_another/board/board_view.jsp");
			rd.forward(request, response);
		}

	}

}
