package com.usagi.Controller.Action.bean;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.service.bean.BeanDAO;
import com.usagi.dto.service.bean.BeanVo;

public class BeanModifyMoveAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		BeanDAO bdao = BeanDAO.getInstance();
		BeanVo bvo =bdao.BeanView();
		
		request.setAttribute("bvo", bvo);
		RequestDispatcher rd = request.getRequestDispatcher("services/bean/bean_modify.jsp");
		rd.forward(request, response);
		
	}

}
