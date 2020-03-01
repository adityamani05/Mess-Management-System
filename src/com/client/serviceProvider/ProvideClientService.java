package com.client.serviceProvider;

import java.sql.Connection;
import java.sql.SQLException;

import com.client.bean.Client;
import com.client.bean.ClientLogin;
import com.client.daoServiceProvider.DaoService;
import com.client.service.ClientService;
import com.daoServiceObjectProviderClient.DaoObjectProvider;

public class ProvideClientService implements ClientService
{
	DaoService d1;
	ClientLogin cl1;
	Connection con;
	public ProvideClientService() 
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
	public int addClient(Client c1)
	{
		int clientid = 0; 
		try {
			clientid = d1.addClient(c1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Your Client id is : "+clientid);
		return clientid;
	}

	@Override
	public boolean loginClient(ClientLogin cl1) 
	{	
		boolean value = false;
		try {
			value = d1.loginClient(cl1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	
}
