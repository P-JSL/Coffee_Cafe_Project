package com.usagi.Controller.Action.header;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.NoticeDAO.NoticeDAO;
import com.usagi.dto.NoticeVo.NoticeVo;
import com.usagi.util.paging.PgIndex;

public class NoticeAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("utf-8");

		NoticeDAO Ndao = NoticeDAO.getInstance();
		String url = "header?command=Notice";
		int nowpage = 1;
		int maxlist = 5; // 한 페이지에 출력할 레코드 , 게시글 설정
		int totpage = 1;
		String sel = request.getParameter("sel");
		// sel == title , content, writer
		String search2 = request.getParameter("search");
		//
		String addtag = "";
		String s_query = "";
		int totcount = 0;
		// null or not null

		if ((search2 != null) && !search2.equals("")) {
			String search = new String(search2.getBytes("iso-8859-1"), "utf-8");
			s_query = sel + " like '%" + search + "%'";
			addtag = "&sel=" + sel + "&search=" + search;
			totcount = Ndao.NoticeAllSearchCount(s_query); // 전체 레코드 수
		} else {
			totcount = Ndao.NoticeAllCount();
		}

		if (totcount % maxlist == 0) { // 전체 글수로 총 페이지 계산
			totpage = totcount / maxlist;
		} else {
			totpage = totcount / maxlist + 1;
		}

		if (totpage == 0) {
			totpage = 1; // 총 페이지가 0 이면 1으로 초기화
		}
		if ((request.getParameter("page") != null) && (!request.getParameter("page").equals(""))) {
			nowpage = Integer.parseInt(request.getParameter("page"));
		}
		if (nowpage > totpage) // 현재 페이지가 총 페이지 보다 클 때 마지막 페이지로 변환
		{
			nowpage = totpage;
		}

		int startpage = (nowpage - 1) * maxlist + 1;
		int endpage = nowpage * maxlist;

		String page = PgIndex.pageList(nowpage, totpage, url, addtag);

		List<NoticeVo> list = null;

		if ((search2 != null) && !search2.equals("")) {
			// 조건을 만족하는 리스트 전체 리스트
			list = Ndao.NoticeAllSearch(s_query, startpage, endpage);
		} else {
			// 조건을 만족하는 리스트 전체 리스트
			list = Ndao.NoticeAll(startpage, endpage);
		}

		request.setAttribute("pages", page);
		request.setAttribute("nowpage", nowpage);
		request.setAttribute("list", list);
		request.setAttribute("count", totcount);
		
		
		if(session.getAttribute("user").toString().equals("1") || session.getAttribute("user").toString().equals("0")) {
			
			RequestDispatcher rd = request.getRequestDispatcher("community/notice/notice.jsp");
			rd.forward(request, response);
		}else if(session.getAttribute("user").toString().equals("2")) {
			
			RequestDispatcher rd = request.getRequestDispatcher("community/notice/notice_admin.jsp");
			rd.forward(request, response);
		}

	}

}
