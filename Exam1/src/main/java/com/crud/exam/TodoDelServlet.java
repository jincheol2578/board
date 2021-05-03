package com.crud.exam;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/del")
public class TodoDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String itodo = request.getParameter("itodo");
		int intItodo = Integer.parseInt(itodo);
		
		System.out.println(itodo);
		TodoVO param = new TodoVO();
		param.setiTodo(intItodo);
		TodoDAO.delList(param);
		
		response.sendRedirect("/list");
	}


}
