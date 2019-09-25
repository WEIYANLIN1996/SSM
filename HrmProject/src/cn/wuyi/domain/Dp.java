package cn.wuyi.domain;

import java.io.Serializable;
import java.util.Date;

public class Dp implements Serializable {
	private int id;//id
	private String dp_name;//登录名
	private String dp_desp;//密码
	//用户名
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getdp_name() {
		return dp_name;
	}
	public void setdp_name(String dp_name) {
		this.dp_name = dp_name;
	}
	public String getdp_desp() {
		return dp_desp;
	}
	public void setdp_desp(String dp_desp) {
		this.dp_desp = dp_desp;
	}
	
	public Dp() {
		super();
	}
	public Dp(int id, String dp_name, String dp_desp) {
		super();
		this.id = id;
		this.dp_name = dp_name;
		this.dp_desp = dp_desp;
		
	}
	//toString（）,方便输出
	@Override
	public String toString() {
		return "User [id=" + id + ", dp_name=" + dp_name + ", dp_desp=" + dp_desp + "]";
	}
	
	
	
	
	
	
}