package com.crud.exam;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/write")
public class TodoWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String itodo = request.getParameter("itodo");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
//		int intItodo = Integer.parseInt(itodo);
		
		TodoVO vo = new TodoVO();
//		vo.setiTodo(intItodo);
		vo.setTitle(title);
		vo.setContent(content);
		
		TodoDAO.ist(vo);
		response.sendRedirect("/list");
	}

}
