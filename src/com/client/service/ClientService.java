package com.client.service;

import java.sql.Connection;

import com.client.bean.Client;
import com.client.bean.ClientLogin;

public interface ClientService 
{
	public void setConnection(Connection con);
	public int addClient(Client c1);
	public boolean loginClient(ClientLogin cl1);
}
