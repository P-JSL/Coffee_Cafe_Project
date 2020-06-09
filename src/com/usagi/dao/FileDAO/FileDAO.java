package com.usagi.dao.FileDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.usagi.dto.FileVo.FileVo;
import com.usagi.util.db.DBManager;

public class FileDAO {
	private FileDAO() {

	}

	private static class FileHolder {

		private static final FileDAO instance = new FileDAO();
	}

	public static FileDAO getInstance() {
		return FileHolder.instance;
	}

	public void File_Insert(FileVo fvo) {
		String insert = "insert into files (num, files, userid,filesize)" + " values (seq_files.nextval,?,?,? )";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, fvo.getFiles());
			pstmt.setString(2, fvo.getUserid());
			pstmt.setInt(3, fvo.getSize());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public List<FileVo> File_download(String id) {
		String fileSearch = "select * from files where userid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<FileVo> list = new ArrayList<FileVo>();
		FileVo fvo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(fileSearch);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				fvo = new FileVo();
				fvo.setNum(rs.getInt("num"));
				fvo.setFiles(rs.getString("files"));
				fvo.setUpload_day(rs.getTimestamp("upload_day"));
				fvo.setUserid(rs.getString("userid"));
				fvo.setSize(rs.getInt("filesize"));
				list.add(fvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return list;
	}

	public List<FileVo> File_Allload() {
		String Search = "select * from files";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<FileVo> list = new ArrayList<FileVo>();
		FileVo fvo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(Search);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				fvo = new FileVo();
				fvo.setNum(rs.getInt("num"));
				fvo.setFiles(rs.getString("files"));
				fvo.setUpload_day(rs.getTimestamp("upload_day"));
				fvo.setUserid(rs.getString("userid"));
				fvo.setSize(rs.getInt("filesize"));
				list.add(fvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return list;
	}

	public int File_U_F(String num) {
		String o = "select admin from c_user where userid = (select userid from files where num = ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int r = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(o);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				r = rs.getInt("admin");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return r;

	}
}
