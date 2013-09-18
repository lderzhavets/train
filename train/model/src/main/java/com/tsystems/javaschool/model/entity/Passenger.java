package com.tsystems.javaschool.model.entity;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Passenger extends Record {

	
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	
	public Passenger(Statement st){
		super(st);
	}
	
	public void fillFields(ResultSet rs) throws SQLException{
		
		firstName = rs.getString("firstName");
		lastName = rs.getString("lastName");
		dateOfBirth = rs.getDate("dateOfBirth");
	}
			
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
}
