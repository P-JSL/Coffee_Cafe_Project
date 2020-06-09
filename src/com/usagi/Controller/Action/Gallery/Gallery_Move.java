package com.usagi.Controller.Action.Gallery;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usagi.Controller.Action.Action;
import com.usagi.dao.GalleryDAO.GalleryDAO;
import com.usagi.dto.gallery.GalleryVo;

public class Gallery_Move implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		List<GalleryVo> list = GalleryDAO.getInstance().GalleryInfo();
		
		request.setAttribute("glist", list);
		String savePath = "Galleryupload";
		ServletContext context = request.getServletContext();
		String saveRealPath = context.getRealPath(savePath);
		
		request.setAttribute("path", saveRealPath);
		RequestDispatcher rd = request.getRequestDispatcher("Gallery/Gallery.jsp");
		rd.forward(request, response);
		//response.sendRedirect("Gallery/Gallery.jsp");

	}

}
