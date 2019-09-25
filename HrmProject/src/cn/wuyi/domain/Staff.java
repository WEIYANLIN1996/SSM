package cn.wuyi.domain;

import java.io.Serializable;
import java.util.Date;

public class Staff implements Serializable {
	private int id;//id
	private String name;//登录名
	private int jobid;//密码
	private Date createdate;//创建时间
	private String address;//用户名
	private String phone;
	private String qq;
	private String email;
	private int sex;
	private String party;
	private String birthday;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public int getjobid() {
		return jobid;
	}
	public void setjobid(int jobid) {
		this.jobid = jobid;
	}
	public String getaddress() {
		return address;
	}
	public void setaddress(String address) {
		this.address = address;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public String getphone() {
		return phone;
	}
	public void setphone(String phone) {
		this.phone = phone;
	}
	public String getqq() {
		return qq;
	}
	public void setqq(String qq) {
		this.qq = qq;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public int getsex() {
		return sex;
	}
	public void setsex(int sex) {
		this.sex = sex;
	}
	public String getparty() {
		return party;
	}
	public void setparty(String party) {
		this.party = party;
	}
	public String getbirthday() {
		return birthday;
	}
	public void setbirthday(String birthday) {
		this.birthday=birthday;
	}
	public Staff() {
		super();
	}
	public Staff(int id, String name, int jobid, String address, Date createdate,String phone,String qq,int sex,String email,String party,String birthday) {
		super();
		this.id = id;
		this.name = name;
		this.jobid = jobid;
		this.address = address;
		this.createdate = createdate;
		this.phone = phone;
		this.qq = qq;
		this.email = email;
		this.sex = sex;
		this.party = party;
		this.birthday=birthday;
	}
	//toString（）,方便输出
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", jobid=" + jobid + ", address=" + address
				+ ", createdate=" + createdate + ", phone=" + phone + ",qq="+qq+", email="+email+",sex="+sex+",party="+party+",birthday="+birthday+"]";
	}
	
	
	
	
	
	
}