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
<title>��������С��5</title>
</head>
<body>
<CENTER>
<H1><font color="orange">��������С��5</font></H1>
<jsp:useBean id="resultinfo" type="jsp.test.LiuyanBean" scope="request" />
<FORM ACTION="DoLiuyanInput"  method="post"  >
�û���:<INPUT TYPE="TEXT" NAME="username" VALUE='<jsp:getProperty name="resultinfo" property="username" />'><BR><BR>
<span style="vertical-align:top">���ԣ�</span><textarea name="liuyan" rows=5  cols=50><jsp:getProperty name="resultinfo" property="liuyan" /></textarea>
<P><INPUT TYPE="SUBMIT"> <!-- Press this to submit form -->
</FORM>
</CENTER>
</body>
</html>