package com.usagi.Controller.Action.user;

import java.io.IOException;
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
import com.usagi.dao.Reply.Board.Reply_BoardDAO;
import com.usagi.dao.UserDAO.UserDAO;
import com.usagi.dto.BoardVo.BoardVo;
import com.usagi.dto.ContactVo.ContactVo;
import com.usagi.dto.Reply.Board.Reply_BoardVo;
import com.usagi.dto.UserVo.MyVo;
import com.usagi.dto.gallery.GalleryVo;
import com.usagi.util.paging.PgIndex;

public class MyPageAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();

		String userid = (String) session.getAttribute("id");
		if (userid != null) {

			// mypage에 뿌려줄 페이지네이션
			BoardDAO bdao = BoardDAO.getInstance();
			MyVo mvo = bdao.InfoUser(userid);

			BoardDAO dao = BoardDAO.getInstance();
			String url = "user?command=mypage";
			int nowpage = 1;
			int maxlist = 5; // 한 페이지에 출력할 레코드 , 게시글 설정
			int totpage = 1;
			//
			String addtag = "";
			int totcount = 0;
			// null or not null
			String c1 = request.getParameter("page");

			totcount = dao.BoardAllCount(userid);

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
			List<BoardVo> list = BoardDAO.getInstance().BoardMypageAll(startpage, endpage, userid);
			request.setAttribute("nowpage", nowpage);

			// 코멘트 페이징
			int nowpage2 = 1;
			int maxlist2 = 5; // 한 페이지에 출력할 레코드 , 게시글 설정
			int totpage2 = 1;
			int tocount2 = Reply_BoardDAO.getInstance().Reply_Count(userid);
			if (tocount2 % maxlist2 == 0) { // 전체 글수로 총 페이지 계산
				totpage2 = tocount2 / maxlist2;
			} else {
				totpage2 = tocount2 / maxlist2 + 1;
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

			int hits = dao.BoardAllHitCount(userid);
			System.out.println(hits);

			String page2 = PgIndex.pageList(nowpage2, totpage2, url, addtag);

			Reply_BoardDAO rbdao = Reply_BoardDAO.getInstance();
			List<Reply_BoardVo> comment = rbdao.MyComment(startpage2, endpage2, userid);
			request.setAttribute("nowpage2", nowpage2);

			// Contact Us
			int nowpage3 = 1;
			int maxlist3 = 5; // 한 페이지에 출력할 레코드 , 게시글 설정
			int totpage3 = 1;
			int tocount3 = ContactDAO.getInstance().Contact_Count(userid);
			if (tocount3 % maxlist3 == 0) { // 전체 글수로 총 페이지 계산
				totpage3 = tocount3 / maxlist3;
			} else {
				totpage3 = tocount3 / maxlist3 + 1;
			}

			if (totpage3 == 0) {
				totpage3 = 1; // 총 페이지가 0 이면 1으로 초기화
			}
			if ((c1 != null) && (!c1.equals(""))) {
				nowpage3 = Integer.parseInt(request.getParameter("page"));
			}
			if (nowpage3 > totpage3) // 현재 페이지가 총 페이지 보다 클 때 마지막 페이지로 변환
			{
				nowpage3 = totpage3;
			}

			int startpage3 = (nowpage3 - 1) * maxlist3 + 1;
			int endpage3 = nowpage3 * maxlist3;

			ContactDAO cdao = ContactDAO.getInstance();
			String page3 = PgIndex.pageList(nowpage3, totpage3, url, addtag);

			List<ContactVo> contact = cdao.MyContact(startpage3, endpage3, userid);
			request.setAttribute("nowpage3", nowpage3);
			//
			request.setAttribute("pages", page);
			request.setAttribute("pages2", page2);
			request.setAttribute("pages3", page3);

			request.setAttribute("hit", hits);
			request.setAttribute("ccount", tocount3);
			request.setAttribute("recount", tocount2);
			request.setAttribute("count", totcount);
			request.setAttribute("mylist", list);
			request.setAttribute("comment", comment);
			request.setAttribute("contact", contact);
			request.setAttribute("mvo", mvo);
			
			//GALLERY
			List<GalleryVo> glist = GalleryDAO.getInstance().GalleryUser(userid);
			request.setAttribute("glist", glist);
			//
			request.setAttribute("email", UserDAO.getInstance().UserEmail(userid));
			RequestDispatcher rd = request.getRequestDispatcher("mypage/mypage.jsp");
			rd.forward(request, response);

		} else {
			response.sendRedirect("user?command=MyPwCheck");
		}
	}

}
