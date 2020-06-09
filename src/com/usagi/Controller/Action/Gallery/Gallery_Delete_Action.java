package com.usagi.Controller.Action.Gallery;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.GalleryDAO.GalleryDAO;

public class Gallery_Delete_Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		String user = session.getAttribute("user").toString();
		String num = request.getParameter("num");

		GalleryDAO.getInstance().Gallery_Delete(num);
		if (user.equals("1")) {
			response.sendRedirect("user?command=mypage");

		} else if (user.equals("2")) {

			response.sendRedirect("admin?command=adminPage");
		}

	}

}
