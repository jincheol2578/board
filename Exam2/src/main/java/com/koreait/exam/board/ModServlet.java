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
 * Servlet implementation class ModServlet
 */
@WebServlet("/board/mod")
public class ModServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int iboard = MyUtils.getParamToInt(request, "iboard");
		BoardVO vo = BoardDAO.selBoard(iboard);
		request.setAttribute("data", vo);
		
		UserVO loginUser = MyUtils.getSession("loginUser", request);
		int iuser = MyUtils.getLoginUserPK(request, response);

		if (vo.getIuser() != iuser || loginUser == null) {
			response.sendRedirect("/board/list");
			return;
		}
		MyUtils.openJSP(request, response, "board/mod");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int iboard = MyUtils.getParamToInt(request, "iboard");
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");

		BoardVO vo = new BoardVO();
		vo.setIboard(iboard);
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		BoardDAO.updBoard(vo);

		response.sendRedirect("detail?iboard=" + iboard);
	}

}
