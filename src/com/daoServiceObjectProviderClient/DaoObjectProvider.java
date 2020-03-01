package com.daoServiceObjectProviderClient;

import com.client.daoServiceProvider.DaoService;

public class DaoObjectProvider 
{
	public static DaoService getDaoObj()
	{
		return new DaoService();
	}
}
