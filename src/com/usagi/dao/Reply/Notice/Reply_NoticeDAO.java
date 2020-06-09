package com.usagi.dao.Reply.Notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.usagi.dto.Reply.Notice.Reply_NoticeVo;
import com.usagi.util.db.DBManager;

public class Reply_NoticeDAO {
	private Reply_NoticeDAO() {
	}
	private static class RNHolder {
	private static Reply_NoticeDAO instance = new Reply_NoticeDAO();
	}
	public static Reply_NoticeDAO getInstance() {
		return RNHolder.instance;
	}
	
	public int reply_Notice_insert(String b_num, String comment, String userid) {
		String insert = "insert into reply_Notice (num, re_comment, n_num,userid)"
				+ "values (seq_reply_Notice.nextval,?,?,?)";
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

	public List<Reply_NoticeVo> Reply_Comment_Search(String b_num) {
		String search = "select * from reply_Notice where n_num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Reply_NoticeVo> list = new ArrayList<Reply_NoticeVo>();
		Reply_NoticeVo rbvo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(search);
			pstmt.setString(1, b_num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				rbvo = new Reply_NoticeVo();
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
		String count = "select count(*) as count from reply_Notice where userid = ?";
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
		String count = "select count(*) as count from reply_Notice where n_num = ?";
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
	public List<Reply_NoticeVo> MyComment(int startpage, int endpage, String userid) {
		String Comment = "select X.* from " + "( select rownum as rnum, A.* from"
				+ "( select * from reply_Notice order by num desc ) A "
				+ "where rownum  <= ? ) X where X.rnum >= ? and userid = ? order by X.rnum ";
		//String Comment = "select * from reply_Notice where userid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Reply_NoticeVo rbvo = null;
		List<Reply_NoticeVo> list = new ArrayList<Reply_NoticeVo>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(Comment);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			pstmt.setString(3,userid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				rbvo = new Reply_NoticeVo();
				rbvo.setN_num(rs.getInt("rnum"));
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

	public int Reply_Delete(String id, String num) {
		String delete = "delete reply_notice where userid = ? and num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int ok = -1;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(delete);
			pstmt.setString(1, id);
			pstmt.setString(2,num);
			ok = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt);
		}
		return ok;
	}
}
