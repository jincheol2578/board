package com.koreait.board6.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board6.DBUtils;

public class BoardDAO {
	static Connection con = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	
	public static int getAllPage (BoardVO param) {
		String sql = " SELECT ceil(COUNT(*) / ?) as cnt FROM t_board "
				+ " WHERE title LIKE ? ";
		
		int result = 0;
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1,param.getPage());
			ps.setString(2, "%"+ param.getSearch() + "%");
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		
		return result;
	}
	
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

	public static List<BoardVO> selBoardList(BoardVO param) {
		String sql = " SELECT A.iboard ,A.title, A.iuser, A.regdt, B.unm "
				+ " FROM t_board A "
				+ " LEFT JOIN t_user B"
				+ " ON A.iuser = B.iuser "
				+ " WHERE title LIKE ? "
				+ " ORDER BY iboard DESC"
				+ " LIMIT ?,? ";
		
		List<BoardVO> list = new ArrayList();
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, "%" + param.getSearch() + "%");
			ps.setInt(2, param.getsIdx());
			ps.setInt(3, param.getPage());
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

	public static BoardVO selBoard(BoardVO param) {
		String sql = " SELECT B.unm, A.iboard, A.title, A.ctnt, A.iuser, A.regdt, "+
				" if(C.iboard IS NULL, 0, 1) AS isFav"+
				" FROM t_board A"+
				" INNER JOIN t_user B"+
				" ON A.iuser = B.iuser"+
				" LEFT JOIN t_board_fav C"+
				" ON A.iboard = C.iboard"+
				" AND C.iuser = ?"+
				" WHERE A.iboard = ?";
		
		BoardVO result = null;
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIuser());
			ps.setInt(2, param.getIboard());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = new BoardVO();
				result.setIboard(rs.getInt("iboard"));
				result.setTitle(rs.getString("title"));
				result.setUnm(rs.getString("unm"));
				result.setRegdt(rs.getString("regdt"));
				result.setCtnt(rs.getString("ctnt"));
				result.setIsFav(rs.getInt("isFav"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		
		return result;
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
