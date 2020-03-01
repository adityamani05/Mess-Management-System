package com.owner.daoServiceProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.owner.bean.MessDetails;
import com.owner.bean.OwnerRegister;
import com.owner.bean.ThaliDetail;
import com.owner.daoService.DaoServices;

public class DaoServiceProvider implements DaoServices {
	ResultSet rs;
	Statement stmt;
	PreparedStatement ps;
	Connection con;
	
	@Override
	public void setConnection(Connection con) {
		this.con = con;
	}

	@Override
	public ResultSet extractMessDetail() {
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("Select * from messdetail");
		} catch (SQLException e) {e.printStackTrace();}
		return rs;
		
	}

	@Override
	public ResultSet extractOwnerRegister() {
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("Select * from ownerregister");
		} catch (SQLException e) {e.printStackTrace();}
		return rs;
	}

	@Override
	public int updateOwnerRegister(OwnerRegister registerOwner)  {
		int ownerId = 0 ;
		try {
			ps = con.prepareStatement("Insert into ownerregister(ownerName,ownerPassword,ownerPhoneNo) values(?,?,?)",Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, registerOwner.getOwnerName());
			ps.setString(2, registerOwner.getOwnerPassword());
			ps.setString(3, registerOwner.getOwnerPhoneNo());
			int flag = ps.executeUpdate();
			if(flag==1) {
				ResultSet rst = ps.getGeneratedKeys();
				if(rst.next()) {
					ownerId = rst.getInt(1);
				}
			}
			
		} catch (SQLException e) {e.printStackTrace();}
		
		return ownerId;
	}

	@Override
	public int updateMessDetail(MessDetails messDetail) {
		int messId = 0 ;
		try {
			ps = con.prepareStatement("Insert into messdetail(ownerId,messName,messPhoneNo,messLocation) values(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			ps.setInt(1, messDetail.getOwnerId());
			ps.setString(2, messDetail.getMessName());
			ps.setString(3, messDetail.getMessPhoneNo());
			ps.setString(4, messDetail.getMessLocation());
			int flag = ps.executeUpdate();
			if(flag==1) {
				ResultSet rst = ps.getGeneratedKeys();
				if(rst.next()) {
					messId = rst.getInt(1);
				}
			}
			
		} catch (SQLException e) {e.printStackTrace();}
		
		return messId;
	}

	@Override
	public ResultSet extractOwnerDetail(int ownerId) {
		try {
			ps = con.prepareStatement("Select * from ownerregister where ownerId=?");
			ps.setInt(1, ownerId);
			rs = ps.executeQuery();
		} catch (SQLException e) {e.printStackTrace();}
		
		return rs;
	}

	@Override
	public ResultSet extractDetailOfMess(int messId) {
		try {
			ps = con.prepareStatement("Select * from messdetail where messId=?");
			ps.setInt(1, messId);
			rs = ps.executeQuery();
		} catch (SQLException e) {e.printStackTrace();}
		
		return rs;
	}

	@Override
	public void insertThaliDetail(ThaliDetail thaliDetail) {
		int messId = thaliDetail.getMessId();
		String thaliName = thaliDetail.getThaliName();
		String thaliDes = thaliDetail.getThaliDes();
		int thaliPrice = thaliDetail.getThaliPrice();
		try {
			ps = con.prepareStatement("Insert into thalidetail(messId,thaliName,thaliDes,thaliPrice) values(?,?,?,?)");
			ps.setInt(1, messId);
			ps.setString(2, thaliName);
			ps.setString(3, thaliDes);
			ps.setInt(4, thaliPrice);
			ps.executeUpdate();
		} catch (SQLException e) {e.printStackTrace();}
	
		
	}

	@Override
	public ResultSet extractAllMess() {
		try {
			ps = con.prepareStatement("Select * from messdetail");
			rs = ps.executeQuery();
		} catch (SQLException e) {e.printStackTrace();}
		
		return rs;
	}

	@Override
	public ResultSet extractAllThali(int messId) {
		try {
			ps = con.prepareStatement("Select * from thalidetail where messId = ?");
			ps.setInt(1, messId);
			rs = ps.executeQuery();
		} catch (SQLException e) {e.printStackTrace();}
		
		return rs;
	}

	
}
