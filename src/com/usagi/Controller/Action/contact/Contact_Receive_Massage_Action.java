package com.usagi.Controller.Action.contact;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.ContactDAO.ContactDAO;
import com.usagi.dto.ContactVo.ContactVo;

public class Contact_Receive_Massage_Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String num = request.getParameter("num");
		System.out.println(num);
		ContactVo cvo = ContactDAO.getInstance().ContactSearch(num);

		JSONObject obj = new JSONObject();
		obj.put("admin", "管理者");
		if (cvo.getResponse() != null) {

			obj.put("msg", URLEncoder.encode(cvo.getResponse(), "utf-8"));
		} else {
			obj.put("msg", "N/A");
		}
		obj.put("id", new String(cvo.getId().getBytes("iso-8859-1"), "utf-8"));

		response.setContentType("application/x-json, charset=utf-8");
		response.getWriter().print(obj);

		// request.setAttribute("re_Msg", cvo.getResponse());

		// RequestDispatcher rd =
		// request.getRequestDispatcher("contact/contact_user_recive.jsp");
		// rd.forward(request, response);

	}

}
