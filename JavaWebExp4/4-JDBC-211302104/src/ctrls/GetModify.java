package ctrls;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.*;
import daos.*;
import utils.*;

/**
 * Servlet implementation class GetModify
 */
@WebServlet("/GetModify")
public class GetModify extends HttpServlet {
	private static final long serialVersionUID = 1L;    



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session=request.getSession();
		
		String username=request.getParameter("User");
 		int age=Integer.parseInt(request.getParameter("age"));
 		String sexy=request.getParameter("sexy");
 		String location="E:\\\\";
 		request.setAttribute("location",location);
 		
 		DetailedInfoDao.modifyBeantoDB(username, age, sexy, location);
 		
 		//设置（新）bean
 		DetailedInfoBean dbean=DetailedInfoDao.getDetailedInfoBean(username); 
		session.setAttribute("readdetailedinfobean", dbean);
 		
		request.setAttribute("success","已完成更改详细注册信息");
		String forwardUrl="showdetailedinfo.jsp";
 		RequestDispatcher dispatcher =
 				request.getRequestDispatcher(forwardUrl);
 				dispatcher.forward(request, response);	
	}

}