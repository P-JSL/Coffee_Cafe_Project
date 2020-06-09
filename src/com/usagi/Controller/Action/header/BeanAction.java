package com.usagi.Controller.Action.header;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.service.bean.BeanDAO;
import com.usagi.dto.service.bean.BeanVo;

public class BeanAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//response.sendRedirect("services/bean/bean.jsp");
		
		BeanDAO bdao = BeanDAO.getInstance();
		BeanVo bvo = bdao.BeanView();
		
		request.setAttribute("bvo", bvo);
		RequestDispatcher rd = request.getRequestDispatcher("services/bean/bean.jsp");
		rd.forward(request, response);

	}

}
