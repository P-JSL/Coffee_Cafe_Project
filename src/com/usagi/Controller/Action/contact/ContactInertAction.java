package com.usagi.Controller.Action.contact;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.ContactDAO.ContactDAO;
import com.usagi.dto.ContactVo.ContactVo;

public class ContactInertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		request.setCharacterEncoding("utf-8");

		String name = new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
		String id = new String(request.getParameter("id").getBytes("iso-8859-1"),"utf-8");
		String email = new String(request.getParameter("email").getBytes("iso-8859-1"),"utf-8");
		String msg = new String(request.getParameter("msg").getBytes("iso-8859-1"),"utf-8");

		System.out.println(name);
		System.out.println(id);
		System.out.println(email);
		System.out.println(msg);

		ContactDAO cdao = ContactDAO.getInstance();
		
		cdao.ConInsert(new ContactVo(name, id, email, msg));
		
		response.sendRedirect("contact/contact.jsp");
	}

}
