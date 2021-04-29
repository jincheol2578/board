package com.koreait.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mod")
public class BoardModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		
		BoardVO vo = Database.list.get(Integer.parseInt(no));
		request.setAttribute("data", vo);
		
		String jsp = "/WEB-INF/jsp/mod.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String no = request.getParameter("no");
		int intNo = Integer.parseInt(no);
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
//		BoardVO vo = new BoardVO();
//		vo.setTitle(title);
//		vo.setCtnt(ctnt);
//		Database.list.set(intNo,vo);
		BoardVO vo = Database.list.get(intNo);
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		
		response.sendRedirect("/detail?no=" + no);
	}

}
