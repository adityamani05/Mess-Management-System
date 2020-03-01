package com.client.service;

import java.sql.Connection;

import com.client.bean.Client;

public interface AppService 
{
	public Client getClientdetails(String userid);
	public void setConnection(Connection con);
}
