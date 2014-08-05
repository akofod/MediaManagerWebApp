package edu.franklin.model;

import java.io.Serializable;
import java.sql.ResultSet;

public class UserDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String userName;
	private String password;
	private int authLevel;
	
	public UserDetail(){}
	
	public UserDetail(int id, String username, String password, int authLevel){
		this.setId(id);
		this.setUserName(username);
		this.setPassword(password);
		this.setAuthLevel(authLevel);
	}
	
	public UserDetail(ResultSet rs) throws Exception{
		this(rs.getInt("ID"),rs.getString("USERNAME"),rs.getString("PASSWORD"),rs.getInt("AUTHLEVEL"));
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAuthLevel() {
		return authLevel;
	}
	public void setAuthLevel(int authLevel) {
		this.authLevel = authLevel;
	}

}
