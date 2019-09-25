package cn.wuyi.dao;

import cn.wuyi.domain.QueryResult;
import cn.wuyi.domain.User;


public interface UserDao {
//1.通过登录名查询id,查询到的结果，封装到javabean对象，返回给Servic层,这是一个抽象方法
	User findByLoginname(User user);
	//2.添加用户
	int addUser(User user);
	//3.分页查询用户
	public QueryResult pageQuery(int startindex,int pagesize);
}
