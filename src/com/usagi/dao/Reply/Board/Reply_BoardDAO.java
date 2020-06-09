package com.usagi.dao.Reply.Board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.usagi.dto.Reply.Board.Reply_BoardVo;
import com.usagi.util.db.DBManager;

public class Reply_BoardDAO {
	private Reply_BoardDAO() {
	}

	private static Reply_BoardDAO instance = new Reply_BoardDAO();

	public static Reply_BoardDAO getInstance() {
		return instance;
	}

	public int reply_board_insert(String b_num, String comment, String userid) {
		String insert = "insert into reply_board (num, re_comment, b_num,userid)"
				+ "values (seq_reply_board.nextval,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, comment);
			pstmt.setString(2, b_num);
			pstmt.setString(3, userid);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	public List<Reply_BoardVo> Reply_Comment_Search(String b_num) {
		String search = "select * from reply_board where b_num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Reply_BoardVo> list = new ArrayList<Reply_BoardVo>();
		Reply_BoardVo rbvo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(search);
			pstmt.setString(1, b_num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				rbvo = new Reply_BoardVo();
				rbvo.setRe_comment(rs.getString("re_comment"));
				rbvo.setNum(rs.getInt("num"));
				rbvo.setReply_date(rs.getTimestamp("reply_date"));
				rbvo.setUserid(rs.getString("userid"));
				list.add(rbvo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return list;
	}

	public int Reply_Count(String userid) {
		String count = "select count(*) as count from reply_board where userid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int counter = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(count);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				counter = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return counter;
	}
	public int Reply_Num_Count(String b_num) {
		String count = "select count(*) as count from reply_board where b_num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int counter = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(count);
			pstmt.setString(1, b_num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				counter = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return counter;
	}
	public List<Reply_BoardVo> MyComment(int startpage, int endpage, String userid) {
		String Comment = "select X.* from " + "( select rownum as rnum, A.* from"
				+ "( select * from reply_board order by num desc ) A "
				+ "where rownum  <= ? ) X where X.rnum >= ? and userid = ? order by X.rnum ";
		//String Comment = "select * from reply_board where userid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Reply_BoardVo rbvo = null;
		List<Reply_BoardVo> list = new ArrayList<Reply_BoardVo>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(Comment);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			pstmt.setString(3,userid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				rbvo = new Reply_BoardVo();
				rbvo.setB_num(rs.getInt("rnum"));
				rbvo.setNum(rs.getInt("num"));
				rbvo.setRe_comment(rs.getString("re_comment"));
				rbvo.setReply_date(rs.getTimestamp("reply_date"));
				list.add(rbvo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return list;
	}
	public void Board_Comment_Delete(String num) {
		String delete = "delete from reply_board where num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(delete);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
}
