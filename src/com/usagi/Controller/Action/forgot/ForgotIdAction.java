package com.usagi.Controller.Action.forgot;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;

public class ForgotIdAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.sendRedirect("forgot/user/fotgot_id.jsp");
//forgot/user/fotgot_id.jsp
	}

}
