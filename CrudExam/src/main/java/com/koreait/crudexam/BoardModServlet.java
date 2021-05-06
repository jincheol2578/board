package com.koreait.crudexam;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardModServlet
 */
@WebServlet("/mod")
public class BoardModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardModServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		int intIboard = Integer.parseInt(iboard);
		
		BoardVO vo = new BoardVO();
		vo.setIboard(intIboard);
		vo = BoardDAO.selBoard(vo);
		request.setAttribute("list", vo);
		
		request.getRequestDispatcher("WEB-INF/view/mod.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String iboard = request.getParameter("iboard");
		int intIboard = Integer.parseInt(iboard);
		
		BoardVO vo = new BoardVO();
		vo.setIboard(intIboard);
		vo.setTitle(request.getParameter("title"));
		vo.setContent(request.getParameter("content"));
		BoardDAO.udtBoard(vo);
		
		response.sendRedirect("/detail?iboard="+iboard);
	}

}
