package com.database.user.dateutil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import com.database.dao.*;
import java.util.List;

public class DataZscg {
	
	public static List excuteQuery(String sql) {
		
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try{
			conn=JDBCUtil.getConnection();
			stmt=conn.prepareStatement(sql);
			rs=stmt.executeQuery(sql);
			List list=new ArrayList();
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
		}finally {
			JDBCUtil.release(rs, stmt, conn);
		}
		return null;
	}
    public static boolean insert(User user) {
    	Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		String sql="INSERT INTO users(user,psw,num)"+"VALUES(?,?,?)";
		try{
			conn=JDBCUtil.getConnection();
			stmt=conn.prepareStatement(sql);
			stmt.setString(1,user.getUser());
			stmt.setString(2,user.getPsw());
			stmt.setString(3,user.getNum());
			stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.release(rs, stmt, conn);
		}
		return true;
    }
    public static boolean dedel(String id) {
    	Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		String sql="DELETE FROM users WHERE id="+"'"+id+"'";
		try{
			conn=JDBCUtil.getConnection();
			stmt=conn.prepareStatement(sql);
			stmt.executeUpdate();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.release(rs, stmt, conn);
		}
		return false;
    }
    public static boolean update(User user) {
    	Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		String sql="UPDATE users SET user="+"'"+user.getUser()+"'"+", psw="+user.getPsw()+",num="+user.getNum()+" WHERE id="+user.getId();
		try{
			conn=JDBCUtil.getConnection();
			stmt=conn.prepareStatement(sql);
			stmt.executeUpdate();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.release(rs, stmt, conn);
		}
		return false;
    }
    public static List seacher(String user) {
    	Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		String sql="SELECT * FROM users WHERE user="+"'"+user+"'";
		try{
			conn=JDBCUtil.getConnection();
			stmt=conn.prepareStatement(sql);
			rs =stmt.executeQuery();
			List list=new ArrayList();
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
		}finally {
			JDBCUtil.release(rs, stmt, conn);
		}
		return null;
    }
}
