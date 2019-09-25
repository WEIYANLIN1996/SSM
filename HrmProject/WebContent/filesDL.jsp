<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件下载</title>
<link rel="stylesheet" type="text/css" href="easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="easyui/demo/demo.css">
<script type="text/javascript" src="easyui/jquery.min.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<style type="text/css">
td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<div id="p" class="easyui-panel" title="文件下载  " style="width:700px;height:600px;padding:10px;">
		<table style="border-spacing:10px 8px;width：600px;">
			<c:forEach items="${list}" var="li">
				<tr style="width:600px;height:35px;">
					<form action="${ pageContext.request.contextPath }/DownloadlistServlet" method="post">
					<td style="width:450px;border:1px solid blue;"><input style="width:80%;" type="hidden" name="path" value="${li.filepath }">${li.filename }
					</td>
					<td style="width:90px;border:none "><input style="width:100%;height:35px;border-radius: 7px;background: blue;"type="submit" value="下载"></td>
					</form>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>