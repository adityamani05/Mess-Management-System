package com.client.exception;

public class RegistrationFailExceptions extends Exception 
{
	String message;

	public RegistrationFailExceptions(String message) 
	{
		this.message = message;
	}

	@Override
	public String toString() 
	{
		return "RegistrationFailExceptions [message=" + message + "]";
	}
	
	
	

}
