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
 * Servlet implementation class BoardDelServlet
 */
@WebServlet("/board/del")
public class BoardDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVO loginUser = MyUtils.getLoginUser(request);

		if (loginUser == null) {
			response.sendRedirect("/user/login");
			return;
		}
		
		int iboard = MyUtils.getParamInt("iboard", request);
		int iuser = MyUtils.getLoginUserPk(request);
		
		BoardVO param = new BoardVO();
		param.setIboard(iboard);
		param.setIuser(iuser);
		
		BoardDAO.delBoard(param);
		
		response.sendRedirect("list");
	}


}
