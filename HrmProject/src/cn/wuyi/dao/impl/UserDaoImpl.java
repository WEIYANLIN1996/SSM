package cn.wuyi.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import cn.wuyi.dao.UserDao;
import cn.wuyi.domain.QueryResult;
import cn.wuyi.domain.User;
import cn.wuyi.util.JDBCUtil;


/**
 * 操作数据库
 * 
 * @author newuser
 *
 */
public class UserDaoImpl implements UserDao {

	@Override
	public User findByLoginname(User user) {
		String sql = "select * from user_inf where loginname=?";
		String info[] = { user.getLoginname() };
		// 查询数据
		ResultSet rs = JDBCUtil.executeQuery(sql, info);
		// 将查询到的数据封装到javabean，并返回
		try {
			if (rs.next()) {
				// 创建一个对象
				User user_rs = new User();
				// 将查询到的数据封装到对象中
				user_rs.setId(rs.getInt("id"));
				user_rs.setLoginname(rs.getString("loginname"));
				user_rs.setPassword(rs.getString("password"));
				user_rs.setStatus(rs.getInt("status"));
				user_rs.setCreatedate(rs.getDate("createdate"));
				user_rs.setUsername(rs.getString("username"));
				System.out.println(user_rs);
				return user_rs;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtil.close(JDBCUtil.getCt(), JDBCUtil.getPs(), JDBCUtil.getRs());
		}

		return null;
	}

	// 添加用户
	@Override
	public int addUser(User user) {

		// 新增用户
		String sql = "insert into user_inf(loginname,PASSWORD,STATUS,createdate,username) values(?,?,?,?,?);";
		// 将当前时间转换成指定的格式
		String createTiem = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(user.getCreatedate());
		String info[] = { user.getLoginname(), user.getPassword(), user.getStatus() + "", createTiem,
				user.getUsername() };
		int rs = JDBCUtil.executeUpdate(sql, info);

		// 返回操作的结果
		return rs;
	}

	// 3.用户分页查询
	@SuppressWarnings("resource")
	public QueryResult pageQuery(int startindex, int pagesize) {
		ResultSet rs = null;
		QueryResult qr = new QueryResult();
		try {
			String sql = "select * from user_inf limit " + startindex + "," + pagesize;
			rs = JDBCUtil.executeQuery(sql, null);
			List<User> list = new ArrayList<>();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setLoginname(rs.getString("loginname"));
				user.setPassword(rs.getString("password"));
				user.setUsername(rs.getString("username"));
				user.setCreatedate(rs.getDate("createdate"));
				user.setStatus(rs.getInt("status"));
	
				//将得到的对象放到集合中
				list.add(user);
			}
			qr.setList(list);

			sql = "select count(*) from user_inf";
			rs = JDBCUtil.executeQuery(sql, null);
			if (rs.next()) {
				int totalrecord = rs.getInt(1);
				qr.setTotalrecord(totalrecord);
				System.out.println("总记录数：" + totalrecord + "条");
			}
			return qr;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(JDBCUtil.getCt(), JDBCUtil.getPs(), rs);
		}
		return null;
	
	
	}
}
