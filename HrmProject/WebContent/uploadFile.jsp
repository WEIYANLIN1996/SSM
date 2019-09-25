<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传文件</title>
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="easyui/demo/demo.css">
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript">
	// 项div中间添加文本框
	function run() {
		var div = document.getElementById("divId");
		div.innerHTML += "<div style='width:700px;height:50px;border-bottom:1px solid deepskyblue;margin-top:5px;'><input style='width:400px;height:45px;' type='file' name='myfile'><input type='button' style='width:50px;height:35px;background:red;border:1px solid deepskyblue;' value='删除' onclick='del(this)'/></div>";
	}

	// 删除某一行
	function del(who) {
		// 获取删除的按钮的父节点
		var divv = who.parentNode;
		divv.parentNode.removeChild(divv); // 最外围的div
	}
</script>

</head>
<body>
	<div id="p" class="easyui-panel" title="文件上传" style="width:700px;height:600px;padding:10px;">
		
		<form action="${ pageContext.request.contextPath }/UploadServlet"
			method="post" enctype="multipart/form-data">
			<input type="button" style="width:90px;height:35px;background:deepskyblue;border:2px solid deepskyblue;color:white;" value="添加" onclick="run()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" style="width:90px;height:35px;background:deepskyblue;border:1px solid deepskyblue;color:white;" value="上传" />
			<div id="divId" style="width:400px;height:600px;margin-top:20px;"></div>
			
		</form>
	</div>

</body>
</html>