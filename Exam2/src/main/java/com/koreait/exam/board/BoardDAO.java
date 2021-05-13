package com.koreait.exam.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.exam.DBUtils;
import com.koreait.exam.MyUtils;

public class BoardDAO {
	static Connection con = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	
	public static int insBoard(BoardVO param) {
		String sql = " INSERT INTO t_board (iuser, title, ctnt)"
				+ " VALUES (?,?,?) ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIuser());
			ps.setString(2, param.getTitle());
			ps.setString(3, param.getCtnt());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
				
		return 0;
	}

	public static List<BoardVO> selBoardList() {
		String sql = " SELECT A.title, B.unm, A.iuser, A.regdt, A.iboard "
				+ " FROM t_board A "
				+ " LEFT JOIN t_user B "
				+ " ON A.iuser = B.iuser "
				+ " ORDER BY iboard DESC ";
		List<BoardVO> list = new ArrayList();
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setUnm(rs.getString("unm"));
				vo.setRegdt(rs.getString("regdt"));
				
				list.add(vo);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return list;
	}

	public static BoardVO selBoard(int iboard) {
		String sql = " SELECT A.title, B.unm, A.iuser, A.regdt, A.ctnt "
				+ " FROM t_board A "
				+ " LEFT JOIN t_user B "
				+ " ON A.iuser = B.iuser "
				+ " WHERE iboard = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setTitle(rs.getString("title"));
				vo.setCtnt(rs.getString("ctnt"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setUnm(rs.getString("unm"));
				
				return vo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally { 
			DBUtils.close(con, ps, rs);
		}
		return null;
	}

	public static int delBoard(BoardVO param) {
		String sql = " DELETE FROM t_board WHERE iboard = ? AND iuser = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			ps.setInt(2, param.getIuser());
			
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}

	public static int updBoard(BoardVO vo) {
		String sql = "UPDATE t_board SET title = ?, ctnt = ? WHERE iboard = ?";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			ps.setInt(3, vo.getIboard());
			
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
		}
		
		return 0;
	}
}
