package cn.wuyi.domain;

import java.io.Serializable;

public class Job implements Serializable {
	private int id;//id
	private String job_name;//登录名
	private String job_desp;//密码
	//用户名
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getjob_name() {
		return job_name;
	}
	public void setjob_name(String job_name) {
		this.job_name = job_name;
	}
	public String getjob_desp() {
		return job_desp;
	}
	public void setjob_desp(String job_desp) {
		this.job_desp = job_desp;
	}
	
	public Job() {
		super();
	}
	public Job(int id, String job_name, String job_desp) {
		super();
		this.id = id;
		this.job_name = job_name;
		this.job_desp = job_desp;
		
	}
	//toString（）,方便输出
	@Override
	public String toString() {
		return "User [id=" + id + ", job_name=" + job_name + ", job_desp=" + job_desp + "]";
	}
	
	
	
	
	
	
}