package ctrls;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.*;
import utils.*;
import daos.*;

/**
 * Servlet implementation class GetLogin
 */
@WebServlet("/GetLogin")
public class GetLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
 		request.setCharacterEncoding("UTF-8");
 		response.setCharacterEncoding("UTF-8");
 		HttpSession session=request.getSession();
 		
 		String username=request.getParameter("username");
 		String pwd=request.getParameter("pwd");
 		String login=request.getParameter("login");
 		
 		String forwardUrl=null;
 		
 		if(login.equals("登陆")) {//登陆逻辑
 			DetailedInfoBean dbean=null;
 	 		
 	 		//如果用户用户名和密码正确
 	 		//则从detailinfo表中读出详细信息，产生用户详细信息的bean
 	 		if (LoginInfoDao.isExistedUsernameAndPassword(username,pwd)){
 	 			if(username!=null&&username.equals(Constants.ADMIN_USERNAME)) {//管理员用户逻辑
	 	 			forwardUrl="GetAdmin";
 	 			}else {//普通用户逻辑
 	 				dbean=DetailedInfoDao.getDetailedInfoBean(username); 
 	 	 			if(dbean==null){//说明用户只是注册了用户名和密码，没有注册详细信息,需要请用户输入详细注册信息
 	 	 				request.setAttribute("success","登陆成功，请登记详细注册信息");
 	 	 				forwardUrl="detailedregister.jsp";
 	 	 			}
 	 	 			else{//设置bean共享，供视图层展现
 	 					session.setAttribute("readdetailedinfobean", dbean);
 	 					request.setAttribute("success","登陆成功");
 	 	 	 			forwardUrl="showdetailedinfo.jsp";
 	 	 			}
 	 			}
 	 		}
 	 		else{//请用户重新登录
 	 			request.setAttribute("error","用户名或密码错误，请重新登陆");
 	 			forwardUrl="loginagain.jsp";
 	 		} 			
 		}else if(login.equals("注册")) {//注册逻辑
 			if (username==null||pwd==null||username.equals("")||pwd.equals("")||LoginInfoDao.isExistedUsername(username)){//请用户重新注册
 				request.setAttribute("error","用户名已存在、用户名为空或密码为空，请重新注册");
 				forwardUrl="loginagain.jsp";
 			}else {
 				LoginInfoDao.insertBeantoDB(username, pwd);
 				request.setAttribute("success","注册成功，请登记详细注册信息");
 				forwardUrl="detailedregister.jsp";
 			}
 		}else {//返回
 			forwardUrl="login.jsp";
 		}
 		//转发到对应页面
 		RequestDispatcher dispatcher =
	 				request.getRequestDispatcher(forwardUrl);
	 				dispatcher.forward(request, response);
	}
 	
}
