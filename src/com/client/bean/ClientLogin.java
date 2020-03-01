package com.client.bean;

public class ClientLogin 
{
	private String userId;
	private String userPassword;
	//private String userEmail;
	
	public ClientLogin(String userId, String userPassword) 
	{
		this.setUserId(userId);
		this.setUserPassword(userPassword);
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "ClientLogin [userId=" + userId + ", userPassword=" + userPassword + "]";
	}
	
	
}
