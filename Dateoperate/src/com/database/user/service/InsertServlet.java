package com.database.user.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.dao.*;
import com.database.user.dateutil.*;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user=request.getParameter("accunt");
		String psw=request.getParameter("psw");
		String num=request.getParameter("num");
		if(user!=null&&psw!=null&&num!=null) {
			User us=new User();
			us.setId(5);
			us.setUser(user);
			us.setPsw(psw);
			us.setNum(num);
			boolean result=DataZscg.insert(us);			
			if(result) {
				System.out.print("Ìí¼Ó³É¹¦£¡");
			}
			else {
				System.out.print("Ê§°Ü");
			}
		}
		else {
			System.out.print("Ê§°Ü");
			System.out.print(user+psw+num);
		}
		
	}

}
