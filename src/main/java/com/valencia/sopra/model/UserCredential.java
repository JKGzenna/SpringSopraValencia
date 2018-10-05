package com.valencia.sopra.model;

public class UserCredential {
	
	private String username;
	private String password;
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserCredential(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public UserCredential() {
		
	}
	@Override
	public String toString() {
		return "UserCredential [username=" + username + ", password=" + password + "]";
	}
	
	


}
