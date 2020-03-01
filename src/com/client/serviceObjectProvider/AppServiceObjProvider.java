package com.client.serviceObjectProvider;


import com.client.serviceProvider.ProvideAppService;

public class AppServiceObjProvider
{
	public static ProvideAppService getServiceobj() 
	{
		return new ProvideAppService();
	}
}
