package com.usagi.dto.ContactVo;

import java.sql.Timestamp;

public class ContactVo {
	private String name;
	private String id;
	private String email;
	private String msg;
	private Timestamp send_date;
	private int num;
	private String response;
	private int res_confirm;

	public int getRes_confirm() {
		return res_confirm;
	}

	public void setRes_confirm(int res_confirm) {
		this.res_confirm = res_confirm;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public ContactVo(String name, String id, String email, String msg) {
		super();
		this.name = name;
		this.id = id;
		this.email = email;
		this.msg = msg;
	}

	public ContactVo() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Timestamp getSend_date() {
		return send_date;
	}

	public void setSend_date(Timestamp send_date) {
		this.send_date = send_date;
	}

}
