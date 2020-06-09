package com.usagi.dao.UserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.usagi.dto.UserVo.UserVo;
import com.usagi.util.db.DBManager;

public class UserDAO {

	private UserDAO() {
	}
	private static class UserHolder {
	private static UserDAO instance = new UserDAO();
	}
	public static UserDAO getInstance() {
		return UserHolder.instance;
	}

	public int C_UserInsert(UserVo uvo) {
		String insert = "insert into C_USER " + "(num, name, userid, userpw, useremail, gender, mail_confirm) values"
				+ "(seq_CUSER.nextval, ? , ? , ? , ? , ? ,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, uvo.getName());
			pstmt.setString(2, uvo.getUserid());
			pstmt.setString(3, uvo.getUserpw());
			pstmt.setString(4, uvo.getUseremail());
			pstmt.setString(5, uvo.getGender());
			pstmt.setInt(6, uvo.getMail_confirm());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;

	}

	public int C_UserSearch(String userid, String userpw, String useremail) {
		String search = "select * from C_USER where useremail=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(search);
			pstmt.setString(1, useremail);
			rs = pstmt.executeQuery();
			System.out.println(userid);
			System.out.println(userpw);
			System.out.println(useremail);
			if (rs.next()) {
				if (rs.getString("userid").equals(userid) && rs.getString("userpw").equals(userpw)) {
					result = 1;
				} else {
					result = 0;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return result;
	}

	public String UserEmail(String userid) {
		String select = "select useremail from c_user where userid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String email = "";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				email = rs.getString("useremail");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);

		}
		return email;
	}

	public String C_UserPwSearch(String userid) {
		String pwsearch = "select userpw from C_USER where userid ='" + userid + "'";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String userpw = "";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(pwsearch);
			rs = pstmt.executeQuery();
			if (rs.next())
				userpw = rs.getString("userpw");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return userpw;
	}

	public boolean UserModify(UserVo uvo) {
		String update = "update C_USER set useremail = ? , userpw = ? where userid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, uvo.getUseremail());
			pstmt.setString(2, uvo.getUserpw());
			pstmt.setString(3, uvo.getUserid());
			result = pstmt.executeUpdate() == 1 ? true : false;

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	public void UserLogin(String userid) {
		String login = "update C_USER set loginnum = loginnum+1 where userid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(login);
			pstmt.setString(1, userid);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public boolean UserMail(String useremail) {
		String email = "select useremail from c_user where useremail = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean over = false;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(email);
			pstmt.setString(1, useremail);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				over = true; // 중복인 경우
			} else {
				over = false; // 중복이 아닌경우
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return over;
	}

	public int Admin(String userid) {
		String admin = "select admin from c_user where userid= ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int over = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(admin);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				over = rs.getInt("admin");
			} else {
				over = 0;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return over;
	}

	public List<UserVo> User(int startpage, int endpage) {
		String select = "select X.* from ( select rownum as rnum, A.* from"
				+ "( select * from c_user order by num desc ) A where rownum  <= ? ) X where X.rnum >= ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<UserVo> list = new ArrayList<UserVo>();
		UserVo uvo = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, endpage);
			pstmt.setInt(2, startpage);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				uvo = new UserVo();
				uvo.setUserid(rs.getString("userid"));
				uvo.setName(rs.getString("name"));
				uvo.setSignupdate(rs.getTimestamp("signupdate"));
				uvo.setGender(rs.getString("gender"));
				uvo.setUseremail(rs.getString("useremail"));
				uvo.setLoginnum(rs.getInt("loginnum"));
				list.add(uvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public List<String> User() {
		String select = "select * from c_user";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String> list = new ArrayList<String>();
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(rs.getString("userid"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}

	public String Your_Id(String email) {
		String id_search = "select userid from c_user where useremail=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String id = "";
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(id_search);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				id = rs.getString("userid");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return id;
	}

	public int PassWord_Update(String id, String pw, String email) {
		String update = "update c_user set userpw =? where userid =? and useremail =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int updating = 0;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, pw);
			pstmt.setString(2, id);
			pstmt.setString(3, email);
			updating = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return updating;

	}

	public void C_User_Delete(String userid) {
		String delete = "delete from c_user where userid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(delete);
			pstmt.setString(1, userid);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}
}
