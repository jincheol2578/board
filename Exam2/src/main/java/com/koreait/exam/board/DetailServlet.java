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
 * Servlet implementation class DetailServlet
 */
@WebServlet("/board/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserVO loginUser = MyUtils.getSession("loginUser", request);

		if (loginUser == null) {
			response.sendRedirect("/user/login");
			return;
		}

		int iboard = MyUtils.getParamToInt(request, "iboard");
		BoardVO param = BoardDAO.selBoard(iboard);
		request.setAttribute("data", param);
		MyUtils.openJSP(request, response, "board/detail");
	}
}
