package com.usagi.dao.ContactDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.usagi.dto.ContactVo.ContactVo;
import com.usagi.util.db.DBManager;

public class ContactDAO {
	private ContactDAO() {
	}

	private static class ContactHolder {
		private static ContactDAO instance = new ContactDAO();
	}

	public static ContactDAO getInstance() {
		return ContactHolder.instance;
	}

	public void ConInsert(ContactVo cvo) {
		String insert = "insert into contact (num,name,id,msg,email) " + "values (seq_contact.nextval,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, cvo.getName());
			pstmt.setString(2, cvo.getId());
			pstmt.setString(3, cvo.getMsg());
			pstmt.setString(4, cvo.getEmail());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

	public int Contact_Count() {
		String count = "select count(*) as count from contact where id <> (select userid from c_user where admin = 2)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int counter = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(count);
			rs = pstmt.executeQuery();
			if (rs.next())
				counter = rs.getInt("count");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return counter;
	}

	public int Contact_Count(String userid) {
		String count = "select count(*) as count from contact where id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int counter = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(count);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next())
				counter = rs.getInt("count");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return counter;
	}

	public int ContactAllHitCount(String userid) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<ContactVo> MyContact(int startpage3, int endpage3, String userid) {
		String selectMypage = "select X.* from " + "( select rownum as rnum, A.* from"
				+ "( select * from contact order by num desc ) A " + "where rownum  <= ? ) X where X.rnum >= ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ContactVo> list = new ArrayList<ContactVo>();
		ContactVo cvo = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(selectMypage);
			pstmt.setInt(1, endpage3);
			pstmt.setInt(2, startpage3);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cvo = new ContactVo();
				cvo.setId(rs.getString("id"));
				cvo.setName(rs.getString("name"));
				cvo.setEmail(rs.getString("email"));
				cvo.setMsg(rs.getString("msg"));
				cvo.setSend_date(rs.getTimestamp("send_date"));
				cvo.setNum(rs.getInt("num"));
				cvo.setResponse(rs.getString("RESPONSE"));
				cvo.setRes_confirm(rs.getInt("res_confirm"));
				list.add(cvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public List<ContactVo> Contact(int startpage, int endpage) {
		String selectMypage = "select X.* from ( select rownum as rnum, A.* from( select * from contact order by num desc ) A where rownum  <=? ) X where X.rnum >= ? and id <> (select userid from c_user where admin = 2)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ContactVo> list = new ArrayList<ContactVo>();
		ContactVo cvo = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(selectMypage);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cvo = new ContactVo();
				cvo.setId(rs.getString("id"));
				cvo.setName(rs.getString("name"));
				cvo.setEmail(rs.getString("email"));
				cvo.setMsg(rs.getString("msg"));
				cvo.setSend_date(rs.getTimestamp("send_date"));
				cvo.setNum(rs.getInt("num"));
				cvo.setResponse(rs.getString("response"));
				cvo.setRes_confirm(rs.getInt("res_confirm"));
				list.add(cvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public int UserCount() {
		String count = "select count(*) as count from c_user";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int c = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(count);
			rs = pstmt.executeQuery();
			if (rs.next())
				c = rs.getInt("count");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}

	public void Response(String res, String num) {
		String insert = "update contact set response =? where num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, res);
			pstmt.setString(2, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public ContactVo ContactSearch(String num) {
		String search = "select * from contact where num = ? and id <> (select userid from c_user where admin = 2)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ContactVo cvo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(search);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				cvo = new ContactVo();
				cvo.setId(rs.getString("id"));
				cvo.setMsg(rs.getString("msg"));
				cvo.setEmail(rs.getString("email"));
				cvo.setName(rs.getString("name"));
				cvo.setSend_date(rs.getTimestamp("send_date"));
				cvo.setResponse(rs.getString("response"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return cvo;

	}

	public void response_ok(String num) {
		String confirm = "update contact set res_confirm = 1 where num = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(confirm);
			pstmt.setString(1, num);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);

		}
	}

	public void response_not(String num) {
		String confirm = "update contact set res_confirm = 0";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(confirm);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);

		}
	}
}
