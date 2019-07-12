<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Welcome</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.11.1.js"></script>
	<script type="text/javascript">
		$(function () {
			$("#call").click(function (){
				$.getJSON ('<%=basePath%>api', {key:'value'},function (resp) {
					alert(resp.realName);
					alert(resp.address);
				});
			});
		});
	</script>
  </head>
  
  <body>
    J2EE--DEMO项目<hr />
    <a href='<%=basePath%>regist'>注册</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href='javascript:void)(0);' id="call">调用接口</a>
  </body>
</html>
