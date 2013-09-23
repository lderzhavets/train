package com.tsystems.javaschool.server.entity;

import java.sql.Date;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "passenger")
public class Passenger{
    
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
    private Long id;
    
    @Column(name = "firstName")
    private String firstName;
  
    @Column(name = "lastName")
    private String lastName;  

    
    public Passenger(){}
    
    public Passenger(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
 
    @Column(name = "dateOfBirth")
    private Date dateOfBirth;  
 
    
    
    
    
}