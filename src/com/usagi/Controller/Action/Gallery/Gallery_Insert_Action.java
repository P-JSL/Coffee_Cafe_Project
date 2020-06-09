package com.usagi.Controller.Action.Gallery;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.usagi.Controller.Action.Action;
import com.usagi.dao.GalleryDAO.GalleryDAO;
import com.usagi.dto.gallery.GalleryVo;

public class Gallery_Insert_Action implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		String savePath = "Galleryupload";
		int saveFileMaxium = 1024 * 1024 * 1024;
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
			String image = multi.getFilesystemName("image");
			//
			GalleryVo gvo = new GalleryVo();
			GalleryDAO gdao = GalleryDAO.getInstance();
			//
			gvo.setUserid(id);
			gvo.setPhoto(image);
			//
			int result = gdao.InsertGallery(gvo);
			//
			request.setAttribute("result", result);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			RequestDispatcher rd = request.getRequestDispatcher("Gallery/GalleryChild_Close.jsp");
			rd.forward(request, response);
		}

	}

}
