package com.usagi.Controller.Action.HMC;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.service.HMC.HMC_DAO;

public class HmcInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		String title =  new String(request.getParameter("h_title").getBytes("iso-8859-1"), "utf-8");
		String content = new String(request.getParameter("h_content").getBytes("iso-8859-1"), "utf-8");
		String userid = new String(request.getParameter("id").getBytes("iso-8859-1"), "utf-8");
		System.out.println(title);
		System.out.println(content);
		System.out.println(userid);
		HMC_DAO.getInstance().HMCInsert(title, content, userid);
		
		response.sendRedirect("header?command=HMC");
		//RequestDispatcher rd = request.getRequestDispatcher("header?command=HMC");
		//rd.forward(request, response);
	}

}
