package com.database.user.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ArrayList;
import com.database.dao.*;
import com.database.user.dateutil.DataZscg;
/**
 * Servlet implementation class updateServlet
 */
@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		String user=request.getParameter("user");
		String [] ms= {id,user};
		//List list=new ArrayList();
		//list.add(ms);
		request.setAttribute("user",ms);
		request.getRequestDispatcher("/jsp/update.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		String user=request.getParameter("user");
		String psw=request.getParameter("psw");
		String num=request.getParameter("num");
		System.out.print(id);
		int ids=Integer.parseInt(id);
		User us=new User();
		us.setId(ids);
		us.setUser(user);
		us.setPsw(psw);
		us.setNum(num);
		boolean rs=DataZscg.update(us);
		if(rs) {
			request.setAttribute("msg", "修改成功");
			request.getRequestDispatcher("/hello.jsp").forward(request, response);
		}else {
			request.setAttribute("msg", "修改失败");
			request.getRequestDispatcher("/hello.jsp").forward(request, response);
		}
		
	}

}
