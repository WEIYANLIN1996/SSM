package cn.wuyi.dao.impl;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import cn.wuyi.domain.Staff;
import cn.wuyi.domain.PageBean;
import cn.wuyi.domain.QueryInfo;
import cn.wuyi.domain.QueryResult;
import cn.wuyi.util.JDBCUtil;

public class StaffDaoImpl {
	
	public int addstaff(Staff staff) {
		// 新增用户
			String sql = "insert into employeef(JOB_ID,NAME,ADDRESS,PHONE,QQ_NUM,EMAIL,SEX,PARTY,BIRTHDAY,CREATE_DATE) values(?,?,?,?,?,?,?,?,?,?);";
			// 将当前时间转换成指定的格式
			
			String createTiem = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(staff.getCreatedate());
			String info[] = { "12345", staff.getname(), staff.getaddress(),staff.getphone(),staff.getqq(),staff.getemail(),
					"1",staff.getparty(),staff.getbirthday(),createTiem};
			int rs = JDBCUtil.executeUpdate(sql, info);
	        
			System.out.println(info);
			// 返回操作的结果
			return rs;
		}

	// 3.用户分页查询
	@SuppressWarnings("resource")
	public QueryResult pageQuery(int startindex, int pagesize) {
		ResultSet rs = null;
		QueryResult qr = new QueryResult();
		try {
			String sql = "select * from employeef limit " + startindex + "," + pagesize;
			rs = JDBCUtil.executeQuery(sql, null);
			List<Staff> list = new ArrayList<>();
			while (rs.next()) {
				Staff dp = new Staff();
				dp.setId(rs.getInt("id"));
				dp.setjobid(rs.getInt("JOB_ID"));
				dp.setname(rs.getString("NAME"));
				dp.setaddress(rs.getString("ADDRESS"));
				dp.setphone(rs.getString("PHONE"));
				dp.setqq(rs.getString("QQ_NUM"));
				dp.setemail(rs.getString("EMAIL"));
				dp.setsex(rs.getInt("SEX"));
				dp.setparty(rs.getString("PARTY"));
				dp.setbirthday(rs.getString("BIRTHDAY"));
				dp.setCreatedate(rs.getDate("CREATE_DATE"));

				//将得到的对象放到集合中
				list.add(dp);
			}
			qr.setList(list);
			System.out.println(list);

			sql = "select count(*) from employeef";
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
	public PageBean staffpageQuery(QueryInfo queryInfo) {

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
