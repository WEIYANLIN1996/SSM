<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title>数据库增删查改</title>
	<link rel="stylesheet" href="http://localhost:8080/Dateoperate/jsp/css/bootstrap.min.css" />
	<script type="text/javascript" src="http://localhost:8080/Dateoperate/jsp/js/jquery.min.js" ></script>
	<script type="text/javascript" src="http://localhost:8080/Dateoperate/jsp/js/vue.min.js" ></script>
	<script src="http://localhost:8080/Dateoperate/jsp/js/vue-resource.min.js"></script>
</head>
<style>
	*{margin: 0;padding: 0;}
	.main{
		width: 500px;
		height:550px;
		margin: 20px auto;
		border: 1px solid salmon;
	}
	.title{
		width: 100%;
		height: 40px;
		border:1px solid bisque;
		display:inline-flex;
	}
	.title button{
		flex: 1;
	}
	.seacher{
		width: 500px;
		height: 500px;
		position: absolute;
		margin-top: 0px;
		border: 1px solid black;
		
	}
	.insert{
		width: 500px;
		height: 500px;
		position: absolute;
		margin-top: 0px;
		border: 1px solid green;
		display:node;
		
	}
	#change{
		width: 100px;
		height: 30px;
		background: blue;
		color:white;
	}
</style>
<body>
	<div class="main">
		<div class="title"><button v-on:click="qh($event)">全部</button><button v-on:click="qh($event)">插入</button><button v-on:click="qh($event)">搜索</button></div>
		<div class="seacher" v-bind:style="{display:isHide}">
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th>账号</th>
			      <th>密码</th>
			      <th>电话</th>
			      <th>操作</th>
			    </tr>
			  </thead>
			  <tbody>			    
			   <c:forEach var="c" items="${beanlist}"
					varStatus="status">
				<tr>
					<td>${c.id}</td>
					<td>${c.user}</td>
					<td>${c.psw}</td>
					<td>${c.num}</td>
					<td><a href="http://localhost:8080/Dateoperate/updateServlet?id=${c.id}&user=${c.user}">修改</a> <a href="http://localhost:8080/Dateoperate/deleteServlet?id=${c.id}">删除</a></td>
			    </tr>
			  </c:forEach>
			  </tbody>
			</table>
		</div>
		<div class="insert" v-bind:style="{display:isHide2}">
			<form>
				账号：<input type="text" name='user' v-model="inputtext.name"><br>
				密码：<input type="text" name='psw' v-model="inputtext.psw"><br>
				电话：<input type="text" name='num' v-model="inputtext.num"><br>
				<input type="button" v-on:click="formpost" id="change" value="插入" />
			</form>
		</div>
		<div class="ifs" v-bind:style="{display:isHide3}">
			<form>
				账号：<input type="text" name='user' v-model="s_key"><br>
				<input type="button" v-on:click="seacherget" id="change" value="查找" />
			</form>
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th>账号</th>
			      <th>密码</th>
			      <th>电话</th>
			      <th>操作</th>
			    </tr>
			  </thead>
			  <tbody>			    			   
				<tr v-for="seacher in seachers">
					<td v-text="seacher.id"></td>
					<td v-text="seacher.user"></td>
					<td v-text="seacher.psw"></td>
					<td v-text="seacher.num"></td>
					<td ><a href="">修改</a> <a href="">删除</a></td>
			    </tr>			 
			  </tbody>
			</table>
		</div>
	</div>
	<script>
		var app=new Vue({
		  el: '.main',
		  data: {
		    isHide: 'block',
		    isHide2: 'none',
		    isHide3: 'none',
		    inputtext:{},
		    s_key:'',
		    seachers:[]
		  },
		  methods: {
		    qh: function (e) {	
		      console.log(e.target.innerHTML);
		      if(e.target.innerHTML=="全部"){
		      	app.isHide="block";
		      	app.isHide2="none";
		      	app.isHide3="none";
		      	
		      	
		      }
		      if(e.target.innerHTML=="插入"){
		      	app.isHide2="block";
		      	app.isHide="none";
		      	app.isHide3="none";

		      }
		      if(e.target.innerHTML=="搜索"){
		      	app.isHide3="block";
		      	app.isHide2="none";
		      	app.isHide="none";		      	
		      }
		    },
		    formpost:function(){
		    	this.$http.post('http://localhost:8080/Dateoperate/InsertServlet',{accunt:app.inputtext.name,psw:app.inputtext.psw,num:app.inputtext.num},{emulateJSON:true}).then(function(res){
		    		console.log(res.status);
		    	},function(res){
                   console.log(res.status);
                   alert("提交失败！");
                   });
		    },
		    seacherget:function(){
		    	this.$http.get('http://localhost:8080/Dateoperate/seacherServlet?key='+app.s_key).then(function(res){
		    		var str =JSON.parse(res.bodyText);		    		 
		    		app.seachers=str;
		    		
		    		
                },function(){
                    console.log('请求失败处理');
                });
		    }
		  }
		})
	</script>
</body>
</html>