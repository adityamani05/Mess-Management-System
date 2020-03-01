package com.owner.bean;

public class MessDetails {
	
	//Instnace Variables
	private int ownerId;
	private String messName;
	private String messPhoneNo;
	private String messLocation;
	private String messCity;
	
	//Parameterized Constructor
	
	public MessDetails(int ownerId,String messName, String messPhoneNo,
			String messLocation) {
		this.ownerId = ownerId;
		this.messName = messName;
		this.messPhoneNo = messPhoneNo;
		this.messLocation = messLocation;
	}
	
	//Getter-setter Methods

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getMessName() {
		return messName;
	}

	public void setMessName(String messName) {
		this.messName = messName;
	}

	public String getMessPhoneNo() {
		return messPhoneNo;
	}

	public void setMessPhoneNo(String messPhoneNo) {
		this.messPhoneNo = messPhoneNo;
	}

	public String getMessLocation() {
		return messLocation;
	}

	public void setMessLocation(String messLocation) {
		this.messLocation = messLocation;
	}

	public String getMessCity() {
		return messCity;
	}

	public void setMessCity(String messCity) {
		this.messCity = messCity;
	}
	
	
	

}
