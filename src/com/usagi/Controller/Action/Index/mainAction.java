package com.usagi.Controller.Action.Index;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.BoardDAO.BoardDAO;
import com.usagi.dao.GalleryDAO.GalleryDAO;
import com.usagi.dao.NewsDAO.NewsDAO;
import com.usagi.dao.NoticeDAO.NoticeDAO;
import com.usagi.dto.BoardVo.BoardVo;
import com.usagi.dto.NewsVo.NewsVo;
import com.usagi.dto.NoticeVo.NoticeVo;
import com.usagi.dto.gallery.GalleryVo;

public class mainAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.sendRedirect("main.jsp");
		// 메인 최신글 , TOP5개씩 , 게시판
		List<BoardVo> blist = BoardDAO.getInstance().Board_Top5();
		int bisze = BoardDAO.getInstance().Board_Top5_Count();
		request.setAttribute("bto", bisze);
		request.setAttribute("blist", blist);

		// 메인 최신글, 공지사항
		List<NoticeVo> nlist = NoticeDAO.getInstance().Notice_Top5();
		int nsize = NoticeDAO.getInstance().Notice_Top5_Count();
		request.setAttribute("nto", nsize);
		request.setAttribute("nlist", nlist);

		// 메인 최신글, 뉴스, TOP5
		List<NewsVo> elist = NewsDAO.getInstance().News_Top3();
		int esize = NoticeDAO.getInstance().Notice_Top5_Count();
		request.setAttribute("eto", esize);
		request.setAttribute("elist", elist);

		// 겔러리
		List<GalleryVo> glist = GalleryDAO.getInstance().Gallery_Top4();
		int gto = GalleryDAO.getInstance().Gallery_Top4_Count();

		request.setAttribute("glist", glist);
		request.setAttribute("gto", gto);
		RequestDispatcher rd = request.getRequestDispatcher("main.jsp");
		rd.forward(request, response);
	}

}
