package com.owner.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.owner.bean.OwnerLogin;
import com.owner.bean.OwnerRegister;

public interface AppServices {
	public ResultSet fetchOwnerMessDetail();
	public ArrayList fetchOwnerDetail(int ownerId);
	public boolean validateOwner(OwnerLogin loginOwner) throws SQLException;
	public boolean validateOwnerReg(OwnerRegister registerOwner) throws SQLException;
	public void setConnection(Connection con);
	public ArrayList fetchDetailOfMess(int messId);
	public ResultSet fetchAllMess();
	public ResultSet extractAllThali(int messId);

}
