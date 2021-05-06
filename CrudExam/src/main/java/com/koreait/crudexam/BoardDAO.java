package com.koreait.crudexam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	static Connection con = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	
	final static String INSERT_BOARD = " INSERT INTO t_board1 (username, title, content) "
			+ " VALUES ( ?, ?, ?) ";
	final static String SELECT_ALL_BOARD = " SELECT * FROM t_board1 ORDER BY iboard DESC";
	final static String SELECT_BOARD = " SELECT * FROM t_board1 WHERE iboard = ? ";
	final static String DELETE_BOARD = " DELETE FROM t_board1 WHERE iboard = ?";
	final static String UPDATE_BOARD = " UPDATE t_board1 SET title = ?,"
			+ " content = ? "
			+ " WHERE iboard = ? ";

	final static String UPDATE_VIEWCNT = " UPDATE t_board1 SET viewcnt = ? WHERE iboard = ? ";

	public static void istBoard(BoardVO vo) {
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(INSERT_BOARD);
			ps.setString(1, vo.getUserName());
			ps.setString(2, vo.getTitle());
			ps.setString(3, vo.getContent());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}

	public static List<BoardVO> selAllBoard() {
		List<BoardVO> list = new ArrayList();
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(SELECT_ALL_BOARD);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				BoardVO vo = new BoardVO();
				int iboard = rs.getInt("iboard");
				String title = rs.getString("title");
				String userName = rs.getString("username");
				String content = rs.getString("content");
				String regdt = rs.getString("regdt");
				int viewCnt = rs.getInt("viewcnt");
				
				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setUserName(userName);
				vo.setContent(content);
				vo.setRegdt(regdt);
				vo.setViewCnt(viewCnt);
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		
		return list;
	}

	public static BoardVO selBoard(BoardVO vo) {
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(SELECT_BOARD);
			ps.setInt(1, vo.getIboard());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int iboard = rs.getInt("iboard");
				String title = rs.getString("title");
				String userName = rs.getString("username");
				String content = rs.getString("content");
				String regdt = rs.getString("regdt");
				int viewCnt = rs.getInt("viewcnt");
				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setUserName(userName);
				vo.setContent(content);
				vo.setRegdt(regdt);
				vo.setViewCnt(viewCnt);
				upViewCnt(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return vo;
	}

	private static void upViewCnt(BoardVO vo) {
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(UPDATE_VIEWCNT);
			ps.setInt(1, vo.getViewCnt()+1);
			ps.setInt(2, vo.getIboard());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
		
	}

	public static void delBoard(int intIboard) {
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(DELETE_BOARD);
			ps.setInt(1, intIboard);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}

	public static BoardVO udtBoard(BoardVO vo) {
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(UPDATE_BOARD);
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getContent());
			ps.setInt(3, vo.getIboard());
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	

	
}