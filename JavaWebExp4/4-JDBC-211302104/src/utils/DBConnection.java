package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBConnection {

	   public static Connection getConnection() throws Exception{
	    	Connection conn=null;
//	    	
//	    	//����Sqlserver���ݿ���������sqljdbc4.jar����ʡ�Ա��䣬sqljdbc.jar������
//	    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  
//	   
//	    	//��������
//	    	String dburl="jdbc:sqlserver://localhost:1433;databaseName=txdatabase";
//	    	String sqlUser="sa";
//	    	String sqlPwd="123";    	
//	    	conn=DriverManager.getConnection(dburl,sqlUser,sqlPwd);
	 /*
	    	//����ʹ�������dburl��������
	    	String dburl="jdbc:sqlserver://localhost:1433;databaseName=txdatabase;user=sa;password=123";
	    	conn=DriverManager.getConnection(dburl);
	 */   	
	    	/*
	    	 * ����ΪSQL Server���ݿ�����ӷ�ʽ
	    	 */
	    	
	    	Class.forName("com.mysql.jdbc.Driver");
	    	String url="jdbc:mysql://localhost:3306/loginuser";
	    	conn=DriverManager.getConnection(url,"root","root");
	    	
	    	return conn;
	    }
		
	    //�ͷ���Դ
	    public static void dbClose(Connection conn,PreparedStatement ps,ResultSet rs)
	    throws SQLException
	    {
	          rs.close();
	          ps.close();
	          conn.close();
	      }

	
}
