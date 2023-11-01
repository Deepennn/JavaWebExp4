<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>显示详细注册信息</title>
</head>
<body>
<p align="right">
<a href="modify.jsp">[更改]</a>
<a href="login.jsp">[退出]</a>
<a href="showdetailedinfo.jsp">[@李嘉梁]</a>
<center>

<h1 align="center"><span style="color:green">${success}</span></h1>

<h3>您的详细注册信息：</h3>
<jsp:useBean id="readdetailedinfobean" type="beans.DetailedInfoBean" scope="session" />
<p>您的用户名是：
<jsp:getProperty name="readdetailedinfobean" property="username" />
<p>您的年龄是：
<jsp:getProperty name="readdetailedinfobean" property="age" />
<p>您的性别是：
<jsp:getProperty name="readdetailedinfobean" property="sexy" />
<p>您的照片存储在服务器上的位置是：
<jsp:getProperty name="readdetailedinfobean" property="pictureLocation" />
</center></body>
</html>