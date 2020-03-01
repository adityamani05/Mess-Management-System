package com.owner.daoServiceObjectProvider;

import com.owner.daoServiceProvider.DaoServiceProvider;

public class DaoServiceObjectProvider {
	public static DaoServiceProvider getDaoServiceObjectProvider(){
		return new DaoServiceProvider();
	}
}
