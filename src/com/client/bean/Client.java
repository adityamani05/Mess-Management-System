package com.client.bean;

public class Client 
{
	private String userName;
	private String userEmail;
	private String userPassword;
	private String userPhNo;
	private String userArea;
	private String userLandmark;
	private String userCity;
	
	
	@Override
	public String toString() 
	{
		return "Client [userName=" + userName + ", userEmail=" + userEmail + ", userPassword=" + userPassword
				+ ", userPhNo=" + userPhNo + ", userArea=" + userArea + ", userLandmark=" + userLandmark + ", userCity="
				+ userCity + "]";
	}
	
	
	public Client(String userName,String userEmail, String userPassword, String userPhNo, String userArea,String userLandmark, String userCity)
	{
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userPhNo = userPhNo;
		this.userArea = userArea;
		this.userLandmark = userLandmark;;
		this.userCity = userCity;
	}

	
	public String getUserName() 
	{
		return userName;
	}
	
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	
	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() 
	{
		return userPassword;
	}
	public void setUserPassword(String userPassword) 
	{
		this.userPassword = userPassword;
	}
	public String getUserPhNo() 
	{
		return userPhNo;
	}
	public void setUserPhNo(String userPhNo) 
	{
		this.userPhNo = userPhNo;
	}
	public String getUserArea() 
	{
		return userArea;
	}
	public void setUserArea(String userArea) 
	{
		this.userArea = userArea;
	}
	public String getUserLandmark() {
		return userLandmark;
	}


	public void setUserLandmark(String userLandmark) {
		this.userLandmark = userLandmark;
	}


	public String getUserCity() 
	{
		return userCity;
	}
	public void setUserCity(String userCity) 
	{
		this.userCity = userCity;
	}

}
