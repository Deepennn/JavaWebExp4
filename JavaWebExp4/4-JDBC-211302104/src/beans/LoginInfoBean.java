package beans;

import java.io.Serializable;
import java.sql.*;

import utils.DBConnection;

public class LoginInfoBean implements Serializable{
	private String username;
	private String pwd;
//setter����	
	public void setUsername(String s){
		username=s;
	}	
	public void setPwd(String p){
		pwd=p;
	}
	
//getter����
	public String getUsername(){
		return(username);
	}	
	public String getPwd(){
		return(pwd);
	}
	
}
