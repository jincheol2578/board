package com.koreait.exam.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.mindrot.jbcrypt.BCrypt;

import com.koreait.exam.DBUtils;

public class UserDAO {
	static Connection con = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	
	public static int insUser(UserVO param) {
		String sql = " INSERT INTO t_user (uid, upw, unm, gender) "
				+ " VALUES (?, ?, ?, ?) ";
		
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
	
	public static int loginUser(UserVO param) {
		String sql = " SELECT * FROM t_user WHERE uid = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getUid());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				if(BCrypt.checkpw(param.getUpw(), rs.getString("upw"))) {  // (dbpw, loginpw) 순서 중요
					param.setIuser(rs.getInt("iuser"));
					param.setUnm(rs.getString("unm"));
					return 1;  // 비밀번호 체크 후 로그인성공
				}else {
					return 2; // 비밀번호 틀림
				}
			}else {
				return 3;	//아이디 없음
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0; // er
		} finally {
			DBUtils.close(con, ps, rs);
		}
		
		
	}
}
