<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>所有数据</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    所有结果<br/>
    <table border="1">
    	<tr>
    		<td>编号</td>
    		<td>用户名</td>
    		<td>密码</td>
    		<td>电话</td>
    		<td>邮箱</td>
    		<td>性别</td>
    		<td>操作</td>
    	</tr>
    	
    	<c:forEach var="list"  items="${addLists}">
    	<tr>
    		<td>${list.userId}</td>
    		<td>${list.userName}</td>
    		<td>${list.userPassword}</td>
    		<td>${list.userPhone}</td>
    		<td>${list.userEmail}</td>
    		<td>${list.userSex}</td>
    		<td><a href="modifyUser.do?tid=${list.userId}">更新</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="deleteUser.do?tid=${list.userId}">删除</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="getAllCar.do?userId=${list.userId}">管理车</a></td>
    	</tr>
    	</c:forEach> 
    </table>
  </body>
</html>
