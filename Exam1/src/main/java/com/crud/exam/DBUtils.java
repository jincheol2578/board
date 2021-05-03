package com.crud.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {
	public static Connection getCon() throws Exception{
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		final String USER_NAME = "root";
		final String PASSWORD = "koreait";
		final String URL = "jdbc:mysql://localhost:3308/todolist";
		
		Class.forName(DRIVER);
		Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
		
		return con;
	}

	public static void close(Connection con, PreparedStatement ps) {
		close(con,ps,null);
	}
	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
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
