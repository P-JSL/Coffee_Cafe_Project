package com.usagi.dao.NonUserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.usagi.dto.NonUserVo.NonUserVo;
import com.usagi.util.db.DBManager;

public class NonUserDAO {
	private NonUserDAO() {
	}

	private static NonUserDAO instance = new NonUserDAO();

	public static NonUserDAO getInstance() {
		return instance;
	}

	public void NonUserInsert(NonUserVo NUVo) {
		String insert = "insert into nonuser (name, email )  values(? , ? )";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, NUVo.getName());
			pstmt.setString(2, NUVo.getEmail());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void MailComfirm(String name) {
		String comfirm = "update nonuser set confirm = 1 where name = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(comfirm);
			pstmt.setString(1, name);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

	public String searchNonUser(String name) {
		String search = "select*from nonuser where name = ? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String inname = "";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(search);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				inname = rs.getString("name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return inname;
	}

	public int confirmSearch(String name) {
		String search = "select * from nonuser where name = ? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int comfirm = 0;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(search);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				comfirm = rs.getInt(3);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		return comfirm;
	}
}
