package com.koreait.board7.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.koreait.board7.DBUtils;

public class BoardDAO {
	
	private static Connection con = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	public static List<BoardDomain> selBoardList() {
		List<BoardDomain> list = new ArrayList();
		String sql = " SELECT A.iboard, A.title, A.iuser, A.regdt "
				+ " , B.unm as writerNm "
				+ " FROM t_board A "
				+ " INNER JOIN t_user B "
				+ " ON A.iuser = B.iuser "
				+ " ORDER BY iboard DESC ";
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardDomain vo = new BoardDomain();
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setWriterNm(rs.getString("writerNm"));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
			
		}
		
		return list;
	}
}
