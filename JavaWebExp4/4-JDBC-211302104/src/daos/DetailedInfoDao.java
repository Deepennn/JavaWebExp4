package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import beans.DetailedInfoBean;
import utils.*;

public class DetailedInfoDao {
	
	//到detailedinfo表中查找是否存在给定username的客户
    //如果存在，就创建一个有关详细信息DetailedInfoBean的实例；否则返回Null
	public static DetailedInfoBean getDetailedInfoBean(String un){
		DetailedInfoBean bb=null;
		
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=DBConnection.getConnection();
			//如果logintable表中存在给定username的记录
			//则获取对应记录的每个字段的值，写入bean
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
				DBConnection.dbClose(conn,ps,rs); //释放数据库连接资源
			}catch(Exception e){
				e.printStackTrace();
			}
		}		
		return bb;		
	}
	
	//把bean属性的值添加到detailedinfo表中
	//成功返回true,失败返回false
	public static boolean insertBeantoDB(String username,int age, String sexy, String picturelocation){
		Connection conn=null;

		Statement st=null;				
		try{
		  conn=DBConnection.getConnection();
		  st=conn.createStatement();
		  //由bean属性拼接出Insert语句
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
		
		//或者使用PreparedStatement把参数传入Insert语句
		/*
		PreparedStatement ps=null;
		try{
			conn=DBConnection.getConnection();		  
			String sql2 = "insert into detailedinfo(username,age,sexy,picturelocation) values(?,?,?,?)";
			ps = conn.prepareStatement(sql2);
			ps.setString(1,username);
			ps.setInt(2,age);//整型数据使用setInt
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
	
	//把bean属性的值更新到detailedinfo表中
	//成功返回true,失败返回false
	public static boolean modifyBeantoDB(String username,int age, String sexy, String pictureLocation){
		Connection conn=null;

		Statement st=null;				
		try{
		  conn=DBConnection.getConnection();
		  st=conn.createStatement();
		  //由bean属性拼接出Insert语句
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
		
		//或者使用PreparedStatement把参数传入Update语句
		/*
		PreparedStatement ps=null;
		try{
			conn=DBConnection.getConnection();		  
			String sql2 ="update detailedinfo set age=?,sexy=?,pictureLocation=? where username=?";
			ps = conn.prepareStatement(sql2);
			ps.setInt(1,age);//整型数据使用setInt
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
	
	//到detailedinfo表中删除给定username
	public static boolean deleteByUsername(String username){
		Connection conn=null;

		Statement st=null;				
		try{
		  conn=DBConnection.getConnection();
		  st=conn.createStatement();
		  //由bean属性拼接出Insert语句
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
