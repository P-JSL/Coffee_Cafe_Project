package com.usagi.Controller.Action.Index;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.NonUserDAO.NonUserDAO;

public class NonUserMailAuthAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		NonUserDAO NUDao = NonUserDAO.getInstance();

		String auth = request.getParameter("auth");
		HttpSession sessioned = request.getSession();
		String log = request.getParameter("login");
		String name = request.getParameter("name");
		System.out.println(log);
		// 로그인 여부
		if (log != null) {
			sessioned.setAttribute("log", log);// 1(true) -- 비회원 인증 확인
			String authconfirm = (String) sessioned.getAttribute("AuthenticationKey");
			sessioned.removeAttribute("AuthenticationKey");
			if (auth.equals(authconfirm)) { // 인증번호 입력값 == 인증번호 발생값
				if (NUDao.searchNonUser(name).equals(name)) {
					NUDao.MailComfirm(name);
					response.sendRedirect("index?command=main");
				} else {
					NUDao.MailComfirm(name);
					response.sendRedirect("index?command=main");
				}
			}
		} else { // 0 (false)
			response.sendRedirect("index?command=index");
		}

	}
}
