package com.koreait.board7.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.koreait.board7.DBUtils;

public class UserDAO {
	public static Connection con = null;
	public static PreparedStatement ps = null;
	public static ResultSet rs = null;
	
	public static int updUser(UserEntity param) {
		String sql = " UPDATE t_user ";
		String updString = null;
		if(param.getUpw() != null && !param.getUpw().equals("")) {
			sql += " SET upw = ? ";
			updString = param.getUpw();
		} else if (param.getProfileImg() != null && !param.getProfileImg().equals("")) {
			sql += " SET profileImg = ? ";
			updString = param.getProfileImg();
		}
		
		sql += " WHERE iuser = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, updString);
			ps.setInt(2, param.getIuser());
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
			return 0;
		}
	}
	
	public static int selIdChk(String uid) {
		//아이디가 있으면 1, 없으면 0 리턴
		String sql = " SELECT uid FROM t_user WHERE uid = ?";
		int result = 0;
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, uid);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = 1;
				
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}	
		
		return result;
	}
	public static UserEntity selUser(UserEntity param) {

		UserEntity result = null;

		String sql = "SELECT iuser, uid, upw, unm, profileImg"
				+ " FROM t_user WHERE uid = ?";

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
				String profileImg = rs.getString("profileImg");
				
				result = new UserEntity();
				result.setIuser(iuser);
				result.setUid(uid);
				result.setUpw(upw);
				result.setUnm(unm);
				result.setProfileImg(profileImg);

			}
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			return result;
		} finally {
			DBUtils.close(con, ps, rs);
		}

	}

	public static int insUser(UserEntity param) {
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
