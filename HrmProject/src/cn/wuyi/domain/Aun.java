package cn.wuyi.domain;

import java.io.Serializable;

public class Aun implements Serializable {
	private int id;//id
	private String aun_title;//登录名
	private String aun_content;//密码
	//用户名
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getaun_title() {
		return aun_title;
	}
	public void setaun_title(String aun_title) {
		this.aun_title = aun_title;
	}
	public String getaun_content() {
		return aun_content;
	}
	public void setaun_content(String aun_content) {
		this.aun_content = aun_content;
	}
	
	public Aun() {
		super();
	}
	public Aun(int id, String aun_title, String aun_content) {
		super();
		this.id = id;
		this.aun_title = aun_title;
		this.aun_content = aun_content;
		
	}
	//toString（）,方便输出
	@Override
	public String toString() {
		return "User [id=" + id + ", aun_title=" + aun_title + ", aun_content=" + aun_content + "]";
	}
	
	
	
	
	
	
}