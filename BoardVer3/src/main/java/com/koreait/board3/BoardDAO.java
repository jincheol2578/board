package com.koreait.board3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

public class BoardDAO {
	//INSERT
	public static int insertBoard(BoardVO3 vo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO t_board (title, ctnt)" 
				+ " VALUES (?, ?)";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql); //쿼리 실행
			ps.setString(1, vo.getTitle());
			ps.setString(2, vo.getCtnt());
			
			return ps.executeUpdate();  // insert, update, delete 영향받은행 정수값으로 return
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
	//SELECT
	public static List<BoardVO3> selBoardList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<BoardVO3> list = new ArrayList();
		
		String sql = " SELECT iboard,title,regdt FROM t_board";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardVO3 vo = new BoardVO3();
				list.add(vo); //reference 변수라 위에있어도 상관없음 
				
				int iboard = rs.getInt("iboard");
				String title = rs.getString("title");
				String regdt = rs.getString("regdt");
				
				vo.setIboard(iboard);
				vo.setTitle(title);
				vo.setRegdt(regdt);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps, rs);
		}
		return list;
	}
	
	public static BoardVO3 selBoard(int intIboard) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT title, ctnt, regdt FROM t_board WHERE iboard = ? ";
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, intIboard);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				BoardVO3 vo = new BoardVO3();
				
				String ctnt = rs.getString("ctnt");
				String title = rs.getString("title");
				String regdt = rs.getString("regdt");
				
				vo.setIboard(intIboard);
				vo.setTitle(title);
				vo.setRegdt(regdt);
				vo.setCtnt(ctnt);
				
				return vo;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps, rs);
		}
		return null;
	}
}
