package jsp.test;

import java.io.Serializable;

public class LiuyanBean implements Serializable {
	private String username;
	private String liuyan;
	
	public void setUsername(String n){
		username=n;
	}
	
	public void setLiuyan(String s){
		liuyan=s;
	}
	
	public String getUsername(){
		return username;
	}
	
	public String getLiuyan(){
		return liuyan;
	}

}