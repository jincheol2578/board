package com.koreait.board3;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BoardDAO {
	//글 등록
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
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtils.close(con, ps);
		}
		return 0;
	}
}
