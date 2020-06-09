package com.usagi.Controller.Action.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.UserDAO.UserDAO;
import com.usagi.util.SHA256.SHA256;

public class UserloginAction implements Action {
	private final String SALT = "COFFEE";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		UserDAO udao = UserDAO.getInstance();
		
		HttpSession session = request.getSession();

		String userid = request.getParameter("userid");
		String userpw0 = request.getParameter("userpw");
		int user= Integer.parseInt(request.getParameter("user"));
		//마이페이지 확인을 위한 아이디 세션
		session.setAttribute("id", userid);

		udao.UserLogin(userid);
		System.out.println(userid);
		System.out.println(userpw0);

		String userpw = SHA256.getEncrypt(userpw0, SALT);

		String useremail = request.getParameter("useremail");
		int result = udao.C_UserSearch(userid, userpw, useremail);
		int admin = udao.Admin(userid);
		session.setAttribute("admin", admin);
		request.setAttribute("login", result);
		if(admin == user) {
			user=1;
			session.setAttribute("user", user);
			RequestDispatcher rd = request.getRequestDispatcher("login/user/logcheck.jsp");
			rd.forward(request, response);
		}else {
			response.sendRedirect("index?command=index");
		}

	}

}
