package com.owner.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.owner.bean.MessDetails;
import com.owner.bean.OwnerRegister;
import com.owner.bean.ThaliDetail;


public interface OwnerServices {

	//public boolean validateOwnerReg(OwnerRegister registerOwner) throws SQLException;
	public int ownerRegister(OwnerRegister registerOwner);
	public int addMessDetail(MessDetails messDetal);
	public void setConnection(Connection con);
	public void addThali(ThaliDetail thaliDetail);
}
