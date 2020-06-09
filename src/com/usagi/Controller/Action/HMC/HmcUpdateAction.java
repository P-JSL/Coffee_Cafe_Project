package com.usagi.Controller.Action.HMC;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.service.HMC.HMC_DAO;
import com.usagi.dto.service.HMC.HMCVo;

public class HmcUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		
		int num = Integer.parseInt(request.getParameter("num"));
		String title = new String(request.getParameter("title").getBytes("iso-8859-1"),"utf-8");
		String content = new String(request.getParameter("content").getBytes("iso-8859-1"),"utf-8");
		
		HMC_DAO hdao = HMC_DAO.getInstance();
		HMCVo hvo = new HMCVo();
		
		//
		hvo.setNum(num);
		hvo.setContent(content);
		hvo.setTitle(title);
		
		hdao.HmcModify(hvo);

		response.sendRedirect("header?command=HMC");
	}

}
