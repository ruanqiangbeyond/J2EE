<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();

String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改车数据</title>
    
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
    <form action="<%=request.getContextPath() %>/updateCar.do" method="post">
    	车名：<input type="text" name="carName" value="${add.carName }"><br>
		图片：<input type="text" name="carImage" value="${add.carImage }"><br>
		变速箱：<input type="text" name="carGearboxes" value="${add.carGearboxes }"><br>
		<input type="hidden" name="carId" value="${add.carId }"><br>
        <input type="submit" value="提交数据">

      </form>
  </body>
</html>
