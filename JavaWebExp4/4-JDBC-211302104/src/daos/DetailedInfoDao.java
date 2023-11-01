package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.DetailedInfoBean;
import utils.*;

public class DetailedInfoDao {
	
	//��detailedinfo���в����Ƿ���ڸ���username�Ŀͻ�
    //������ڣ��ʹ���һ���й���ϸ��ϢDetailedInfoBean��ʵ�������򷵻�Null
	public static DetailedInfoBean getDetailedInfoBean(String un){
		DetailedInfoBean bb=null;
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=DBConnection.getConnection();
			//���logintable���д��ڸ���username�ļ�¼
			//���ȡ��Ӧ��¼��ÿ���ֶε�ֵ��д��bean
			  String sql = "select * from detailedinfo where username=?";
		      ps = conn.prepareStatement(sql);
		      ps.setString(1,un);
		      rs = ps.executeQuery();        
		      if(rs.next()) {
		    	  bb=new DetailedInfoBean();
		    	  bb.setUsername(rs.getString("username"));
		    	  bb.setAge(rs.getInt("age"));
		    	  bb.setSexy(rs.getString("sexy"));
		    	  bb.setPictureLocation(rs.getString("picturelocation"));
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
		return bb;		
	}
	
	//��bean���Ե�ֵ��ӵ�detailedinfo����
	//�ɹ�����true,ʧ�ܷ���false
	public static boolean insertBeantoDB(String username,int age, String sexy, String picturelocation){
		Connection conn=null;

		Statement st=null;				
		try{
		  conn=DBConnection.getConnection();
		  st=conn.createStatement();
		  //��bean����ƴ�ӳ�Insert���
		  String sql1 = "insert into detailedinfo(username,age,sexy,picturelocation) values("+
		  				"\'"+username+"\'"+","+
		  				age+","+
		  				"\'"+sexy+"\'"+","+
		  				"\'"+picturelocation+"\'"+")";
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
		
		//����ʹ��PreparedStatement�Ѳ�������Insert���
		/*
		PreparedStatement ps=null;
		try{
			conn=DBConnection.getConnection();		  
			String sql2 = "insert into detailedinfo(username,age,sexy,picturelocation) values(?,?,?,?)";
			ps = conn.prepareStatement(sql2);
			ps.setString(1,username);
			ps.setInt(2,age);//��������ʹ��setInt
			ps.setString(3,sexy);
			ps.setString(4,pictureLocation);
	        int rb=ps.executeUpdate();
	        return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				conn.close();
				ps.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		*/
		
		return false;
	}
	
	//��bean���Ե�ֵ���µ�detailedinfo����
	//�ɹ�����true,ʧ�ܷ���false
	public static boolean modifyBeantoDB(String username,int age, String sexy, String pictureLocation){
		Connection conn=null;

		Statement st=null;				
		try{
		  conn=DBConnection.getConnection();
		  st=conn.createStatement();
		  //��bean����ƴ�ӳ�Insert���
		  String sql1 = "update detailedinfo set age="+age+
		            		  ",sexy="+"\'"+sexy+"\'"+
		  				      ",pictureLocation="+"\'"+pictureLocation+"\'"+
		  				      "where username="+"\'"+username+"\'";
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
		
		//����ʹ��PreparedStatement�Ѳ�������Update���
		/*
		PreparedStatement ps=null;
		try{
			conn=DBConnection.getConnection();		  
			String sql2 ="update detailedinfo set age=?,sexy=?,pictureLocation=? where username=?";
			ps = conn.prepareStatement(sql2);
			ps.setInt(1,age);//��������ʹ��setInt
			ps.setString(2,sexy);
			ps.setString(3,pictureLocation);
			ps.setString(4,username);
	        int rb=ps.executeUpdate();
	        return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				conn.close();
				ps.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		*/
		
		return false;
	}
	
	//��detailedinfo����ɾ������username
	public static boolean deleteByUsername(String username){
		Connection conn=null;

		Statement st=null;				
		try{
		  conn=DBConnection.getConnection();
		  st=conn.createStatement();
		  //��bean����ƴ�ӳ�Insert���
		  String sql1 = "delete from detailedinfo where username="+
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
