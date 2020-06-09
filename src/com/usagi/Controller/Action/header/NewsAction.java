package com.usagi.Controller.Action.header;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.NewsDAO.NewsDAO;
import com.usagi.dto.NewsVo.NewsVo;
import com.usagi.util.paging.PgIndex;

public class NewsAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// response.sendRedirect("news/news.jsp");

		request.setCharacterEncoding("utf-8");

		NewsDAO Ndao = NewsDAO.getInstance();
		String url = "header?command=News";
		int nowpage = 1;
		int maxlist = 2; // 한 페이지에 출력할 레코드 , 게시글 설정
		int totpage = 1;
		//
		String addtag = "";
		int totcount = 0;
		// null or not null

		totcount = Ndao.NewsAllCount();

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
			System.out.println(nowpage);
		}
		if (nowpage > totpage) // 현재 페이지가 총 페이지 보다 클 때 마지막 페이지로 변환
		{
			nowpage = totpage;
		}

		int startpage = 1;
		int endpage = nowpage * maxlist;

		String page = PgIndex.pageList(nowpage, totpage, url, addtag);

		List<NewsVo> list = null;

		list = Ndao.NewsAll(startpage, endpage);

		request.setAttribute("pages", page);
		request.setAttribute("nowpage", nowpage);
		request.setAttribute("list", list);
		request.setAttribute("count", totcount);
		request.setAttribute("totalpage", totpage);
		RequestDispatcher rd = request.getRequestDispatcher("news/news.jsp");
		rd.forward(request, response);

	}

}
