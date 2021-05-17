package com.koreait.board5.cmt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board5.DBUtils;

public class CmtDAO {
	
	static Connection con =null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	
	public static void insCmt(CmtVO param) {
		String sql = " INSERT INTO t_board_cmt (iuser, iboard, cmt) "
				+ " VALUES (?,?,?) ";;
				
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIuser());
			ps.setInt(2, param.getIboard());
			ps.setString(3, param.getCmt());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { 
			DBUtils.close(con, ps);
		}
		
	}
	public static List<CmtVO> selCmtList(int iboard) {
		String sql = " SELECT A.icmt, A.cmt, A.regdate, B.unm, A.iuser "
				+ " FROM t_board_cmt A"
				+ " INNER JOIN t_user B"
				+ " ON A.iuser = B.iuser "
				+ " WHERE iboard = ?";
		List<CmtVO> list = new ArrayList();
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				CmtVO vo = new CmtVO();
				vo.setIcmt(rs.getInt("icmt"));
				vo.setCmt(rs.getString("cmt"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setUnm(rs.getString("unm"));
				list.add(vo);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
				
		return list;
	}
	public static void delCmt(CmtVO param) {
		String sql = " DELETE FROM t_board_cmt WHERE icmt = ? AND iuser = ?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIcmt());
			ps.setInt(2, param.getIuser());
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}
}
