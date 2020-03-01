package com.owner.serviceObjectProvider;

import com.owner.serviceProvider.OwnerServiceProvider;


public class OwnerServiceObjectProvider {
	public static OwnerServiceProvider getOwnerServiceObject(){
		return new OwnerServiceProvider();
	}

}
