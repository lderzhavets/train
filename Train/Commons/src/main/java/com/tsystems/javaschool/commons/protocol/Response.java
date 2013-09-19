package com.tsystems.javaschool.commons.protocol;

import java.io.Serializable;

public class Response implements Serializable{
	
	private String error;
	private Object obj;

	public Response(String error, Object obj){
		this.error = error;
		this.obj = obj;
	}

	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
}
