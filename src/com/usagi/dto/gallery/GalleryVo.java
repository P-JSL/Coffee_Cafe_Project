package com.usagi.dto.gallery;

import java.sql.Timestamp;

public class GalleryVo {
	private int num;
	private String photo;
	private Timestamp photodate;
	private String userid;
	private int rnum;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Timestamp getPhotodate() {
		return photodate;
	}

	public void setPhotodate(Timestamp photodate) {
		this.photodate = photodate;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}


}
