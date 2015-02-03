<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();

String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改数据</title>
    
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
    <form action="<%=request.getContextPath() %>/updateUser.do" method="post">
    	用户名：<input type="text" name="userName" value="${add.userName }"><br>
		密码：<input type="password" name="userPassword" value="${add.userPassword }"><br>
		电话：<input type="text" name="userPhone" value="${add.userPhone }"><br>
		邮箱：<input type="text" name="userEmail" value="${add.userEmail }"><br>
		性别：<input type="text" name="userSex" value="${add.userSex }"><br>
		<input type="hidden" name="userId" value="${add.userId }"><br>
        <input type="submit" value="提交数据">

      </form>
  </body>
</html>
