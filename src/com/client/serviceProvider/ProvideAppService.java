package com.client.serviceProvider;

import java.sql.Connection;
import java.sql.SQLException;

import com.client.bean.Client;
import com.client.daoServiceProvider.DaoService;
import com.client.service.AppService;
import com.daoServiceObjectProviderClient.DaoObjectProvider;

public class ProvideAppService implements AppService
{
	Connection con;
	DaoService d1;
	Client c1;
	
	public ProvideAppService()
	{
		d1 = DaoObjectProvider.getDaoObj();
	}

	@Override
	public void setConnection(Connection con) 
	{
		this.con=con;
		d1.setConnection(con);
	}
	
	@Override
	public Client getClientdetails(String userid) 
	{
		
		try {
			c1 = d1.getClientDetails(userid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c1;
	}

	
	
}
