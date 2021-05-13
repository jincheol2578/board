package com.koreait.exam.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.exam.MyUtils;
import com.koreait.exam.user.UserVO;

/**
 * Servlet implementation class WirteServlet
 */
@WebServlet("/board/write")
public class WirteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserVO loginUser = MyUtils.getSession("loginUser", request);
		
		if (loginUser == null) {
			response.sendRedirect("/user/login");
			return;
		}
		MyUtils.openJSP(request, response, "/board/write");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int iuser = MyUtils.getLoginUserPK(request, response);
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		BoardVO param = new BoardVO();
		param.setIuser(iuser);
		param.setTitle(title);
		param.setCtnt(ctnt);
		
		BoardDAO.insBoard(param);
		
		response.sendRedirect("list");
	}

}
