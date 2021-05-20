package com.koreait.board5.fav;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.koreait.board5.DBUtils;

public class FavDAO {
	static Connection con = null;
	static PreparedStatement ps = null;
	public static void insFav(int iboard, int iuser) {
		String sql = " INSERT INTO t_board_fav (iboard, iuser)"
				+ " VALUES (?,?)";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			ps.setInt(2, iuser);
			ps.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		
	}
	
	public static void delFav(int iboard, int iuser) {
		String sql = " DELETE FROM t_board_fav WHERE iboard = ? AND iuser = ?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			ps.setInt(2, iuser);
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		
	}
}
