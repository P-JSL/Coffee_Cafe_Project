package com.usagi.Controller.Action.file;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.FileDAO.FileDAO;
import com.usagi.dto.FileVo.FileVo;

public class file_download implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");

		FileDAO fdao = FileDAO.getInstance();
		List<FileVo> flist = fdao.File_Allload(); // 전체조회
		List<FileVo> fflist = fdao.File_download(id);// 자기꺼 조회
		
		request.setAttribute("AllFiles", flist);
		request.setAttribute("UserFiles", fflist);
		ServletContext context = request.getServletContext();

		String path = context.getRealPath("filefolder");
		request.setAttribute("path", path);
	
		RequestDispatcher rd = request.getRequestDispatcher("File/downFile.jsp");
		rd.forward(request, response);
		
	}

}
