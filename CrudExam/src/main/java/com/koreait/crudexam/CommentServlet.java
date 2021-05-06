package com.koreait.crudexam;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/comment")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String comment = request.getParameter("comment");
		String iboard = request.getParameter("iboard");
		int intIboard = Integer.parseInt(iboard);
		
		CommentVO vo = new CommentVO();
		vo.setUserName(userName);
		vo.setComment(comment);
		vo.setIboard(intIboard);
		CommentDAO.istComment(vo);
		
		response.sendRedirect("/detail?iboard="+iboard);
		
	}

}
