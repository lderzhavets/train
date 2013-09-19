package com.tsystems.javaschool.commons.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Record {

	private int id;
	protected Statement st;
	
	public Record(Statement st){
		this.st = st;
	}
	
	public final void get(int id)  throws SQLException{
		this.id = id;
		String tableName = this.getClass().getSimpleName();
		String sql = "select * from " + tableName + " where id = " + id; //Убрать звездочку!!!!
		//String sql = "select * from  passenger where id = " + id;
		ResultSet rs = st.executeQuery(sql);
		rs.next();
		fillFields(rs);		
	}
	
	public int getId(){
		return id;
	}
	
	protected abstract void fillFields(ResultSet rs) throws SQLException;
	
	
	
}
