package com.koreait.board3;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyUtils {
	public static void openJSP(String jsp, HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String filename = "WEB-INF/view/"+jsp+".jsp";
		
		RequestDispatcher rd = req.getRequestDispatcher(filename);
		rd.forward(req, res);
	}
	
	public static int parseStringToInt(String num) {
		try {
			return Integer.parseInt(num);
		} catch (Exception e) {
			return 0;
		}
		
	}

	public static int getParamInt(String key, HttpServletRequest request) {
		String strVal = request.getParameter(key);
		return parseStringToInt(strVal);
	}
}
