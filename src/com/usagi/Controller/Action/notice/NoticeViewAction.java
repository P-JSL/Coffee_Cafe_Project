package com.usagi.Controller.Action.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.NoticeDAO.NoticeDAO;
import com.usagi.dto.NoticeVo.NoticeVo;
import com.usagi.dao.Reply.Notice.Reply_NoticeDAO;
import com.usagi.dto.Reply.Notice.Reply_NoticeVo;

public class NoticeViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		String n_num = request.getParameter("num");
		
		NoticeDAO ndao = NoticeDAO.getInstance();
		System.out.println(n_num);
		NoticeVo nvo = ndao.NoticeViewer(n_num); //뷰
		
		Reply_NoticeDAO rbdao = Reply_NoticeDAO.getInstance();
		int count = rbdao.Reply_Num_Count(n_num); // 개수
		List<Reply_NoticeVo> list = rbdao.Reply_Comment_Search(n_num); // 코멘트
		
		//bdao.BoardHitCount(b_num);
		
		request.setAttribute("nvo", nvo);
		request.setAttribute("clist", list);
		request.setAttribute("count", count);
		
		RequestDispatcher rd = request.getRequestDispatcher("community_another/notice/notice_view.jsp");
		rd.forward(request, response);

	}

}
