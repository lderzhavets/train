package com.tsystems.javaschool.commons.protocol;

import java.io.Serializable;

public class Request implements Serializable{
	
	private String command;
	private Object obj;
	
	public Request(String command, Object obj){
		this.command = command;
		this.obj = obj;
	}
	
	public Request(String command){
		this.command = command;
	}
	
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	
}
