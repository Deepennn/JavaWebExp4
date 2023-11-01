package liuyan;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp.test.LiuyanBean;

/**
 * Servlet implementation class DoLiuyanInput
 */
@WebServlet("/DoLiuyanInput")
public class DoLiuyanInput extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置请求的编码格式，以兼容中文
		request.setCharacterEncoding("gb2312"); 
		response.setCharacterEncoding("gb2312"); 
		response.setContentType("text/html;charset=gb2312");
		
		//读取用户请求
		String u=request.getParameter("username");
		String l=request.getParameter("liuyan");
		//创建数据Bean实例，并设置Bean属性
		LiuyanBean liuyanbean=new LiuyanBean();
		liuyanbean.setUsername(u);
		liuyanbean.setLiuyan(l);	
		//存储Bean，目的是和其他文件共享该Bean
		request.setAttribute("resultinfo", liuyanbean);
		
		
		//流程判断，以确定不同的转发结果地址
		String forwardUrl=null;
		if (isParameterBlank(u) || isParameterBlank(l)){
			forwardUrl="/inputAgain.jsp";
		}
		else if (l.length()<5)
			forwardUrl="/inputError.jsp";
		else
			forwardUrl="/inputOk.jsp";
		
		//实现转发
		RequestDispatcher dispatcher =
			request.getRequestDispatcher(forwardUrl);
			dispatcher.forward(request, response);	
	}
	
	
	
	protected boolean isParameterNull(String p){
		if (p==null)
			return true;
		else return false;
	}
	
	protected boolean isParameterBlank(String p){
		if (p.trim()=="")
			return true;
		else return false;
	}

}
