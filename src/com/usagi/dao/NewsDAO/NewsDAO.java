package com.usagi.dao.NewsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.usagi.dto.NewsVo.NewsVo;
import com.usagi.util.db.DBManager;

public class NewsDAO {
	private NewsDAO() {
	}
	private static class NewsHolder {
	private static NewsDAO instance = new NewsDAO();
	}
	public static NewsDAO getInstance() {
		return NewsHolder.instance;
	}

	public int NewsInsert(NewsVo nvo) {
		String insert = "insert into news (num, title, content, userid, photo) "
				+ "values (seq_news.nextval, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, nvo.getTitle());
			pstmt.setString(2, nvo.getContent());
			pstmt.setString(3, nvo.getUserid());
			pstmt.setString(4, nvo.getPhoto());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	public int NewsAllCount() {
		String AllCount = "select count(*) as count from News";
		int cot = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(AllCount);
			rs = pstmt.executeQuery();
			if (rs.next())
				cot = rs.getInt("count");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return cot;

	}

	public List<NewsVo> NewsAll(int startpage, int endpage) {
		String All_News_view = "select X.* from " + "( select rownum as rnum, A.* from"
				+ "( select * from news order by num desc ) A " + "where rownum  <= ? ) X where X.rnum >= ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NewsVo nvo = null;
		List<NewsVo> list = new ArrayList<NewsVo>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(All_News_view);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				nvo = new NewsVo();
				nvo.setNum(rs.getInt("num"));
				nvo.setTitle(rs.getString("title"));
				nvo.setContent(rs.getString("content"));
				nvo.setPhoto(rs.getString("photo"));
				nvo.setUserid(rs.getString("userid"));
				nvo.setNews_date(rs.getTimestamp("news_date"));
				list.add(nvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;

	}

	public NewsVo NewsView(String num) {
		String view = "select * from news where num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NewsVo nvo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(view);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				nvo = new NewsVo();
				nvo.setNum(rs.getInt("num"));
				nvo.setTitle(rs.getString("title"));
				nvo.setContent(rs.getString("content"));
				nvo.setPhoto(rs.getString("photo"));
				nvo.setUserid(rs.getString("userid"));
				nvo.setNews_date(rs.getTimestamp("news_date"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return nvo;
	}

	public int NewsDelete(String num) {
		String delete = "delete from news where num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int n = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(delete);
			pstmt.setString(1, num);
			n = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return n;
	}

	public int NewsModify(NewsVo nvo) {
		String update = "update news set userid=?, title =?, content = ?, photo = ? where num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int r = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, nvo.getUserid());
			pstmt.setString(2, nvo.getTitle());
			pstmt.setString(3, nvo.getContent());
			pstmt.setString(4, nvo.getPhoto());
			pstmt.setInt(5, nvo.getNum());
			r = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return r;
	}

	public List<NewsVo> News_Top3() {
		String Top5 = "select A.* from (select rownum as rnum , b.* from news b order by num desc) A where rownum <=3";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NewsVo bvo = null;
		List<NewsVo> list = new ArrayList<NewsVo>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(Top5);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				bvo = new NewsVo();
				bvo.setNum(rs.getInt("num"));
				bvo.setUserid(rs.getString("userid"));
				bvo.setTitle(rs.getString("title"));
				bvo.setNews_date(rs.getTimestamp("news_date"));
				bvo.setPhoto(rs.getString("photo"));
				list.add(bvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;

	}

	public int News_Top3_Count() {
		String Top5 = "select count(*) as count from (select rownum as rnum , b.* from news b order by num desc) A where rownum <=3";
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
