package com.koreait.exam.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.exam.MyUtils;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/user/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MyUtils.openJSP(request, response, "user/join");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		String unm = request.getParameter("unm");
		String hashedUpw = BCrypt.hashpw(upw, BCrypt.gensalt());
		int gender = Integer.parseInt(request.getParameter("gender"));

		UserVO param = new UserVO();
		param.setUid(uid);
		param.setUpw(hashedUpw);
		param.setUnm(unm);
		param.setGender(gender);

		UserDAO.insUser(param);
		
		response.sendRedirect("login");
	}

}
