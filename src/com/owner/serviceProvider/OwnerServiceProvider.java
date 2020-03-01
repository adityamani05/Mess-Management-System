package com.owner.serviceProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.daoServiceObjectProvider.DaoServiceObjectProvider;
import com.owner.bean.MessDetails;
import com.owner.bean.OwnerRegister;
import com.owner.bean.ThaliDetail;
import com.owner.daoService.DaoServices;
import com.owner.service.OwnerServices;

public class OwnerServiceProvider implements OwnerServices{
	DaoServices ds;
	Connection con;
	
	public OwnerServiceProvider(){
		ds = DaoServiceObjectProvider.getDaoServiceObjectProvider();
	}
	
	@Override
	public void setConnection(Connection con) {
		this.con = con;
		ds.setConnection(con);
	}
	
	
	@Override
	public int ownerRegister(OwnerRegister registerOwner) {
		int ownerId = 0;
		ownerId = ds.updateOwnerRegister(registerOwner);
		return ownerId;
	}

	@Override
	public int addMessDetail(MessDetails messDetail) {
		int messId = ds.updateMessDetail(messDetail);
		return messId;
	}

	@Override
	public void addThali(ThaliDetail thaliDetail) {
		ds.insertThaliDetail(thaliDetail);
		
	}

	

	
	
}