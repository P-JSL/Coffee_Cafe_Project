package com.usagi.Controller.Action.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.NoticeDAO.NoticeDAO;
import com.usagi.dto.NoticeVo.NoticeVo;

public class Admin_Notice_Modify_Move implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String num = request.getParameter("num");
		NoticeVo nvo = NoticeDAO.getInstance().NoticeViewer(num);
		
		request.setAttribute("nvo", nvo);
		RequestDispatcher rd = request.getRequestDispatcher("community_another/notice/notice_modify.jsp");
		rd.forward(request, response);
	}

}
