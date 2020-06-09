package com.usagi.dto.FileVo;

import java.sql.Timestamp;

public class FileVo {
	private int num;
	private String files;
	private Timestamp upload_day;
	private String userid;
	private int size;
	
	

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getFiles() {
		return files;
	}

	public void setFiles(String files) {
		this.files = files;
	}

	public Timestamp getUpload_day() {
		return upload_day;
	}

	public void setUpload_day(Timestamp upload_day) {
		this.upload_day = upload_day;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

}
