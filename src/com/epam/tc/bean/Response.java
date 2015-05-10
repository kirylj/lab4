package com.epam.tc.bean;

public class Response {

	boolean success;
	
	public Response(boolean success)
    {
		this.success = success;
	}
	
	public boolean isSucceed()
    {
		return success;
	}
	
}
