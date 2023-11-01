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
<title>留言内容或用户名为空</title>
</head>
<body>
<CENTER>
<H1><font color="Red">留言内容或用户名为空</font></H1>
<jsp:useBean id="resultinfo" type="jsp.test.LiuyanBean" scope="request" />
<FORM ACTION="DoLiuyanInput"  method="post"  >
用户名:<INPUT TYPE="TEXT" NAME="username" VALUE='<jsp:getProperty name="resultinfo" property="username" />'><BR><BR>
<span style="vertical-align:top">留言：</span><textarea name="liuyan" rows=5  cols=50><jsp:getProperty name="resultinfo" property="liuyan" /></textarea>
<P><INPUT TYPE="SUBMIT"> <!-- Press this to submit form -->
</FORM>
</CENTER>
</body>
</html>