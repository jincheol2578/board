package com.koreait.board5.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board5.MyUtils;

/**
 * Servlet implementation class BoardModServlet
 */
@WebServlet("/board/mod")
public class BoardModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardVO param = new BoardVO();
		param.setIuser(MyUtils.getLoginUserPk(request));
		
		request.setAttribute("data", BoardDAO.selBoard(param));
		System.out.println(param.getTitle());
		MyUtils.openJSP("board/boardMod", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		int iboard = MyUtils.getParamInt("iboard", request);
		
		BoardVO param = new BoardVO();
		param.setTitle(title);
		param.setCtnt(ctnt);
		param.setIboard(iboard);
		
		BoardDAO.modBoard(param);
		
		response.sendRedirect("detail?iboard="+iboard);
	}

}
