<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公告查询</title>
<link rel="stylesheet" type="text/css"
	href="easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
</head>
<body>
	<div title="查询用户" style="padding: 20px">
		<table class="easyui-datagrid" title="员工信息表"
			style="width: 100%; height: 400px"
			data-options="singleSelect:true,collapsible:true,url:'datagrid_data1.json',method:'get'">
			<thead>
				<tr>
					<th data-options="field:'itemid',align:'center',resizable:false"
						width="10%">编号id</th>
					<th data-options="field:'productid',align:'center',resizable:false"
						width="20%">公告主题</th>
					<th data-options="field:'listprice',align:'center',resizable:false"
						width="10%">公告内容</th>
					<th data-options="field:'status',align:'center',resizable:false"
						width="10%">操作</th>
				</tr>
			</thead>
			<tr>
				<c:forEach var="c" items="${requestScope.pagebean.list}"
					varStatus="status">
					<td>${c.id}</td>
					<td>${c.aun_title}</td>
					<td>${c.aun_content}</td>
					<td><a href="">修改</a> <a href="">删除</a></td>
			</tr>
			</c:forEach>
		</table>
		<div style="text-align: center; margin-top: 20px">
			共[${pagebean.totalrecord }]条记录, 每页 <input type="text" id="pagesize"
				value="${pagebean.pagesize }"
				onchange="changesize(this.value,${pagebean.pagesize })"
				style="width: 30px" maxlength="2">条, 共[${pagebean.totalpage }]页,
			当前[${pagebean.currentpage }]页 &nbsp; <a class="easyui-linkbutton"
				href="javascript:void(0)" onclick="gotopage(1)">首页</a> <a
				class="easyui-linkbutton" href="javascript:void(0)"
				onclick="gotopage(${pagebean.previouspage })">上一页</a>
			<c:forEach var="pagenum" items="${pagebean.pagebar}">
				<c:if test="${pagenum==pagebean.currentpage}">
					<font color='red'>${pagenum }</font>
				</c:if>

				<c:if test="${pagenum!=pagebean.currentpage}">
					<a class="easyui-linkbutton" href="javascript:void(0)"
						onclick="gotopage(${pagenum })">${pagenum }</a>
				</c:if>
			</c:forEach>
			<a class="easyui-linkbutton" href="javascript:void(0)"
				onclick="gotopage(${pagebean.nextpage })">下一页</a> <a
				class="easyui-linkbutton" href="javascript:void(0)"
				onclick="gotopage(${pagebean.totalpage })">尾页</a> <input type="text"
				id="pagenum" style="width: 30px" /> <input type="button"
				value=" GO "
				onclick="gotopage(document.getElementById('pagenum').value)" />
		</div>
	</div>

</body>
<script type="text/javascript">
    	function gotopage(currentpage){
    		if(currentpage<1 || currentpage!=parseInt(currentpage) || currentpage>'${pagebean.totalpage}'){
    			alert("请输入有效值！！");
    			document.getElementById("pagenum").value = '';
    		}else{
	    		var pagesize = document.getElementById("pagesize").value;
	    		window.location.href = '${pageContext.request.contextPath}/SelectAunServlet?currentpage=' + currentpage + '&pagesize=' + pagesize;
    		}
    	}
    	
    	function changesize(pagesize,oldvalue){
    		if(pagesize<0 || pagesize!=parseInt(pagesize)){
    			alert("请输入合法值！！");
    			document.getElementById("pagesize").value = oldvalue;
    		}else{
    			window.location.href = '${pageContext.request.contextPath}/SelectAunServlet?pagesize=' + pagesize;
    		}
}
    </script>
</html>