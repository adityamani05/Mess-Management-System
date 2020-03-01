package com.client.serviceObjectProvider;

import com.client.serviceProvider.ProvideClientService;

public class ServiceObjProvider 
{
	public static ProvideClientService getServiceObj()
	{
		return new ProvideClientService();
	}
}
