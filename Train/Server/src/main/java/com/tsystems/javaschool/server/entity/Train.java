package com.tsystems.javaschool.server.entity;

//import org.hibernate.*;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "train")
public class Train{
 
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
    private Long id;

    @Column(name = "capacity")
    private Long capacity;
    
    public Train(){}
    
    public Train(Long capacity){
        this.capacity = capacity;           
    }
    
    
    public void setId(Long id) {
        this.id = id;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }
  
    public Long getId() {
        return id;
    }
    
    public Long getCapacity() {
        return capacity;
    }
    
}
