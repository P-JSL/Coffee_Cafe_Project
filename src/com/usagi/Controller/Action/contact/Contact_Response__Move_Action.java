package com.usagi.Controller.Action.contact;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.ContactDAO.ContactDAO;
import com.usagi.dto.ContactVo.ContactVo;

public class Contact_Response__Move_Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String num = request.getParameter("num");
		
		ContactVo cvo = ContactDAO.getInstance().ContactSearch(num);
		
		request.setAttribute("cvo", cvo);
		RequestDispatcher rd = request.getRequestDispatcher("contact/contact_res.jsp");
		rd.forward(request, response);

	}

}
