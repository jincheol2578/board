package com.koreait.exam;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.exam.user.UserVO;

public class MyUtils {
	
	public static int getParamToInt(HttpServletRequest req, String str) {
		if(req==null) return 0;
		return Integer.parseInt(req.getParameter(str));
	}
	
	public static void openJSP(HttpServletRequest req,HttpServletResponse res, String jsp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/"+jsp+".jsp").forward(req, res);
	}

	public static UserVO getSession(String str, HttpServletRequest request) {
		if(request == null) {
			return null;
		}
		HttpSession hs = request.getSession();
		return (UserVO)hs.getAttribute(str);
	}
	public static int getLoginUserPK(HttpServletRequest req, HttpServletResponse res) {
		if(getSession("loginUser", req)==null) return 0;
		return getSession("loginUser", req).getIuser();
	}
	
}
