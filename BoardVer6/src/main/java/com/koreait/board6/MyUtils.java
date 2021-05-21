package com.koreait.board6;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board6.user.UserVO;

public class MyUtils {
	public static void openJSP(String title, String page, HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		req.setAttribute(Const.TITLE , title); // 실수 방지를 위해 Const 클래스 생성
		req.setAttribute(Const.PAGE, page);
		String jsp = "/WEB-INF/view/template.jsp";
		req.getRequestDispatcher(jsp).forward(req, res);
	}

	public static int parseStringToInt(String val) {
		try {
			return Integer.parseInt(val);
		} catch (Exception e) {
			return 0;
		}

	}

	public static int getParamInt(String key, HttpServletRequest req) {
		String result = req.getParameter(key);
		return parseStringToInt(result);
	}

	public static UserVO getLoginUser(HttpServletRequest req) {
		if (req == null) {
			return null;
		}
		HttpSession hs = req.getSession();
		return (UserVO) hs.getAttribute("loginUser");
	}

	public static int getLoginUserPk(HttpServletRequest req) {
//		UserVO vo = getLoginUser(req);
//		return vo.getIuser();
		return getLoginUser(req).getIuser();
	}

	public static void loginCheck(HttpServletRequest req, HttpServletResponse res) throws IOException {
		UserVO loginUser = getLoginUser(req);

		if (loginUser != null) {
			return;
		}
		res.sendRedirect("/user/login");
		return;
	}

}
