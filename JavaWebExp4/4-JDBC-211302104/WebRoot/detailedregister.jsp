<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登记详细注册信息</title>
</head>
<body>

<!-- 若表单中有INPUT type=file 元素，FORM 元素 METHOD 标签属性的值必须设置为 post， 
FORM 元素 ENCTYPE 标签属性的值必须设置为 multipart/form-data。  -->

<form method="POST" action="GetDetailedRegister" >

<h1 align="center"><span style="color:green">${success}</span></h1>

<p align="center">
用户名：<input type="text" name="User" size="20" value="<%=request.getParameter("username")%>" readonly>

<p align="center">
年龄：
<input type="text" name="age" >

<p align="center">
性别：
<input type="radio" name="sexy" value=male  CHECKED> 男 
<input type="radio" name="sexy" value=female> 女</p> 

<p align="center">
请上传照片：
<!-- file元素不允许有默认值 -->
<INPUT TYPE="file" NAME="uploadfile" ></p>

<p align="center">
 <input type="submit" value="提交">   
 <input type="reset" value="重置"></p>  
 
</form>
</body>
</html>