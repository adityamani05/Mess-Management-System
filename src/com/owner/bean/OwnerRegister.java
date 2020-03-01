package com.owner.bean;

public class OwnerRegister {
	
	//Instance Variables
	private String ownerName;
	private String ownerPassword;
	private String ownerPhoneNo;
	
	
	//Parameterized Constructor
	public OwnerRegister(String ownerName, String ownerPassword,
			String ownerPhoneNo) {
		this.ownerName = ownerName;
		this.ownerPassword = ownerPassword;
		this.ownerPhoneNo = ownerPhoneNo;
	}

	
	// Getter-Setter Methods

	public String getOwnerName() {
		return ownerName;
	}


	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}


	public String getOwnerPassword() {
		return ownerPassword;
	}


	public void setOwnerPassword(String ownerPassword) {
		this.ownerPassword = ownerPassword;
	}


	public String getOwnerPhoneNo() {
		return ownerPhoneNo;
	}


	public void setOwnerPhoneNo(String ownerPhoneNo) {
		this.ownerPhoneNo = ownerPhoneNo;
	}
	
	

}
