package com.koreait.board4.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board4.MyUtils;
import com.koreait.board4.user.UserVO;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/board/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserVO loginUser = MyUtils.getLoginUser(request);

		if (loginUser == null) {  // 로그아웃 상태면 login 페이지로 이동
			response.sendRedirect("/user/login");
			return;
		}
		List<BoardVO> list = BoardDAO.selBoardList();
		request.setAttribute("list", list);
		MyUtils.openJSP("board/list", request, response);
	}
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		HttpSession hs = request.getSession();
//
//		Boolean loginSuccess = (Boolean) hs.getAttribute("loginSuccess");
//		System.out.println(loginSuccess);
//		if (loginSuccess == null || loginSuccess == false) {
//			response.sendRedirect("/user/login");
//			return;
//		}
//
//		MyUtils.openJSP("board/list", request, response);
//	}

}
