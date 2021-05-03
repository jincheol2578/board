package com.crud.exam;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/list")
public class TodoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TodoVO> list = TodoDAO.selList();
		request.setAttribute("data", list);
		
		String jsp = "WEB-INF/view/list.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
		
	}
	

}
