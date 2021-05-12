package com.koreait.board4.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board4.DBUtils;

public class BoardDAO {
	public static int insBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = " INSERT INTO t_board (iuser, title, ctnt)" + " VALUES (?, ?, ?)";

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
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<BoardVO> list = new ArrayList();

		String sql = " SELECT A.iboard, A.title, A.iuser, A.regdt, B.unm"
				+ " FROM t_board A "
				+ " LEFT join t_user B "
				+ " ON A.iuser = B.iuser "
				+ " ORDER BY iboard DESC ";

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setUnm(rs.getString("unm"));
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
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		BoardVO data = null;

		String sql = " SELECT A.title, A.regdt, A.ctnt, A.iuser, B.unm "
				+ " FROM t_board A "
				+ " LEFT join t_user B "
				+ " ON A.iuser = B.iuser "
				+ " WHERE iboard = ? ";

		try {

			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, iboard);
			rs = ps.executeQuery();

			if (rs.next()) {
				data = new BoardVO();
				data.setTitle(rs.getString("title"));
				data.setRegdt(rs.getString("regdt"));
				data.setUnm(rs.getString("unm"));
				data.setCtnt(rs.getString("ctnt"));
				data.setIuser(rs.getInt("iuser"));
			}

			return data;

		} catch (Exception e) {
			e.printStackTrace();
			return data;
		} finally {
			DBUtils.close(con, ps, rs);
		}

	}

	public static int delBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " DELETE FROM t_board WHERE iboard = ? " 
				+ " AND iuser = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			ps.setInt(2, param.getIuser());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			DBUtils.close(con, ps);
		}
		
	}
	public static int updBoard(BoardVO param) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " UPDATE t_board SET title = ?,"
				+ " ctnt = ?"
				+ " WHERE iboard = ? "
				+ " AND iuser = ? ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getTitle());
			ps.setString(2, param.getCtnt());
			ps.setInt(3, param.getIboard());
			ps.setInt(4, param.getIuser());
			
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
}
