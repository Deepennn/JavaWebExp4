package beans;

import java.io.Serializable;
import java.sql.*;

public class DetailedInfoBean implements Serializable{
	//������Ԫ�ض�Ӧ��bean����
	private String username;
	private int    age;
	private String sexy;
	private String pictureLocation;
	
	//��Ԫ�ص�setter����	
	public void setUsername(String u){
		username=u;
	}
	
	public void setAge(int a){
		age=a;
	}
	
	public void setSexy(String s){
		sexy=s;
	}
	
	public void setPictureLocation(String pl){
		pictureLocation=pl;
	}
	
//��Ԫ�ص�getter����	
	public String getUsername(){
		return(username);
	}
	
	public int getAge(){
		return(age);
	}
	
	public String getSexy(){
		return(sexy);
	}
	
	public String getPictureLocation(){
		return(pictureLocation);
	}

}
