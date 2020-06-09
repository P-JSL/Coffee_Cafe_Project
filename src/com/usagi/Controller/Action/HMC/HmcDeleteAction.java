package com.usagi.Controller.Action.HMC;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.service.HMC.HMC_DAO;

public class HmcDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String num = request.getParameter("num");

		HMC_DAO hdao = HMC_DAO.getInstance();
		hdao.HmcDelete(num);

		//RequestDispatcher rd = request.getRequestDispatcher("header?command=HMC");
		//rd.forward(request, response);
		response.sendRedirect("header?command=HMC");

	}

}
