package com.usagi.dto.UserVo;

import java.sql.Timestamp;

public class UserVo {
	private int num;
	private String name;
	private String userid;
	private String userpw;
	private String useremail;
	private String gender;
	private int loginnum;
	private int mail_confirm;
	private int admin;
	private Timestamp signupdate;



	public int getLoginnum() {
		return loginnum;
	}

	public void setLoginnum(int loginnum) {
		this.loginnum = loginnum;
	}

	public Timestamp getSignupdate() {
		return signupdate;
	}

	public void setSignupdate(Timestamp signupdate) {
		this.signupdate = signupdate;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getMail_confirm() {
		return mail_confirm;
	}

	public void setMail_confirm(int mail_confirm) {
		this.mail_confirm = mail_confirm;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

}
