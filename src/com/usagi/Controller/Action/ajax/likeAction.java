package com.usagi.Controller.Action.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.service.HMC.HMC_DAO;
import com.usagi.dto.service.HMC.HMCVo;

public class likeAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String num = request.getParameter("num");
		HMC_DAO hdao = HMC_DAO.getInstance();
		hdao.likeup(num);
		HMCVo hvo = hdao.HmcOnView(num);

		JSONObject obj = new JSONObject();
		obj.put("like", hvo.getLikes());
		response.setContentType("application/x-json, charset=utf-8");
		response.getWriter().print(obj);
		
	}

}
