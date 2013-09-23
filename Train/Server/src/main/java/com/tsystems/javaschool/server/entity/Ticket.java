package com.tsystems.javaschool.server.entity;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ticket")
public class Ticket{
    
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "passengerId")
    private Passenger passenger;

    @ManyToOne
    @JoinColumn(name = "scheduleId")
    private Schedule schedule;  

    public Ticket(){}
    
    public Ticket(Passenger passenger, Schedule schedule){
        this.passenger = passenger;
        this.schedule = schedule;
    }
    
    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
 
 
    public Long getId() {
        return id;
    }

    public Passenger getPassenger() {
        return passenger;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

}