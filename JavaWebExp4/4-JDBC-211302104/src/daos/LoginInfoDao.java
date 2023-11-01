package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import utils.*;

public class LoginInfoDao {
	
	//��user���в��Ҹ���username��pwd�Ƿ����
	public static boolean isExistedUsernameAndPassword(String username,String pwd){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
		  conn=DBConnection.getConnection();
		  String sql = "select * from user where username=? and password=?";
	      ps = conn.prepareStatement(sql);
	      ps.setString(1,username);
	      ps.setString(2,pwd);
	      rs = ps.executeQuery();		
	      if(rs.next()) {
			  return true;
		      }	         
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				DBConnection.dbClose(conn,ps,rs); //�ͷ����ݿ�������Դ
			}catch(Exception e){
				e.printStackTrace();
			}
		}		
		return false;		
	}
		
	//��user���в��Ҹ���username�Ƿ����
	public static boolean isExistedUsername(String username){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
		  conn=DBConnection.getConnection();
		  String sql = "select * from user where username=?";
	      ps = conn.prepareStatement(sql);
	      ps.setString(1,username);
	      rs = ps.executeQuery();		
	      if(rs.next()) {
			  return true;
		      }	         
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				DBConnection.dbClose(conn,ps,rs); //�ͷ����ݿ�������Դ
			}catch(Exception e){
				e.printStackTrace();
			}
		}		
		return false;		
	}
		
	//��user������Ӹ���username��pwd
	public static boolean insertBeantoDB(String username,String pwd){
		Connection conn=null;

		Statement st=null;				
		try{
		  conn=DBConnection.getConnection();
		  st=conn.createStatement();
		  //��bean����ƴ�ӳ�Insert���
		  String sql1 = "insert into user(username,password) values("+
		  				"\'"+username+"\'"+","+
		  				"\'"+pwd+"\'"+")";
		st.executeUpdate(sql1);
		return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				conn.close();
				st.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return false;
	}

	//��user���в��Ҹ���username�Ƿ����
	public static ArrayList<String> selectAllUsername(){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		ArrayList<String> allUserName = new ArrayList<String>();

		try{
		  conn=DBConnection.getConnection();
		  String sql = "select username from user";
	      ps = conn.prepareStatement(sql);
	      rs = ps.executeQuery();
	      
	      while(rs.next()) {
	    	  allUserName.add(rs.getString("username"));
		  }
	      
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				DBConnection.dbClose(conn,ps,rs); //�ͷ����ݿ�������Դ
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return allUserName;		
	}
	
	//��user����ɾ������username
	public static boolean deleteByUsername(String username){
		Connection conn=null;

		Statement st=null;				
		try{
		  conn=DBConnection.getConnection();
		  st=conn.createStatement();
		  //��bean����ƴ�ӳ�Insert���
		  String sql1 = "delete from user where username="+
		  				"\'"+username+"\'";
		st.executeUpdate(sql1);
		return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				conn.close();
				st.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return false;
	}
}
