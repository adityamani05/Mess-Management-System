package com.owner.serviceObjectProvider;

import com.owner.serviceProvider.AppServiceProvider;

public class AppServiceObjectProvider {
	public static AppServiceProvider getAppServiceObject(){
		return new AppServiceProvider();
	}

}
