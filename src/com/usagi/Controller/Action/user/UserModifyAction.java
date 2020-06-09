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

public class UserModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		UserVo uvo = new UserVo();
		UserDAO udao = UserDAO.getInstance();
		
		String userid = new String(request.getParameter("userid").getBytes("iso-8859-1"), "utf-8");
		String userpw0 = new String(request.getParameter("password").getBytes("iso-8859-1"), "utf-8");
		String userpw = SHA256.getEncrypt(userpw0, "COFFEE");
		String useremail = new String(request.getParameter("useremail").getBytes("iso-8859-1"), "utf-8");
		
		uvo.setUserid(userid);
		uvo.setUseremail(useremail);
		uvo.setUserpw(userpw);
		
		boolean result = udao.UserModify(uvo);
		System.out.println(result);
		RequestDispatcher rd = request.getRequestDispatcher("mypage/myModify.jsp");
		rd.forward(request, response);

	}

}
