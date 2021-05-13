package com.koreait.exam.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.exam.MyUtils;

/**
 * Servlet implementation class DelServleet
 */
@WebServlet("/board/del")
public class DelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamToInt(request, "iboard");
		BoardVO vo = new BoardVO();
		vo.setIboard(iboard);
		vo.setIuser(MyUtils.getLoginUserPK(request, response));
		BoardDAO.delBoard(vo);
		
		response.sendRedirect("list");
	}


}
