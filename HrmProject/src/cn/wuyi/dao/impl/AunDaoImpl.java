package cn.wuyi.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.wuyi.domain.Aun;
import cn.wuyi.domain.PageBean;
import cn.wuyi.domain.QueryInfo;
import cn.wuyi.domain.QueryResult;
import cn.wuyi.util.JDBCUtil;

public class AunDaoImpl {
	public int addaun(String dpname,String dpdesp) {
		// 新增用户
			String sql = "insert into aun_inf(title,content) values(?,?);";
			// 将当前时间转换成指定的格式
			
			String info[] = { dpname, dpdesp};
			
			int rs = JDBCUtil.executeUpdate(sql, info);
	        
			System.out.println(info);
			// 返回操作的结果
			return rs;
		}


 
// 3 .用户分页查询
	@SuppressWarnings("resource")
	public QueryResult pageQuery(int startindex, int pagesize) {
		ResultSet rs = null;
		QueryResult qr = new QueryResult();
		try {
			String sql = "select * from aun_inf limit " + startindex + "," + pagesize;
			rs = JDBCUtil.executeQuery(sql, null);
			List<Aun> list = new ArrayList<>();
			while (rs.next()) {
				Aun dp = new Aun();
				dp.setId(rs.getInt("id"));
				dp.setaun_title(rs.getString("title"));
				dp.setaun_content(rs.getString("content"));
				
	
				//将得到的对象放到集合中
				list.add(dp);
			}
			qr.setList(list);
	
			sql = "select count(*) from aun_inf";
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
	public PageBean aunageQuery(QueryInfo queryInfo) {
	
		// 调用dao获取到页面数据
		QueryResult qr = pageQuery(queryInfo.getStartindex(), queryInfo.getPagesize());
	
		//根据dao查询结果，生成页面显示需要pagebean
		PageBean bean = new PageBean();
		bean.setCurrentpage(queryInfo.getCurrentpage());
		bean.setList(qr.getList());
		bean.setPagesize(queryInfo.getPagesize());
		bean.setTotalrecord(qr.getTotalrecord());
	
		return bean;
	}
		

}
