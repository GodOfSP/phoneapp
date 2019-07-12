<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Regist</title>
    
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
    Regist. <hr />
    <form action="<%=basePath%>regist" method="post">
    
    	<label>用户名：</label><input type="text" id="userName" name="userName" /><br />
    	<label>真实姓名：</label><input type="text" id="realName" name="realName" /><br />
    	<label>密码：</label><input type="password" id="password" name="password" /><br />
    	<label>生日：</label><input type="text" id="birthday" name="birthday" /><br />
    	<label>地址：</label><input type="text" id="address" name="address" /><br />
    	<br />
    	<input type="submit" value="提交" />
    	<input type="reset" value="重置" />
    	<a href="javascript:void(0);" onclick="javascript:history.go(-1);">返回</a>
    	
    </form>
  </body>
</html>
