package com.usagi.dao.GalleryDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.usagi.dto.gallery.GalleryVo;
import com.usagi.util.db.DBManager;

public class GalleryDAO {
	private GalleryDAO() {
	}
	private static class GalleryHolder {
	private static GalleryDAO instance = new GalleryDAO();
	}
	public static GalleryDAO getInstance() {
		return GalleryHolder.instance;
	}

	public int InsertGallery(GalleryVo gvo) {
		String insert = "Insert Into gallery (num, photo, userid) values (seq_gallery.nextval, ? , ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, gvo.getPhoto());
			pstmt.setString(2, gvo.getUserid());
			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return 0;

	}

	public List<GalleryVo> GalleryInfo() {
		String info = "select A.* from (select rownum as rnum ,g.* from gallery g order by num desc)A ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<GalleryVo> glist = new ArrayList<GalleryVo>();
		GalleryVo gvo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(info);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				gvo = new GalleryVo();
				gvo.setRnum(rs.getInt("rnum"));
				gvo.setNum(rs.getInt("num"));
				gvo.setPhoto(rs.getString("photo"));
				gvo.setPhotodate(rs.getTimestamp("photodate"));
				gvo.setUserid(rs.getString("userid"));
				glist.add(gvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return glist;
	}

	public List<GalleryVo> GalleryUser(String userid) {
		String info = "select * from gallery where userid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<GalleryVo> glist = new ArrayList<GalleryVo>();
		GalleryVo gvo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(info);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				gvo = new GalleryVo();
				gvo.setNum(rs.getInt("num"));
				gvo.setPhoto(rs.getString("photo"));
				gvo.setPhotodate(rs.getTimestamp("photodate"));
				gvo.setUserid(rs.getString("userid"));
				glist.add(gvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return glist;
	}

	public GalleryVo GalleryInfo(String userid) {
		String info = "select * from gallery where userid =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		GalleryVo gvo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(info);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				gvo = new GalleryVo();
				gvo.setNum(rs.getInt("num"));
				gvo.setPhoto(rs.getString("photo"));
				gvo.setPhotodate(rs.getTimestamp("photodate"));
				gvo.setUserid(rs.getString("userid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return gvo;
	}

	public void Gallery_Delete(String num) {
		String delete = "delete from gallery where num = ?";
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

	public List<GalleryVo> Gallery_Top4() {
		String top4 = "select  A.* from ( select rownum as rnum,g.* from  gallery g order by num desc ) A where A.rnum <=4";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<GalleryVo> glist = new ArrayList<GalleryVo>();
		GalleryVo gvo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(top4);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				gvo = new GalleryVo();
				gvo.setNum(rs.getInt("num"));
				gvo.setPhoto(rs.getString("photo"));
				gvo.setPhotodate(rs.getTimestamp("photodate"));
				gvo.setRnum(rs.getInt("rnum"));
				gvo.setUserid(rs.getString("userid"));
				glist.add(gvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return glist;

	}

	public int Gallery_Top4_Count() {
		String co = "select  count(*) as count from ( select rownum as rnum,g.* from  gallery g order by num desc ) A where A.rnum <=4";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(co);
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
