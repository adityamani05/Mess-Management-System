package com.owner.bean;

public class OwnerLogin {
	
	//instance variables
	private int ownerId;
	private String ownerPassword;
	
	//parameterized constructor
	public OwnerLogin(int ownerId, String ownerPassword) {
		this.ownerId = ownerId;
		this.ownerPassword = ownerPassword;
	}
	
	//getter-setter methods
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public String getOwnerPassword() {
		return ownerPassword;
	}
	public void setOwnerPassword(String ownerPassword) {
		this.ownerPassword = ownerPassword;
	}
	

}
