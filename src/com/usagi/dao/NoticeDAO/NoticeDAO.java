package com.usagi.dao.NoticeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.usagi.dto.NoticeVo.NoticeVo;
import com.usagi.util.db.DBManager;

public class NoticeDAO {
	private NoticeDAO() {
	}
	private static class NoticeHolder {
	private static NoticeDAO instance = new NoticeDAO();
	}
	public static NoticeDAO getInstance() {
		return NoticeHolder.instance;
	}

	public int NoticeAllSearchCount(String s_query) {
		String count = "select count(*) as count from usernotice where " + s_query;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int counter = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(count);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				counter = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return counter;
	}

	public int NoticeAllCount() {
		String count = "select count(*) as count from usernotice";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int counter = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(count);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				counter = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return counter;
	}

	public List<NoticeVo> NoticeAllSearch(String s_query, int startpage, int endpage) {
		String noticeview = "select X.* from " + "( select rownum as rnum, A.* from"
				+ "( select * from usernotice order by num desc ) A " + "where " + s_query
				+ " and rownum  <= ? ) X where X.rnum >= ? and " + s_query;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<NoticeVo> list = new ArrayList<NoticeVo>();
		NoticeVo bvo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(noticeview);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				bvo = new NoticeVo();
				bvo.setNum(rs.getInt("num"));
				bvo.setUserid(rs.getString("userid"));
				bvo.setN_title(rs.getString("n_title"));
				bvo.setN_content(rs.getString("n_content"));
				bvo.setN_date(rs.getTimestamp("n_date"));
				bvo.setN_count(rs.getInt("n_count"));
				list.add(bvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public List<NoticeVo> NoticeAll(int startpage, int endpage) {
		String noticeview = "select X.* from " + "( select rownum as rnum, A.* from"
				+ "( select * from usernotice order by num desc ) A " + "where rownum  <= ? ) X where X.rnum >= ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<NoticeVo> list = new ArrayList<NoticeVo>();
		NoticeVo bvo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(noticeview);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				bvo = new NoticeVo();
				bvo.setNum(rs.getInt("num"));
				bvo.setUserid(rs.getString("userid"));
				bvo.setN_title(rs.getString("n_title"));
				bvo.setN_content(rs.getString("n_content"));
				bvo.setN_date(rs.getTimestamp("n_date"));
				bvo.setN_count(rs.getInt("n_count"));
				list.add(bvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public NoticeVo NoticeViewer(String num) {
		String view = "select * from usernotice where num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoticeVo bvo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(view);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bvo = new NoticeVo();
				bvo.setNum(rs.getInt("num"));
				bvo.setN_title(rs.getString("n_title"));
				bvo.setN_content(rs.getString("n_content"));
				bvo.setN_date(rs.getTimestamp("n_date"));
				bvo.setN_count(rs.getInt("n_count"));
				bvo.setUserid(rs.getString("userid"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return bvo;
	}

	public void NoticeInsert(String title, String content, String id) {
		String insert = "insert into usernotice (num, n_title, n_content, userid)"
				+ " values(seq_usernotice.nextval,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, id);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public int Notice_Hitup(String num) {
		String hit = "update usernotice set n_count = n_count+1 where num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(hit);
			pstmt.setString(1, num);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	public void NoticeModify(String num, String title, String content, String id) {
		String update = "update usernotice set n_title = ? ,n_content = ? where userid = ? and num = ? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, id);
			pstmt.setString(4, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);

		}

	}

	public void Notice_Delete(String num) {
		String delete = "delete from usernotice where num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(delete);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

	public List<NoticeVo> Notice_Top5() {
		String Top5 = "select A.* from (select rownum as rnum , b.* from usernotice b order by num desc) A where rownum <=5";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoticeVo bvo = null;
		List<NoticeVo> list = new ArrayList<NoticeVo>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(Top5);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				bvo = new NoticeVo();
				bvo.setNum(rs.getInt("num"));
				bvo.setUserid(rs.getString("userid"));
				bvo.setN_title(rs.getString("n_title"));
				bvo.setN_date(rs.getTimestamp("n_date"));
				bvo.setN_count(rs.getInt("n_count"));
				list.add(bvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;

	}
	public int Notice_Top5_Count() {
		String Top5 = "select count(*) as count from (select rownum as rnum , b.* from usernotice b order by num desc) A where rownum <=5";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(Top5);
			rs = pstmt.executeQuery();
			if (rs.next()) {
		count = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
	}
}
