<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更改详细注册信息</title>
</head>
<body>
<CENTER>
<jsp:useBean id="readdetailedinfobean" type="beans.DetailedInfoBean" scope="session" />

<form method="POST" action="GetModify" >

<h1 align="center">更改详细注册信息</h1>

<p align="center">
用户名：<input type="text" name="User" size="20" VALUE='<jsp:getProperty name="readdetailedinfobean" property="username" />' readonly>

<p align="center">
年龄：
<input type="text" name="age" VALUE='<jsp:getProperty name="readdetailedinfobean" property="age" />'> 

<p align="center">
性别：
<%if(readdetailedinfobean.getSexy().equals("male")){%>
   <input type="radio" name="sexy" value="male" checked>男
   <input type="radio" name="sexy" value="female">女 
<%}else{%>
   <input type="radio" name="sexy" value="male">男
   <input type="radio" name="sexy" value="female" checked>女
<%}%>

<p align="center">
请上传照片：
<!-- file元素不允许有默认值 -->
<INPUT TYPE="file" NAME="uploadfile" VALUE='<jsp:getProperty name="readdetailedinfobean" property="pictureLocation" />'></p>

<p align="center">
 <input type="submit" value="更改">   
</p>  
 
</form>

</CENTER>
</body>
</html>