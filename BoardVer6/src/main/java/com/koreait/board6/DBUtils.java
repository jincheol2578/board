package com.koreait.board6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

public class DBUtils {
	
	public static Connection getCon() throws Exception{
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		final String USER_NAME = "root";
		final String PASSWORD = "koreait";
		final String URL = "jdbc:mysql://localhost:3308/boardver4";
		
		Class.forName(DRIVER);
		Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		
		return con;
	}

	public static void close(Connection con, PreparedStatement ps) {
		close(con,ps,null);
	}
	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
//		Connection, PreparedStatement : CRUD 필수   /  ResultSet : SELECT할때 사용  
		if (rs != null) {
			try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
	}
		if (ps != null) {
			try { ps.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		if (con != null) {
			try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
	
	}

}
