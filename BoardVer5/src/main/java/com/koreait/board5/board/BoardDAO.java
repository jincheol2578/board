package com.koreait.board5.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board5.DBUtils;
import com.koreait.board5.user.UserVO;

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
		String sql = " SELECT A.iboard ,A.title, A.iuser, A.regdt, B.unm "
				+ " FROM t_board A "
				+ " LEFT JOIN t_user B"
				+ " ON A.iuser = B.iuser "
				+ " ORDER BY iboard DESC ";
		List<BoardVO> list = new ArrayList();
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setUnm(rs.getString("unm"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setIuser(rs.getInt("iuser"));
				
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
		String sql = " SELECT A.iboard ,A.title, A.ctnt, A.regdt, B.unm "
				+ " FROM t_board A "
				+ " LEFT JOIN t_user B"
				+ " ON A.iuser = B.iuser "
				+ " WHERE iboard = ? ";
		BoardVO vo = new BoardVO();
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setUnm(rs.getString("unm"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setCtnt(rs.getString("ctnt"));
			}
			return vo;
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

	public static int modBoard(BoardVO param) {
		String sql = " UPDATE t_board SET title = ?, "
				+ " ctnt = ? "
				+ " WHERE iboard = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getTitle());
			ps.setString(2, param.getCtnt());
			ps.setInt(3, param.getIboard());
			
			return ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}

}
