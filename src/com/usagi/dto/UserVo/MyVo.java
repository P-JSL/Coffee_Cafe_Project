package com.usagi.dto.UserVo;

import java.sql.Timestamp;

public class MyVo {
	private Timestamp signupdate;
	private Timestamp b_date;
	private int loginnum;
	private int b_count;

	

	public Timestamp getSignupdate() {
		return signupdate;
	}

	public void setSignupdate(Timestamp signupdate) {
		this.signupdate = signupdate;
	}

	public Timestamp getB_date() {
		return b_date;
	}

	public void setB_date(Timestamp b_date) {
		this.b_date = b_date;
	}

	public int getLoginnum() {
		return loginnum;
	}

	public void setLoginnum(int loginnum) {
		this.loginnum = loginnum;
	}

	public int getB_count() {
		return b_count;
	}

	public void setB_count(int b_count) {
		this.b_count = b_count;
	}

}
