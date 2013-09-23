    package com.tsystems.javaschool.server.DAO;

import com.tsystems.javaschool.server.entity.Train;
import org.hibernate.HibernateException;

public class TrainDAO extends DAO{
    
    
    public void addTrain(Long capacity) throws Exception{
       
       try{
        begin();
        Train train = new Train();
        train.setCapacity(capacity);
        getSession().save(train);
        commit();
       } catch (HibernateException e){
           rollback();
           throw new Exception("Could not add train");
       }
       
    }
    
    
}