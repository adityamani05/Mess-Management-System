package com.owner.serviceProvider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.daoServiceObjectProvider.DaoServiceObjectProvider;
import com.owner.bean.OwnerLogin;
import com.owner.bean.OwnerRegister;
import com.owner.daoService.DaoServices;
import com.owner.service.AppServices;

public class AppServiceProvider implements AppServices {
	DaoServices ds;
	Connection con;
	ArrayList ownerDetailList;
	ArrayList detailOfMess;
	public AppServiceProvider(){
		this.ds = DaoServiceObjectProvider.getDaoServiceObjectProvider();
		ownerDetailList = new ArrayList();
		detailOfMess = new ArrayList();
	}
	
	
	@Override
	public void setConnection(Connection con) {
		this.con = con;
		//ds = DaoServiceObjectProvider.getDaoServiceObjectProvider();
		ds.setConnection(con);
	}

	@Override
	public ResultSet fetchOwnerMessDetail() {
		//ds = DaoServiceObjectProvider.getDaoServiceObjectProvider();
		ResultSet rs  =  ds.extractMessDetail();
		return rs;
	}

	@Override
	public boolean validateOwner(OwnerLogin loginOwner) throws SQLException {
		//ds = DaoServiceObjectProvider.getDaoServiceObjectProvider();
		ResultSet rs = ds.extractOwnerRegister();
		
				while(rs.next()){
				if(rs.getInt(1)==loginOwner.getOwnerId() && rs.getString(3).equals(loginOwner.getOwnerPassword())){
					return true;
				}
				}
			
		return false;
	}

	@Override
	public ArrayList fetchOwnerDetail(int ownerId) {
		//ds = DaoServiceObjectProvider.getDaoServiceObjectProvider();
		ResultSet rs = ds.extractOwnerDetail(ownerId);
		try {
			if(rs.next()){
				ownerDetailList.add(rs.getInt(1));
				ownerDetailList.add(rs.getString(2));
				ownerDetailList.add(rs.getString(3));
				ownerDetailList.add(rs.getString(4));
			}
		} catch (SQLException e) {e.printStackTrace();}
		return ownerDetailList;
	}
	
	
	public boolean validateOwnerReg(OwnerRegister registerOwner) throws SQLException {
		//ds = DaoServiceObjectProvider.getDaoServiceObjectProvider();
		ResultSet rs = ds.extractOwnerRegister();
		
				while(rs.next()){
					if(rs.getString(2).equalsIgnoreCase(registerOwner.getOwnerName()) && rs.getString(4).equals(registerOwner.getOwnerPhoneNo())){
						return true;
					}
				}
			
		return false;
	}


	@Override
	public ArrayList fetchDetailOfMess(int messId) {
		ResultSet rs = ds.extractDetailOfMess(messId);
		try {
			if(rs.next()){
				detailOfMess.add(rs.getInt(1));
				detailOfMess.add(rs.getInt(2));
				detailOfMess.add(rs.getString(3));
				detailOfMess.add(rs.getString(4));
				detailOfMess.add(rs.getString(5));
				detailOfMess.add(rs.getString(6));
			}
		} catch (SQLException e) {e.printStackTrace();}
		return detailOfMess;
	}


	@Override
	public ResultSet fetchAllMess() {
		ResultSet allMess = ds.extractAllMess();
		return allMess;
	}


	@Override
	public ResultSet extractAllThali(int messId) 
	{
		ResultSet rs = ds.extractAllThali(messId);
		return rs;
	}


}
