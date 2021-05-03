package com.crud.exam;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod")
public class TodoModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
//		request.getRequestDispatcher("/WEB-INF/view/list.jsp").forward(request, resp);
//	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String itodo = request.getParameter("itodo");
		int intItodo = Integer.parseInt(request.getParameter("itodo"));
		String title = request.getParameter("mtitle");
		String ctnt = request.getParameter("mcontent");
		
		System.out.println(itodo+title+ctnt);
		
		TodoVO vo = new TodoVO();
		vo.setiTodo(intItodo);
		vo.setTitle(title);
		vo.setContent(ctnt);
		TodoDAO.modList(vo);
		
		response.sendRedirect("/list");
	
	}

	

}
