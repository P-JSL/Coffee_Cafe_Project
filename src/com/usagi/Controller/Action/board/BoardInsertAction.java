package com.usagi.Controller.Action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.BoardDAO.BoardDAO;
import com.usagi.util.SHA256.SHA256;

public class BoardInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");

		String b_title = new String(request.getParameter("title").getBytes("iso-8859-1"), "utf-8");
		String b_content = new String(request.getParameter("content").getBytes("iso-8859-1"), "utf-8");
		String id = new String(request.getParameter("id").getBytes("iso-8859-1"), "utf-8");
		BoardDAO bdao = BoardDAO.getInstance();

		System.out.println(id);
		System.out.println(b_content);
		System.out.println(b_title);

		String onoff = request.getParameter("password-on");
		String b_pw = SHA256.getEncrypt(request.getParameter("b_pw"), "COFFEE");
		System.out.println(request.getParameter("b_pw"));
		bdao.BoardInsert(b_title, b_content, id, onoff, b_pw);

		response.sendRedirect("header?command=Board");
		// RequestDispatcher rd = request.getRequestDispatcher("header?command=Board");
		// rd.forward(request, response);
	}

}
