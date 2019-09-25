package cn.wuyi.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wuyi.dao.impl.StaffDaoImpl;
import cn.wuyi.domain.Staff;

@WebServlet("/AddstaffServlet")
public class AddSatffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//以下两句代码处理中文乱码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获取客户端发送过来的用户信息
		String name = request.getParameter("name");
		String jobid = request.getParameter("jobid");
		String qq = request.getParameter("qq");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String party = request.getParameter("party");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		
		
		//将得到的数据封装到对象中
		Staff dp = new Staff();
		dp.setjobid(12345);
		dp.setname(name);
		dp.setaddress(address);
		dp.setphone(phone);
		dp.setqq(qq);
		dp.setemail(email);
		dp.setsex(1);
		dp.setparty(party);
		dp.setbirthday(birthday);
		dp.setCreatedate(new Date());
	
		//int类型
		
		//调用Servlet层的添加方法
		StaffDaoImpl us = new StaffDaoImpl();
		int rs = us.addstaff(dp);
		if(rs!=0) {
			//往页面放回数据
			response.getWriter().append("1");
		}else {
			response.getWriter().append("0");
		}
		System.out.println("部门名是："+name);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}