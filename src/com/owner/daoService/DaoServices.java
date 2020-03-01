package com.owner.daoService;

import java.sql.Connection;
import java.sql.ResultSet;

import com.owner.bean.MessDetails;
import com.owner.bean.OwnerRegister;
import com.owner.bean.ThaliDetail;

public interface DaoServices {
	public ResultSet extractMessDetail();
	public ResultSet extractOwnerRegister();
	public int updateOwnerRegister(OwnerRegister registerOwner);
	public int updateMessDetail(MessDetails messDetail);
	public ResultSet extractOwnerDetail(int ownerId);
	public void setConnection(Connection con);
	public ResultSet extractDetailOfMess(int messId);
	public void insertThaliDetail(ThaliDetail thaliDetail);
	public ResultSet extractAllMess();
	public ResultSet extractAllThali(int messId);
}
