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
<title></title>
</head>
<body>
<CENTER>
<H1><font color="Black">����ϵͳ</font></H1>
<FORM ACTION="DoLiuyanInput"  method="post"  >
�û���:<INPUT TYPE="TEXT" NAME="username"/><BR><BR>
<span style="vertical-align:top">���ԣ�</span><textarea name="liuyan" rows=5  cols=50></textarea>
<P><INPUT TYPE="SUBMIT"> <!-- Press this to submit form -->
</FORM>
</CENTER>
</body>
</html>