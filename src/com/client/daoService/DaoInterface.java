package com.client.daoService;

import java.sql.Connection;
import java.sql.SQLException;

import com.client.bean.Client;
import com.client.bean.ClientLogin;

public interface DaoInterface
{
	public int addClient(Client c1) throws SQLException;
	public boolean loginClient(ClientLogin cl1 )throws SQLException;
	public Client getClientDetails(String userid) throws SQLException;
	public void setConnection(Connection con);
}
