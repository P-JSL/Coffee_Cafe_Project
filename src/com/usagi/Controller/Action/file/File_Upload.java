package com.usagi.Controller.Action.file;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.usagi.Controller.Action.Action;
import com.usagi.dao.FileDAO.FileDAO;
import com.usagi.dto.FileVo.FileVo;

public class File_Upload implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		String savePath = "filefolder";
		int saveFileMaxium = 1024 * 1024 * 1536;
		String encType = "utf-8";
		//
		ServletContext context = request.getServletContext();
		String saveRealPath = context.getRealPath(savePath);
		//
		System.out.println(saveRealPath);

		try {
			MultipartRequest multi = new MultipartRequest(request, saveRealPath, saveFileMaxium, encType,
					new DefaultFileRenamePolicy());

			String id = multi.getParameter("id");
			String files = multi.getFilesystemName("files");
			int fileSize = Integer.parseInt(multi.getParameter("Size"));
			System.out.println(fileSize+"Byte");
			//
			FileVo fvo = new FileVo();
			fvo.setUserid(id);
			fvo.setFiles(files);
			fvo.setSize(fileSize);
			//
			FileDAO fdao = FileDAO.getInstance();
			fdao.File_Insert(fvo);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			RequestDispatcher rd = request.getRequestDispatcher("File/Upload_Close.jsp");
			rd.forward(request, response);
		}

	}
}