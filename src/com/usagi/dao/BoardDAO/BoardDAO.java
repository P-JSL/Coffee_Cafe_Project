package com.usagi.dao.BoardDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.usagi.dto.BoardVo.BoardVo;
import com.usagi.dto.UserVo.MyVo;
import com.usagi.util.db.DBManager;

public class BoardDAO {
	private BoardDAO() {
	}

	private static class BoardHolder {
		private static BoardDAO instance = new BoardDAO();
	}

	public static BoardDAO getInstance() {
		return BoardHolder.instance;
	}

	public int BoardMyPageCount(String userid) {
		String countsql = "select count(*) as count from userboard where b_id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(countsql);
			pstmt.setString(1, userid);
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

	public int BoardAllCount() {
		String AllCount = "select count(*) as count from userboard";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(AllCount);
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

	public int BoardAllCount(String id) {
		String AllCount = "select count(*) as count from userboard where b_id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(AllCount);
			pstmt.setString(1, id);
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

	public int BoardAllSearchCount(String s_query) {
		String AllCount = "select count(*) as count from userboard where " + s_query;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(AllCount);
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

	public List<BoardVo> BoardAllSearch(String s_query, int startpage, int endpage) {
		String selectMypage = "select X.* from " + "( select rownum as rnum, A.* from"
				+ "( select * from userboard order by num desc ) A " + "where " + s_query
				+ "and rownum  <= ? ) X where X.rnum >= ? and " + s_query;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVo> list = new ArrayList<BoardVo>();
		BoardVo bvo = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(selectMypage);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				bvo = new BoardVo();
				bvo.setNum(rs.getInt("num"));
				bvo.setB_id(rs.getString("b_id"));
				bvo.setB_title(rs.getString("b_title"));
				bvo.setB_content(rs.getString("b_content"));
				bvo.setB_date(rs.getTimestamp("b_date"));
				bvo.setB_count(rs.getInt("b_count"));
				list.add(bvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public List<BoardVo> BoardAll(int startpage, int endpage) {
		String selectMypage = "select X.* from " + "( select rownum as rnum, A.* from"
				+ "( select * from userboard order by num desc ) A " + "where rownum  <= ? ) X where X.rnum >= ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVo> list = new ArrayList<BoardVo>();
		BoardVo bvo = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(selectMypage);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				bvo = new BoardVo();
				bvo.setNum(rs.getInt("num"));
				bvo.setB_id(rs.getString("b_id"));
				bvo.setB_title(rs.getString("b_title"));
				bvo.setB_content(rs.getString("b_content"));
				bvo.setB_date(rs.getTimestamp("b_date"));
				bvo.setB_count(rs.getInt("b_count"));
				bvo.setOnoff(rs.getString("onoff"));
				list.add(bvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public List<BoardVo> BoardMypageAll(int startpage, int endpage, String userid) {
		String selectMypage = "select X.* from " + "( select rownum as rnum, A.* from"
				+ "( select * from userboard order by num desc ) A "
				+ "where rownum  <= ? ) X where X.rnum >= ? and b_id = ? order by X.rnum";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BoardVo> list = new ArrayList<BoardVo>();
		BoardVo bvo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(selectMypage);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			pstmt.setString(3, userid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				bvo = new BoardVo();
				bvo.setNum(rs.getInt("num"));
				bvo.setB_id(rs.getString("b_id"));
				bvo.setB_title(rs.getString("b_title"));
				bvo.setB_content(rs.getString("b_content"));
				bvo.setB_date(rs.getTimestamp("b_date"));
				bvo.setB_count(rs.getInt("b_count"));
				bvo.setOnoff(rs.getString("onoff"));
				list.add(bvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public MyVo InfoUser(String userid) {
		String select = "select c.signupdate, c.loginnum,u.b_count ,u.b_date from userboard u, C_USER c  "
				+ "where u.b_date =  (select max(b_date) from userboard where c.userid = ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MyVo mvo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				mvo = new MyVo();
				mvo.setB_count(rs.getInt("b_count"));
				mvo.setB_date(rs.getTimestamp("b_date"));
				mvo.setSignupdate((rs.getTimestamp("signupdate")));
				mvo.setLoginnum(rs.getInt("loginnum"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return mvo;
	}

	public BoardVo NumSearch(String num) {
		String NumSearch = "select * from userboard where num =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVo bvo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(NumSearch);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				bvo = new BoardVo();
				bvo.setB_id(rs.getString("b_id"));
				bvo.setB_title(rs.getString("b_title"));
				bvo.setB_content(rs.getString("b_content"));
				bvo.setB_date(rs.getTimestamp("b_date"));
				bvo.setB_count(rs.getInt("b_count"));
				bvo.setB_pw(rs.getString("b_pw"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return bvo;

	}

	public int BoardHitCount(String num) {

		String count = "update userboard set b_count = b_count+1 where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int hit = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(count);
			pstmt.setString(1, num);
			hit = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt);
		}
		return hit;

	}

	public int BoardAllHitCount(String id) {

		String count = "select sum(b_count) as count from userboard where b_id = ? group by b_id";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int hit = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(count);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next())
				hit = rs.getInt("count");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt);
		}
		return hit;

	}
	//

	public void BoardInsert(String b_title, String b_content, String id, String onoff, String b_pw) {
		String insert = "insert into userboard (num, b_title, b_content, b_id,onoff,b_pw)"
				+ "values (seq_userboard.nextval,?,?,?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, b_title);
			pstmt.setString(2, b_content);
			pstmt.setString(3, id);
			pstmt.setString(4, onoff);
			pstmt.setString(5, b_pw);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public int BoardReplyDelete(String id, String num) {
		String delete = "delete reply_board where userid= ? and num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int ok = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(delete);
			pstmt.setString(1, id);
			pstmt.setString(2, num);
			ok = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return ok;

	}

	public void BoardModify(BoardVo bvo) {
		String modify = "update userboard set b_title = ? , b_content = ? where num = ? and b_id=?";
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(modify);
			pstmt.setString(1, bvo.getB_title());
			pstmt.setString(2, bvo.getB_content());
			pstmt.setInt(3, bvo.getNum());
			pstmt.setString(4, bvo.getB_id());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

	public void BoardDelete(String num) {
		String delete = "delete from userboard where num = ?";
		PreparedStatement pstmt = null;
		Connection conn = null;
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

	public List<BoardVo> Board_Top5() {
		String Top5 = "select A.* from (select rownum as rnum , b.* from userboard b order by num desc) A where rownum <=5";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVo bvo = null;
		List<BoardVo> list = new ArrayList<BoardVo>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(Top5);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				bvo = new BoardVo();
				bvo.setNum(rs.getInt("num"));
				bvo.setB_id(rs.getString("b_id"));
				bvo.setB_title(rs.getString("b_title"));
				bvo.setB_date(rs.getTimestamp("b_date"));
				bvo.setB_count(rs.getInt("b_count"));
				list.add(bvo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;

	}

	public int Board_Top5_Count() {
		String Top5 = "select count(*) as count from (select rownum as rnum , b.* from userboard b order by num desc) A where rownum <=5";
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
