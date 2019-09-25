package com.database.user.dateutil;

import java.sql.*;

public class JDBCUtil {
	
	public static Connection getConnection() throws SQLException,ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/sql3?useUnicode=true&characterEncoding=utf-8";
		String username="root";
		String password="wyl336339";
		Connection conn=DriverManager.getConnection(url,username,password);
		return conn;
	}
	
	public static void release(PreparedStatement stmt,Connection conn) {
		if (stmt!=null) {
			try {
				stmt.close();				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void release(ResultSet rs,PreparedStatement stmt,Connection conn) {
		if(rs!=null) {
			try {
				rs.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			rs=null;
			
		}
		release(stmt,conn);
	}

}
