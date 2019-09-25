package cn.wuyi.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wuyi.dao.impl.JobDaoImpl;
import cn.wuyi.domain.PageBean;
import cn.wuyi.domain.QueryInfo;
import cn.wuyi.util.WebUtils;

@WebServlet("/SelectJobServlet")
public class SelectJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			QueryInfo info = WebUtils.request2Bean(request, QueryInfo.class);
			JobDaoImpl service = new JobDaoImpl();
			PageBean pagebean = service.jobpageQuery(info);
			request.setAttribute("pagebean", pagebean);
			System.out.println(pagebean.getList());
			//转发到用户信息显示页面
			request.getRequestDispatcher("/selectpst.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "查看部门失败！！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
