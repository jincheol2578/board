package com.koreait.board5.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board5.MyUtils;
import com.koreait.board5.user.UserVO;

/**
 * Servlet implementation class BoardWriteServlet
 */
@WebServlet("/board/write")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		MyUtils.loginCheck(request, response);
		
		MyUtils.openJSP("board/boardWrite", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.loginCheck(request, response);
		
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		UserVO loginUser = MyUtils.getLoginUser(request);
		
		BoardVO param = new BoardVO();
		param.setTitle(title);
		param.setCtnt(ctnt);
		param.setIuser(loginUser.getIuser());
		
		BoardDAO.insBoard(param);
		response.sendRedirect("list");
	
	}

}
