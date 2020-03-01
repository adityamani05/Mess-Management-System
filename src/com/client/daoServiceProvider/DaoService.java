package com.client.daoServiceProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.client.bean.Client;
import com.client.bean.ClientLogin;
import com.client.daoService.DaoInterface;

public class DaoService implements DaoInterface
{
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	
	@Override
	public void setConnection(Connection con)
	{
		this.con=con;
	}

	@Override
	public int addClient(Client c1) throws SQLException
	{
		int clientid=0;
			System.out.println("in addClient()");
			psmt = con.prepareStatement("Insert into client(username,useremail,userpassword,userphno,userarea,userlandmark,usercity) values(?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			psmt.setString(1,c1.getUserName());
			psmt.setString(2, c1.getUserEmail());
			psmt.setString(3, c1.getUserPassword());
			psmt.setString(4, c1.getUserPhNo());
			psmt.setString(5, c1.getUserArea());
			psmt.setString(6, c1.getUserLandmark());
			psmt.setString(7, c1.getUserCity());
			int i = psmt.executeUpdate();
			if(i==1)
			{
				rs = psmt.getGeneratedKeys(); 
				if(rs.next())
				{
				clientid = rs.getInt(1); 
				}				
			}
		return clientid;
	}

	@Override
	public boolean loginClient(ClientLogin cl1) throws SQLException
	{
		String pwd="";
			psmt = con.prepareStatement("select * from client where userid = ?");
			psmt.setString(1, cl1.getUserId());
			rs = psmt.executeQuery();
			while(rs.next())
			{
				pwd = rs.getString(4);
			}
			if(pwd.equals(cl1.getUserPassword())) 
			{
				return true;
			}
		return false;
	}

	@Override
	public Client getClientDetails(String userid) throws SQLException
	{
		Client c1=null;
		
			psmt = con.prepareStatement("Select * from client where userid = ?");
			psmt.setString(1, userid);
			rs = psmt.executeQuery();
			while(rs.next())
			{
				c1 = new Client(rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
			}
		return c1;
	}

	
}
	


