<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ page contentType="text/html; charset=gb2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
request.setCharacterEncoding("gb2312"); 
response.setCharacterEncoding("gb2312"); 
response.setContentType("text/html;charset=gb2312");
%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>������Ϣ������ȷ</title>
</head>
<body>
	<CENTER>
		<h1><font color="Green">������Ϣ������ȷ</font></h1>
		<jsp:useBean id="resultinfo" type="jsp.test.LiuyanBean"  scope="request" /> <!-- ��δ�����µ�bean -->
		<p>	�����û����ǣ�<jsp:getProperty name="resultinfo" property="username" /> 
		<p> ���������ǣ�<jsp:getProperty name="resultinfo" property="liuyan" />
	</CENTER>
</body>
</html>