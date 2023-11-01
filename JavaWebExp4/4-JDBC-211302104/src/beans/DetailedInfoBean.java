package beans;

import java.io.Serializable;
import java.sql.*;

public class DetailedInfoBean implements Serializable{
	//声明表单元素对应的bean属性
	private String username;
	private int    age;
	private String sexy;
	private String pictureLocation;
	
	//表单元素的setter函数	
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
	
//表单元素的getter函数	
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
