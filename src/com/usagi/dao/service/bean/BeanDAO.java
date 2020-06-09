package com.usagi.dao.service.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.usagi.dto.service.bean.BeanVo;
import com.usagi.util.db.DBManager;

public class BeanDAO {
	private BeanDAO() {

	}
	private static class BeanHolder {
	private static BeanDAO instance = new BeanDAO();
	}
	public static BeanDAO getInstance() {
		return BeanHolder.instance;
	}

	public void BeanInsert(String id, String title, String content) {
		String insert = "insert into admin_services_bean (id, title, content)" + " values (?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, id);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public BeanVo BeanView() {
		String view = "select * from admin_services_bean";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BeanVo bvo = new BeanVo();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(view);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bvo.setId(rs.getString("id"));
				bvo.setTitle(rs.getString("title"));
				bvo.setContent(rs.getString("content"));
				bvo.setMdate(rs.getTimestamp("mdate"));
				bvo.setOnoff(rs.getInt("onoff"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bvo;
	}

	public void BeanModify(String id, String title, String content) {
		String modify = "update admin_services_bean set title = ? , content = ? where id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(modify);
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
}
