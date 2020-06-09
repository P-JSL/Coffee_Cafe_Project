package com.usagi.Controller.Action.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.BoardDAO.BoardDAO;
import com.usagi.dao.ContactDAO.ContactDAO;
import com.usagi.dao.GalleryDAO.GalleryDAO;
import com.usagi.dao.NoticeDAO.NoticeDAO;
import com.usagi.dao.UserDAO.UserDAO;
import com.usagi.dto.BoardVo.BoardVo;
import com.usagi.dto.ContactVo.ContactVo;
import com.usagi.dto.NoticeVo.NoticeVo;
import com.usagi.dto.UserVo.MyVo;
import com.usagi.dto.UserVo.UserVo;
import com.usagi.dto.gallery.GalleryVo;
import com.usagi.util.paging.PgIndex;

public class AdminPageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("id");

		NoticeDAO dao = NoticeDAO.getInstance();
		String url = "admin?command=adminPage";
		int nowpage = 1;
		int maxlist = 3; // 한 페이지에 출력할 레코드 , 게시글 설정
		int totpage = 1;
		//
		String addtag = "";
		int totcount = 0;
		// null or not null
		String c1 = request.getParameter("page");

		totcount = dao.NoticeAllCount();

		// 기본 페이징 (게시판)
		if (totcount % maxlist == 0) { // 전체 글수로 총 페이지 계산
			totpage = totcount / maxlist;
		} else {
			totpage = totcount / maxlist + 1;
		}

		if (totpage == 0) {
			totpage = 1; // 총 페이지가 0 이면 1으로 초기화
		}
		if ((c1 != null) && (!c1.equals(""))) {
			nowpage = Integer.parseInt(request.getParameter("page"));
		}
		if (nowpage > totpage) // 현재 페이지가 총 페이지 보다 클 때 마지막 페이지로 변환
		{
			nowpage = totpage;
		}

		int startpage = (nowpage - 1) * maxlist + 1;
		int endpage = nowpage * maxlist;
		String page = PgIndex.pageList(nowpage, totpage, url, addtag);
		List<NoticeVo> list = NoticeDAO.getInstance().NoticeAll(startpage, endpage);

		request.setAttribute("page", page);
		request.setAttribute("nowpage", nowpage);
		request.setAttribute("nlist", list);
		request.setAttribute("count", totcount);
		// Notice 를 admin page로 넘겨줌

		ContactDAO cdao = ContactDAO.getInstance();
		int nowpage1 = 1;
		int maxlist1 = 3; // 한 페이지에 출력할 레코드 , 게시글 설정
		int totpage1 = 1;
		//
		String addtag1 = "";
		int totcount1 = 0;
		// null or not null
		totcount1 = cdao.Contact_Count();

		// 기본 페이징 (게시판)
		if (totcount1 % maxlist1 == 0) { // 전체 글수로 총 페이지 계산
			totpage1 = totcount1 / maxlist1;
		} else {
			totpage1 = totcount1 / maxlist1 + 1;
		}

		if (totpage1 == 0) {
			totpage1 = 1; // 총 페이지가 0 이면 1으로 초기화
		}
		if ((c1 != null) && (!c1.equals(""))) {
			nowpage1 = Integer.parseInt(request.getParameter("page"));
		}
		if (nowpage1 > totpage1) // 현재 페이지가 총 페이지 보다 클 때 마지막 페이지로 변환
		{
			nowpage1 = totpage1;
		}

		int startpage1 = (nowpage1 - 1) * maxlist1 + 1;
		int endpage1 = nowpage1 * maxlist1;
		String page1 = PgIndex.pageList(nowpage1, totpage1, url, addtag1);
		List<ContactVo> list1 = ContactDAO.getInstance().Contact(startpage1, endpage1);

		request.setAttribute("page1", page1);
		request.setAttribute("nowpage1", nowpage1);
		request.setAttribute("nlist1", list1);
		request.setAttribute("count1", totcount1);
		// Contact 에 넘겨줄 것

		int nowpage2 = 1;
		int maxlist2 = 3; // 한 페이지에 출력할 레코드 , 게시글 설정
		int totpage2 = 1;
		//
		String addtag2 = "";
		int totcount2 = 0;
		// null or not null
		totcount2 = cdao.UserCount();

		// 기본 페이징 (게시판)
		if (totcount2 % maxlist2 == 0) { // 전체 글수로 총 페이지 계산
			totpage2 = totcount2 / maxlist2;
		} else {
			totpage2 = totcount2 / maxlist2 + 1;
		}

		if (totpage2 == 0) {
			totpage2 = 1; // 총 페이지가 0 이면 1으로 초기화
		}
		if ((c1 != null) && (!c1.equals(""))) {
			nowpage2 = Integer.parseInt(request.getParameter("page"));
		}
		if (nowpage2 > totpage2) // 현재 페이지가 총 페이지 보다 클 때 마지막 페이지로 변환
		{
			nowpage2 = totpage2;
		}

		int startpage2 = (nowpage2 - 1) * maxlist2 + 1;
		int endpage2 = nowpage2 * maxlist2;
		String page2 = PgIndex.pageList(nowpage2, totpage2, url, addtag2);
		List<UserVo> list2 = UserDAO.getInstance().User(startpage2, endpage2);
		request.setAttribute("page2", page2);
		request.setAttribute("nowpage2", nowpage2);
		request.setAttribute("nlist2", list2);
		request.setAttribute("count2", totcount2);

		// USER MANAGEMENT
		int nowpage3 = 1;
		int maxlist3 = 5; // 한 페이지에 출력할 레코드 , 게시글 설정
		int totpage3 = 1;
		String select = request.getParameter("select");
		// sel == title , content, writer
		String search = request.getParameter("search");
		//
		String addtag3 = "";
		String s_query = "";
		int totcount3 = 0;
		// null or not null
		BoardDAO bdao = BoardDAO.getInstance();
		if ((search != null) && !search.equals("")) {
			search = new String(search.getBytes("iso-8859-1"), "utf-8");
			if (select.equals("b_id")) {
				s_query = select + " like '" + search + "'";
			} else {
				s_query = select + " like '%" + search + "%'";
			}
			addtag = "&select=" + select + "&search=" + search;
			totcount3 = bdao.BoardAllSearchCount(s_query); // 전체 레코드 수
		}
		if (totcount3 % maxlist3 == 0) { // 전체 글수로 총 페이지 계산
			totpage3 = totcount3 / maxlist3;
		} else {
			totpage3 = totcount3 / maxlist3 + 1;
		}

		if (totpage3 == 0) {
			totpage3 = 1; // 총 페이지가 0 이면 1으로 초기화
		}
		if ((request.getParameter("page") != null) && (!request.getParameter("page").equals(""))) {
			nowpage3 = Integer.parseInt(request.getParameter("page"));
		}
		if (nowpage3 > totpage3) // 현재 페이지가 총 페이지 보다 클 때 마지막 페이지로 변환
		{
			nowpage3 = totpage3;
		}

		int startpage3 = (nowpage3 - 1) * maxlist3 + 1;
		int endpage3 = nowpage3 * maxlist3;

		String page3 = PgIndex.pageList(nowpage3, totpage3, url, addtag3);
		List<BoardVo> list3 = new ArrayList<BoardVo>();
		if ((search != null) && !search.equals("")) {
			// 조건을 만족하는 리스트 전체 리스트
			list3 = bdao.BoardAllSearch(s_query, startpage3, endpage3);
			int hits = bdao.BoardAllHitCount(userid);
			request.setAttribute("his", hits);
			MyVo mvo = bdao.InfoUser(userid);
			request.setAttribute("mvo", mvo);
			System.out.println(list3.size());
			if (list3.size() == 0) {
				request.setAttribute("uid", "");
			} else {
				request.setAttribute("uid", list3.get(0).getB_id());
			}

		}

		request.setAttribute("page3", page3);
		request.setAttribute("nowpage3", nowpage3);
		request.setAttribute("nlist3", list3);
		request.setAttribute("count3", totcount3);
		// 유저 정보

		// GALLERY
		List<GalleryVo> glist = GalleryDAO.getInstance().GalleryInfo();
		request.setAttribute("glist", glist);

		// BoardDAO.getInstance().selecting(s_query);

		RequestDispatcher rd = request.getRequestDispatcher("admin/adminPage.jsp");
		rd.forward(request, response);

	}

}
