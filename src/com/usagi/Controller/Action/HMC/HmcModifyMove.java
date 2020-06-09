package com.usagi.Controller.Action.HMC;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.service.HMC.HMC_DAO;
import com.usagi.dto.service.HMC.HMCVo;

public class HmcModifyMove implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String num = request.getParameter("num");
		HMC_DAO hdao = HMC_DAO.getInstance();
		HMCVo hvo = hdao.HmcOnView(num);
		request.setAttribute("hvo", hvo);
		RequestDispatcher rd = request.getRequestDispatcher("services/HMC/modify/HMCModify.jsp");
		rd.forward(request, response);
		
	}

}
