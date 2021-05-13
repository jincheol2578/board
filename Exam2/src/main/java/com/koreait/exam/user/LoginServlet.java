package com.koreait.exam.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.exam.MyUtils;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP(request, response, "user/login");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		
		UserVO param = new UserVO();
		param.setUid(uid);
		param.setUpw(upw);
		
		int result = UserDAO.loginUser(param);
		String errMsg = "";
		if(result == 1) {
			HttpSession hs = request.getSession();
			param.setUpw(null);
			hs.setAttribute("loginUser", param);
			
			response.sendRedirect("/board/list");
			
			return;
		}
		switch(result) {
		case 0: 
			errMsg = "에러";
			break;
		case 2:
			errMsg = "비밀번호를 확인해 주세요.";
			break;
		case 3:
			errMsg = "아이디를 확인해 주세요.";
			break;
		}
		request.setAttribute("errMsg", errMsg);
		doGet(request, response);
	}

}
