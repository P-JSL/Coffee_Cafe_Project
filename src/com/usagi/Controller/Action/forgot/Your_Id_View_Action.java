package com.usagi.Controller.Action.forgot;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.UserDAO.UserDAO;

public class Your_Id_View_Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		String email = request.getParameter("email");
		System.out.println(email);
		UserDAO udao = UserDAO.getInstance();
		String id= udao.Your_Id(email);
		
		request.setAttribute("email", email);
		request.setAttribute("yourid", id);
		RequestDispatcher rd = request.getRequestDispatcher("forgot/user/your_id.jsp");
		rd.forward(request, response);
		

	}

}
