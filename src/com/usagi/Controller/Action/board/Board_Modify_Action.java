package com.usagi.Controller.Action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.BoardDAO.BoardDAO;
import com.usagi.dto.BoardVo.BoardVo;

public class Board_Modify_Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		String b_title = new String(request.getParameter("title").getBytes("iso-8859-1"), "utf-8");
		String b_content = new String(request.getParameter("content").getBytes("iso-8859-1"), "utf-8");
		String b_id = new String(request.getParameter("id").getBytes("iso-8859-1"), "utf-8");
		int num = Integer.parseInt(request.getParameter("num"));
		
		BoardVo bvo = new BoardVo();
		bvo.setB_id(b_id);
		bvo.setB_content(b_content);
		bvo.setB_title(b_title);
		bvo.setNum(num);
		
		BoardDAO.getInstance().BoardModify(bvo);
		
		response.sendRedirect("user?command=mypage");
	}

}
