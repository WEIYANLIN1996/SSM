<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title></title>
</head>
<style>
	#change{
		width: 100px;
		height: 30px;
		background: blue;
		color:white;
	}
</style>

<body>
	<div class="insert">
			<form action="http://localhost:8080/Dateoperate/updateServlet" method="post">
			    <input type="hidden" name="id" value="${user[0]}">
				账号：<input type="text" name='user' value="${user[1]}"><br>
				密码：<input type="text" name='psw'><br>
				电话：<input type="text" name='num'><br>
				<input type="submit" name="" id="change" value="修改" />
			</form>
		</div>
</body>
</html>