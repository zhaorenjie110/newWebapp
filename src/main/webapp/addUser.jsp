<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'addUser.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">  
    function addUser(){  
        var form = document.forms[0];  
        form.action = "user/addUser";  
        form.method="post";  
        form.submit();  
    }  
	</script>
</head>

<body>
	<h1>添加用户</h1>
	<form action="" name="userForm">
		姓名：<input type="text" name="userName"> 年龄：<input type="text"
			name="age"> <input type="button" value="添加"
			onclick="addUser()">
	</form>
</body>
</html>
