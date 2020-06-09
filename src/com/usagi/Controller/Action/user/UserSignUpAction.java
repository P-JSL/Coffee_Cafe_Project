package com.usagi.Controller.Action.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.UserDAO.UserDAO;
import com.usagi.dto.UserVo.UserVo;
import com.usagi.util.SHA256.SHA256;

public class UserSignUpAction implements Action {
	private String salt = "COFFEE";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");

		UserVo uvo = new UserVo();
		UserDAO udao = UserDAO.getInstance();

		String userid = new String(request.getParameter("userid").getBytes("iso-8859-1"), "utf-8");
		String name = new String(request.getParameter("name").getBytes("iso-8859-1"), "utf-8");
		String userpw0 = new String(request.getParameter("userpw").getBytes("iso-8859-1"), "utf-8");
		int gender0 = Integer.parseInt(request.getParameter("gender"));
		String useremail = new String(request.getParameter("email").getBytes("iso-8859-1"), "utf-8");

		boolean over = UserDAO.getInstance().UserMail(useremail);
		if (over) { // 중복이 있는 경우
			RequestDispatcher rd = request.getRequestDispatcher("signup/signup.jsp");
			rd.forward(request, response);
		} else { // 중복이 없는 경우
			int mail_confirm = Integer.parseInt(request.getParameter("mail_confirm"));
			String gender = "";
			if (gender0 == 1) {
				gender = "男性";
			} else {
				gender = "女性";
			}

			String userpw = SHA256.getEncrypt(userpw0, salt);

			uvo.setUserid(userid);
			uvo.setName(name);
			uvo.setUserpw(userpw);
			uvo.setGender(gender);
			uvo.setUseremail(useremail);
			uvo.setMail_confirm(mail_confirm);

			int result = udao.C_UserInsert(uvo);

			request.setAttribute("result", result);
			RequestDispatcher rd = request.getRequestDispatcher("signup/signupOk.jsp");
			rd.forward(request, response);

		}

	}

}
