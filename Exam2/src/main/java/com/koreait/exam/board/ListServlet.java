package com.koreait.exam.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.exam.MyUtils;
import com.koreait.exam.user.UserVO;

@WebServlet("/board/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserVO loginUser = MyUtils.getSession("loginUser", request);
		
		if(loginUser == null) {
			response.sendRedirect("/user/login");
			return;
		}
		
		List<BoardVO> list = BoardDAO.selBoardList();
		request.setAttribute("data", list);
		MyUtils.openJSP(request, response, "/board/list");
	}

}
