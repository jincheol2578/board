package com.koreait.board3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardWriteServlet3
 */
@WebServlet("/write3")
public class BoardWriteServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = "WEB-INF/view/write3.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		System.out.println(title+ctnt);
		BoardVO3 vo = new BoardVO3();
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		
		response.sendRedirect("/list3");
		
	}

}
