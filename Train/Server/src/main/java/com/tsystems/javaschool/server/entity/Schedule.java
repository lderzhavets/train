package com.tsystems.javaschool.server.entity;


import java.sql.Timestamp;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "schedule")
public class Schedule{
    
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "trainId")
    private Train train;
    
    @ManyToOne
    @JoinColumn(name = "stationId")
    private Station station;

     @Column(name = "timeArrive")
    private Timestamp timeArrive;
    
    @Column(name = "timeDeparture")
    private Timestamp  timeDeparture;
    
    
    public Schedule(){}

    public Schedule(Train train, Station station, Timestamp timeArrive,
            Timestamp timeDeparture){
        this.train = train;
        this.station = station;
        this.timeArrive = timeArrive;
        this.timeDeparture = timeDeparture;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    public Timestamp getTimeArrive() {
        return timeArrive;
    }

    public void setTimeArrive(Timestamp timeArrive) {
        this.timeArrive = timeArrive;
    }

    public Timestamp getTimeDeparture() {
        return timeDeparture;
    }

    public void setTimeDeparture(Timestamp timeDeparture) {
        this.timeDeparture = timeDeparture;
    }
    
   
    
    
    
   
}
