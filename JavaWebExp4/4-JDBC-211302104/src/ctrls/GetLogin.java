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
 		
 		if(login.equals("��½")) {//��½�߼�
 			DetailedInfoBean dbean=null;
 	 		
 	 		//����û��û�����������ȷ
 	 		//���detailinfo���ж�����ϸ��Ϣ�������û���ϸ��Ϣ��bean
 	 		if (LoginInfoDao.isExistedUsernameAndPassword(username,pwd)){
 	 			if(username!=null&&username.equals(Constants.ADMIN_USERNAME)) {//����Ա�û��߼�
	 	 			forwardUrl="GetAdmin";
 	 			}else {//��ͨ�û��߼�
 	 				dbean=DetailedInfoDao.getDetailedInfoBean(username); 
 	 	 			if(dbean==null){//˵���û�ֻ��ע�����û��������룬û��ע����ϸ��Ϣ,��Ҫ���û�������ϸע����Ϣ
 	 	 				request.setAttribute("success","��½�ɹ�����Ǽ���ϸע����Ϣ");
 	 	 				forwardUrl="detailedregister.jsp";
 	 	 			}
 	 	 			else{//����bean��������ͼ��չ��
 	 					session.setAttribute("readdetailedinfobean", dbean);
 	 					request.setAttribute("success","��½�ɹ�");
 	 	 	 			forwardUrl="showdetailedinfo.jsp";
 	 	 			}
 	 			}
 	 		}
 	 		else{//���û����µ�¼
 	 			request.setAttribute("error","�û�����������������µ�½");
 	 			forwardUrl="loginagain.jsp";
 	 		} 			
 		}else if(login.equals("ע��")) {//ע���߼�
 			if (username==null||pwd==null||username.equals("")||pwd.equals("")||LoginInfoDao.isExistedUsername(username)){//���û�����ע��
 				request.setAttribute("error","�û����Ѵ��ڡ��û���Ϊ�ջ�����Ϊ�գ�������ע��");
 				forwardUrl="loginagain.jsp";
 			}else {
 				LoginInfoDao.insertBeantoDB(username, pwd);
 				request.setAttribute("success","ע��ɹ�����Ǽ���ϸע����Ϣ");
 				forwardUrl="detailedregister.jsp";
 			}
 		}else {//����
 			forwardUrl="login.jsp";
 		}
 		//ת������Ӧҳ��
 		RequestDispatcher dispatcher =
	 				request.getRequestDispatcher(forwardUrl);
	 				dispatcher.forward(request, response);
	}
 	
}
