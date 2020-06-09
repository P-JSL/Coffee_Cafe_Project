package com.usagi.dao.service.HMC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.usagi.dto.service.HMC.HMCVo;
import com.usagi.util.db.DBManager;

public class HMC_DAO {
	private HMC_DAO() {
		// TODO Auto-generated constructor stub
	}
	private static class HMCHolder {
	private static HMC_DAO instance = new HMC_DAO();
	}
	public static HMC_DAO getInstance() {
		return HMCHolder.instance;
	}

	public void HMCInsert(String title, String content, String userid) {
		String insert = "insert into userhmc (num, title, content, userid ) " + "values (seq_userhmc.nextval,? ,? ,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setString(3, userid);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public int HMCAllCount() {
		String counter = "select count(*) as count from userhmc";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(counter);
			rs = pstmt.executeQuery();
			if (rs.next())
				count = rs.getInt("count");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;
	}

	public List<HMCVo> HMCAll(int startpage, int endpage) {
		String All = "select X.* from " + "( select rownum as rnum, A.* from"
				+ "( select * from userhmc order by num desc ) A " + "where rownum  <= ? ) X where X.rnum >= ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<HMCVo> list = new ArrayList<HMCVo>();
		HMCVo hvo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(All);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				hvo = new HMCVo();
				hvo.setNum(rs.getInt("num"));
				hvo.setTitle(rs.getString("title"));
				hvo.setContent(rs.getString("content"));
				hvo.setUserid(rs.getString("userid"));
				hvo.setWritedate(rs.getTimestamp("writedate"));
				hvo.setLikes(rs.getInt("likes"));
				hvo.setReadcount(rs.getInt("readcount"));
				list.add(hvo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);

		}
		return list;

	}

	public HMCVo HmcOnView(String num) {
		String view = "select * from userhmc where num = ?";
		ResultSet rs = null;
		HMCVo hvo = null;
		try (Connection conn = DBManager.getConnection(); PreparedStatement pstmt = conn.prepareStatement(view);) {
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				hvo = new HMCVo();
				hvo.setNum(rs.getInt("num"));
				hvo.setTitle(rs.getString("title"));
				hvo.setContent(rs.getString("content"));
				hvo.setUserid(rs.getString("userid"));
				hvo.setWritedate(rs.getTimestamp("writedate"));
				hvo.setLikes(rs.getInt("likes"));
				hvo.setReadcount(rs.getInt("readcount"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return hvo;
	}

	public void HmcDelete(String num) {
		String delete = "delete from userhmc where num = ?";
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

	public void likeup(String num) {
		String likeup = "update userhmc set likes = likes + 1 where num= ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(likeup);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

	public void Readcount(String num) {
		String readcount = "update userhmc set readcount = readcount + 1 where num= ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(readcount);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

	public void HmcModify(HMCVo hvo) {
		String update = "update userhmc set title = ?, content = ? where num= ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, hvo.getTitle());
			pstmt.setString(2, hvo.getContent());
			pstmt.setInt(3, hvo.getNum());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

}
