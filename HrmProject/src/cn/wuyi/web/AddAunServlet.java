package cn.wuyi.web;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wuyi.dao.impl.AunDaoImpl;

@WebServlet("/AddAunServlet")
public class AddAunServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//以下两句代码处理中文乱码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//获取客户端发送过来的用户信息
		String aunname = request.getParameter("auntitle");
		String auncontent = request.getParameter("auncontent");
		
		//将得到的数据封装到对象中
		/**Dp dp = new Dp();
		dp.setdp_name(dpname);
		dp.setdp_desp(dpdesp);
		*/
		//int类型
		
		//调用Servlet层的添加方法
		AunDaoImpl us = new AunDaoImpl();
		int rs = us.addaun(aunname,auncontent);
		if(rs!=0) {
			//往页面放回数据
			response.getWriter().append("1");
		}else {
			response.getWriter().append("0");
		}		 
		System.out.println("部门名是："+aunname);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}