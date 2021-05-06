package com.koreait.crudexam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO {
	static Connection con = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;

	final static String INSERT_COMMENT = " INSERT INTO t_comment (iboard, username, comment) " + " VALUES (?, ?, ?) ";
	final static String SELECT_COMMENT = " SELECT * FROM t_comment WHERE iboard = ? ORDER BY iboard DESC ";
	
	public static void istComment(CommentVO vo) {
		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(INSERT_COMMENT);
			ps.setInt(1, vo.getIboard());
			ps.setString(2, vo.getUserName());
			ps.setString(3, vo.getComment());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps);
		}
	}

	public static List<CommentVO> selComment(int intIboard) {
		List<CommentVO> list = new ArrayList();

		try {
			con = DBUtils.getCon();
			ps = con.prepareStatement(SELECT_COMMENT);
			ps.setInt(1, intIboard);
			rs = ps.executeQuery();

			while (rs.next()) {

				CommentVO cvo = new CommentVO();
				int icmt = rs.getInt("icmt");
				String userName = rs.getString("username");
				String comment = rs.getString("comment");
				String regdt = rs.getString("regdt");

				cvo.setIcmt(icmt);
				cvo.setUserName(userName);
				cvo.setComment(comment);
				cvo.setRegdt(regdt);

				list.add(cvo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(con, ps, rs);
		}

		return list;
	}

}
