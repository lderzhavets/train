package com.tsystems.javaschool.server.entity;

import java.sql.Date;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "station")
public class Station{
    
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
    private Long id;

    @Column(name = "name")
    private String name;
    
    public Station(){}

    public Station(String name){
        this.name = name;
    }
   
    public void setId(Long id) {
        this.id = id;
    }
   
    public Long getId() {
       return id;
    } 
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
  
}