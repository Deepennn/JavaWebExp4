package ctrls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.*;
import utils.*;
import daos.*;

/**
 * Servlet implementation class GetAdmin
 */
@WebServlet("/GetAdmin")
public class GetAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
 		request.setCharacterEncoding("UTF-8");
 		response.setCharacterEncoding("UTF-8");
 		response.setContentType("text/html;charset=UTF-8");
 		PrintWriter out = response.getWriter();
 		
 		String pageHead=
 				"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n" + 
 				"<html>\r\n" + 
 				"<head>\r\n" + 
 				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n" + 
 				"<title>管理用户</title>\r\n" + 
 				"</head>\r\n" + 
 				"<body>\r\n" + 
 				"<p align=\"right\">\r\n" + 
 				"<a href=\"login.jsp\">[退出]</a>\r\n" + 
 				"<center>\r\n" +
 				"<h1>用户列表：</h1>\r\n" +
 				"<form action=\"GetAdmin\" method=\"post\">\r\n" +
 		        "<table border=1 align=center>\r\n" +
 		        "<th>用户<th>选择\r\n";
 				
 		String pageEnd=
  				"</table>\r\n" +
  				"<br>\r\n" +
  		 		"<input type=\"submit\" value=\"删除\">\r\n" +
  			    "</form>\r\n" +
 				"</center>\r\n" + 
 				"</body>\r\n" +
 				"</html>";
 		
 		//删除选定用户
 		String[] paramValues = request.getParameterValues("selectedUsers");
 		if(paramValues!=null) {
 			for(int i=0; i<paramValues.length; i++) {
 			  //先删除参考表表项
 			  DetailedInfoDao.deleteByUsername(paramValues[i]);
 			  //再删除被参考表表项
			  LoginInfoDao.deleteByUsername(paramValues[i]);
			}
 		}

		out.print(pageHead);
 		
 		ArrayList<String> allUsername = LoginInfoDao.selectAllUsername();
 		out.println();
			for(String username:allUsername){
			out.println("<tr><td>" + username + "<td><input type=\"checkbox\" name=\"selectedUsers\" value="+username+">");
		}
 		
 		out.print(pageEnd);
 		
	}
 	
}
