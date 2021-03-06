package com.koreait.board5.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.koreait.board5.DBUtils;

public class UserDAO {
	static Connection con = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	
	public static UserVO selUser(UserVO param) {

		UserVO result = null;

		String sql = "SELECT iuser, uid, upw, unm FROM t_user WHERE uid = ?";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			rs = ps.executeQuery();

			if (rs.next()) {
				int iuser = rs.getInt("iuser");
				String uid = rs.getString("uid");
				String upw = rs.getString("upw");
				String unm = rs.getString("unm");

				result = new UserVO();
				result.setIuser(iuser);
				result.setUid(uid);
				result.setUpw(upw);
				result.setUnm(unm);

			}
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			return result;
		} finally {
			DBUtils.close(con, ps, rs);
		}

	}

	public static int insUser(UserVO param) {
		String sql = " INSERT INTO t_user (uid, upw, unm, gender)"
				+ " VALUES (?,?,?,?) ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			ps.setString(2, param.getUpw());
			ps.setString(3, param.getUnm());
			ps.setInt(4, param.getGender());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		
		return 0;
	}
}
