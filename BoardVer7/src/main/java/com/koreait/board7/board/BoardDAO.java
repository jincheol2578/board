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
	
	public static BoardDomain selBoard(BoardDTO param) {
		String sql = "SELECT B.unm as writerNm "
				+ "	, A.iboard, A.iuser, A.regdt, A.title, A.ctnt "				
				+ " FROM t_board A "
				+ " INNER JOIN t_user B "
				+ " ON A.iuser = B.iuser"
				+ " WHERE A.iboard = ? ";
		BoardDomain result = null;
		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getIboard());
			rs = ps.executeQuery();
					
			if(rs.next()) {
				result = new BoardDomain();
				result.setIboard(param.getIboard());
				result.setTitle(rs.getString("title"));
				result.setCtnt(rs.getString("ctnt"));
				result.setIuser(rs.getInt("iuser"));
				result.setRegdt(rs.getString("regdt"));
				result.setWriterNm(rs.getString("writerNm"));
			}
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return result;
	}
	
	public static int selPagingCnt(BoardDTO param) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT CEIL(COUNT(iboard) / ?)")
		.append(" FROM t_board A"
				+ " INNER JOIN t_user B"
				+ " ON A.iuser = B.iuser ");
		
		if(param.getSearchType() > 0) {
			sb.append(" WHERE ");
		}
		
		switch(param.getSearchType()) {
		case 1: //제목+내용
			sb.append("A.title LIKE '%")
			.append(param.getSearchText())
			.append("%' OR A.ctnt LIKE '%")
			.append(param.getSearchText())
			.append("%' ");
			break;
		case 2: //제목
			sb.append("A.title LIKE '%")
			.append(param.getSearchText())
			.append("%' ");			
			break;
		case 3: //내용
			sb.append("A.ctnt LIKE '%")
			.append(param.getSearchText())
			.append("%' ");			
			break;
		case 4: //글쓴이
			sb.append("B.unm LIKE '%")
			.append(param.getSearchText())
			.append("%' ");
			break;
		}

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sb.toString());
			ps.setInt(1, param.getRecordCnt());			
			rs = ps.executeQuery();			
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}
		return result;
	}
	
	public static List<BoardDomain> selBoardList(BoardDTO param) {
		List<BoardDomain> list = new ArrayList();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT B.unm as writerNm, B.profileImg"
				+ "	, A.iboard, A.iuser, A.regdt, A.title "				
				+ " FROM t_board A "
				+ " INNER JOIN t_user B "
				+ " ON A.iuser = B.iuser ";
				
		switch(param.getSearchType()) {
		case 1: //제목+내용
			sql += String.format("WHERE A.title LIKE '%%%s%%' OR A.ctnt LIKE '%%%s%%' "
					, param.getSearchText(), param.getSearchText());
			break;
		case 2: //제목
			sql += String.format("WHERE A.title LIKE '%%%s%%' ", param.getSearchText());
			break;
		case 3: //내용
			sql += String.format("WHERE A.ctnt LIKE '%%%s%%' ", param.getSearchText());
			break;
		case 4: //글쓴이
			//sql += String.format("WHERE B.unm LIKE '%%%s%%' ", param.getSearchText());
			sql += "WHERE B.unm LIKE '%" + param.getSearchText() + "%'";
			break;
		}
				
		sql +=" ORDER BY iboard DESC"
				+ " LIMIT ?, ? ";		
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getStartIdx());
			ps.setInt(2, param.getRecordCnt());
			rs = ps.executeQuery();			
			
			while(rs.next()) {
				BoardDomain vo = new BoardDomain();								
				vo.setIboard(rs.getInt("iboard"));
				vo.setTitle(rs.getString("title"));
				vo.setRegdt(rs.getString("regdt"));
				vo.setIuser(rs.getInt("iuser"));
				vo.setWriterNm(rs.getString("writerNm"));
				vo.setProfileImg(rs.getString("profileImg"));
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