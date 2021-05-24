package com.koreait.board7.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.board7.MyUtils;

@WebServlet("/user/join")
public class UserJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("회원가입", "user/userJoin", request, response);
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		int gender = MyUtils.getParamInt("gender", request);
		String unm = request.getParameter("unm");
		String hashedPw = BCrypt.hashpw(upw,BCrypt.gensalt());
		
		UserEntity param = new UserEntity();
		param.setUid(uid);
		param.setUpw(hashedPw);
		param.setGender(gender);
		param.setUnm(unm);
		UserDAO.insUser(param);
		
		response.sendRedirect("login");
	}

}
