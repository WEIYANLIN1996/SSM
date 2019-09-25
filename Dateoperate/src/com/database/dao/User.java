package com.database.dao;

public class User {
	private int id;
	private String user;
	private String psw;
	private String num;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public void setUser(String user) {
		this.user=user;
	}
	public String  getUser() {
		return user;
	}
	public void setPsw(String psw) {
		this.psw=psw;
	}
	public String getPsw() {
		return psw;
	}
	public void setNum(String num) {
		this.num=num;
	}
	public String  getNum() {
		return num;
	}
	

}
