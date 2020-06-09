package com.usagi.Controller.Action.news;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.usagi.Controller.Action.Action;
import com.usagi.dao.NewsDAO.NewsDAO;
import com.usagi.dto.NewsVo.NewsVo;

public class NewsInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		String savePath = "news_upload";
		int saveFileMaxium = 1024 * 1024 * 1024;
		String encType = "utf-8";
		//
		ServletContext context = request.getServletContext();
		String saveRealPath = context.getRealPath(savePath);
		//
		NewsVo nvo = new NewsVo();
		NewsDAO ndao = NewsDAO.getInstance();
		try {
			MultipartRequest multi = new MultipartRequest(request, saveRealPath, saveFileMaxium, encType,
					new DefaultFileRenamePolicy());
			String id = multi.getParameter("id");
			String title = multi.getParameter("n_title");
			String content = multi.getParameter("n_content");
			String photo = multi.getFilesystemName("photo");
			
			nvo.setUserid(id);
			nvo.setTitle(title);
			nvo.setContent(content);
			nvo.setPhoto(photo);
			
			int result =ndao.NewsInsert(nvo);
			if(result == 1) {
				System.out.println("DB Insert 성공");
			}else {
				System.out.println("DB Insert 실패");
			}
			
			response.sendRedirect("header?command=News");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}

}
