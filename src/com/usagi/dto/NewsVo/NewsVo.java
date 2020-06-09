package com.usagi.dto.NewsVo;

import java.sql.Timestamp;

public class NewsVo {
	private int num;
	private String title;
	private String content;
	private String photo;
	private Timestamp news_date;
	private String userid;
	private int admin;

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getNews_date() {
		return news_date;
	}

	public void setNews_date(Timestamp news_date) {
		this.news_date = news_date;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

}
