package com.koreait.board5.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board5.MyUtils;

/**
 * Servlet implementation class UserJoinServlet
 */
@WebServlet("/user/join")
public class UserJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("user/userJoin", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String unm = request.getParameter("unm");
		String upw = request.getParameter("upw");
		int gender = MyUtils.getParamInt("gender", request);
		String hashedUpw = BCrypt.hashpw(upw, BCrypt.gensalt());
		
		UserVO param = new UserVO();
		param.setUid(uid);
		param.setUnm(unm);
		param.setUpw(hashedUpw);
		param.setGender(gender);
		
		UserDAO.insUser(param);
		
		response.sendRedirect("login");
	}

}
