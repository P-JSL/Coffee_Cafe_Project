package com.usagi.Controller.Action.Index;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.NonUserDAO.NonUserDAO;
import com.usagi.dto.NonUserVo.NonUserVo;
import com.usagi.util.MAIL.gmail.gmail;
import com.usagi.util.MAIL.naver.naver;

public class indexAuthAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");

		// 비회원일 경우 보내와 지는 값.
		NonUserVo NUVo = new NonUserVo();
		NonUserDAO NUDao = NonUserDAO.getInstance();

		String name = request.getParameter("name");
		String email = request.getParameter("email");

		NUVo.setName(name);
		NUVo.setEmail(email);

		System.out.println(NUDao.confirmSearch(name));

		if (NUDao.confirmSearch(name) == 1) {
			response.sendRedirect("index?command=main");

		} else {
			String url = "login/none/login.jsp";
			if (NUDao.searchNonUser(name).equals(name)) {
				if (email.substring(email.indexOf("@") + 1).equals("gmail.com")) {
					new gmail(request, response,url);

				} else if (email.substring(email.indexOf("@") + 1).equals("naver.com")) {
					new naver(request, response,url);
				} else {
					response.sendRedirect("index?command=index");
				}
			} else {
				NUDao.NonUserInsert(NUVo); // 비회원 저장

				request.setAttribute("name", name);
				request.setAttribute("email", email);

				if (email.substring(email.indexOf("@") + 1).equals("gmail.com")) {
					new gmail(request, response,url);

				} else if (email.substring(email.indexOf("@") + 1).equals("naver.com")) {
					new naver(request, response,url);
				} else {
					response.sendRedirect("index?command=index");
				}
			}
		}
	}

}
