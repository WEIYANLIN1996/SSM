package com.database.user.dateutil;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.database.dao.*;
public class beanList {
	
	public static List rList(ResultSet rs) {
		List list=new ArrayList();
		try {
			while(rs.next()){
		        // 可以根据列名称也可以根据列索引
		        int id = rs.getInt("id");
		        String username = rs.getString("user");
		        String psw = rs.getString("psw");
		        String num = rs.getString("num");
		        System.out.println(id+":"+username+":"+num);
		        User c = new User();
		        c.setId(id);
		        c.setUser(username);
		        c.setPsw(psw);
		        c.setNum(num);
		        //将对象存放到list容器中
		        list.add(c);
		    }
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}		
		return null;
	}

}
