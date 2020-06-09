package com.usagi.dao.Reply.news;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.usagi.dto.Reply.news.Reply_NewsVo;
import com.usagi.util.db.DBManager;

public class Reply_NewsDAO {
	private Reply_NewsDAO() {
	}
	private static class RNHolder {
	private static Reply_NewsDAO instance = new Reply_NewsDAO();
	}
	public static Reply_NewsDAO getInstance() {
		return RNHolder.instance;
	}

	public int NewsReply(String id, String comment, String n_num) {
		String replyInsert = "insert into reply_news (num, n_num, re_comment, userid) "
				+ "values (seq_reply_news.nextval,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int o = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(replyInsert);
			pstmt.setString(1, n_num);
			pstmt.setString(2, comment);
			pstmt.setString(3, id);
			o = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return o;
	}

	public List<Reply_NewsVo> NewsReply_View(String n_num) {
		String Reply_View = "select * from reply_news where n_num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Reply_NewsVo rnvo = null;
		List<Reply_NewsVo> list = new ArrayList<Reply_NewsVo>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(Reply_View);
			pstmt.setString(1, n_num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				rnvo = new Reply_NewsVo();
				rnvo.setNum(rs.getInt("num"));
				rnvo.setN_num(rs.getInt("n_num"));
				rnvo.setRe_comment(rs.getString("re_comment"));
				rnvo.setReply_date(rs.getTimestamp("reply_date"));
				rnvo.setUserid(rs.getString("userid"));
				list.add(rnvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	public int News_Reply_Count(String num) {
		String count = "select count(*) as count from reply_news where n_num=?";
		int counter = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(count);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			if(rs.next())
				counter = rs.getInt("count");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}return counter;
		
	}
}
