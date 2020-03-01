package com.owner.bean;

public class ThaliDetail {
	private int messId;
	private String thaliName;
	private String thaliDes;
	private int thaliPrice;
	public ThaliDetail(int messId,String thaliName, String thaliDes, int thaliPrice) {
		this.messId = messId;
		this.thaliName = thaliName;
		this.thaliDes = thaliDes;
		this.thaliPrice = thaliPrice;
	}
	public String getThaliName() {
		return thaliName;
	}
	public void setThaliName(String thaliName) {
		this.thaliName = thaliName;
	}
	public String getThaliDes() {
		return thaliDes;
	}
	public void setThaliDes(String thaliDes) {
		this.thaliDes = thaliDes;
	}
	public int getThaliPrice() {
		return thaliPrice;
	}
	public void setThaliPrice(int thaliPrice) {
		this.thaliPrice = thaliPrice;
	}
	public int getMessId() {
		return messId;
	}
	public void setMessId(int messId) {
		this.messId = messId;
	}

}
