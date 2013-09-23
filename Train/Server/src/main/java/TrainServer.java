import com.tsystems.javaschool.commons.obj.ScheduleStation;
import com.tsystems.javaschool.commons.protocol.*;
import com.tsystems.javaschool.server.entity.*;
import com.tsystems.javaschool.server.util.HibernateUtil;
import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.*;
import org.hibernate.*;


public class TrainServer {

       private static Socket wait4Connection(int port) throws IOException{
           
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Server console: ");	
            System.out.println("Waiting for client");
            Socket s = ss.accept(); //тут поток останавливается
            System.out.println("Connection is established");	
            return s;
       }
    
        private static Request getRequest(Socket s) throws IOException, ClassNotFoundException {

            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            Request req = (Request)ois.readObject();
            ois.close();
            return req;
        }
        
        private static void sendResponse(Socket s, String error,Object result)
                throws IOException, IOException {
        
           ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
           oos.writeObject(new Response(error, result));
           oos.close();
        
    }
       
       
       
       public static   ArrayList<ScheduleStation> getStationSchedule(String stationName){
           
            SessionFactory sessionFactory =
            HibernateUtil.configureSessionFactory();
            Session session = sessionFactory.getCurrentSession();     
            Transaction tx = session.beginTransaction(); 
  
            Query q = session.createQuery("from Schedule schedule "
                    + "where schedule.station.name like ? ");
            q.setString(0, stationName);            
            List<Schedule> l = q.list();
             
            ArrayList<ScheduleStation> listOfSchedule = new ArrayList<ScheduleStation>();
           
            for(int i=0; i<l.size(); i++){
                Schedule schedule = l.get(i);  
                ScheduleStation scheduleStation  = new ScheduleStation();
                scheduleStation.setStation(schedule.getStation().getName()); 
                scheduleStation.setTrain(schedule.getTrain().getId());
                scheduleStation.setTimeArrive(schedule.getTimeArrive());
                scheduleStation.setTimeDeparture(schedule.getTimeDeparture());
                listOfSchedule.add(scheduleStation);
            }     
            
            tx.commit();
            session.close();
            return listOfSchedule;
       }

   public static void getTrainByStationAndTime(){
      
       SessionFactory sessionFactory =
       HibernateUtil.configureSessionFactory();
       Session session = sessionFactory.getCurrentSession();     
       Transaction tx = session.beginTransaction(); 
       
       Query q = session.createQuery("from Schedule schedule "
               + "schedule.station.name like ? "
               + "and  schedule.station.name like ? ");
        
        q.setString(0, "Тверь");   
        q.setString(0, "Киев");
        
        List<Schedule> l = q.list();
        
        for (int i=0; i<l.size();i++){
            System.out.println(l.get(i).getTrain().getId());
        }
        
        
   }

   
   public static void buyTicket(Session session){
       
       Transaction tx = session.beginTransaction(); 
       
       Query q = session.createQuery("select t from Ticket t join t.passenger "
                + " join t.schedule.train join t.schedule.station where t.id = 1");
       
      // Ticket ticket = (Ticket)q.uniqueResult();        
       
       // System.out.println(ticket.getPassenger());
        //q.setString(0, "Лев");
        //Ticket t =  q.uniqueResult();
      // List l = q.list();
        
        
      // for(int i=0; i<l.size(); i++){
      //     System.out.println(   ((Ticket)l.get(i)).getPassenger().getFirstName() );
      // }
       
   }
   
   
   
   

    public TrainServer() {
    }
       
	public static void main(String[] args)  {
	
		Statement st = null;
		int port = 6666;
		Socket s;
		String command;
		ArrayList<Train> listOfTrains = new ArrayList<Train>();
                ArrayList<ScheduleStation> listOfScheduleStation = null;
                Object result = null;
                String error = null;
     
              
              
            SessionFactory sessionFactory =
            HibernateUtil.configureSessionFactory();     
            Session session = sessionFactory.getCurrentSession();       
            buyTicket(session);    
             
                /*   try {
            //ждем полключения
            s = wait4Connection(port);
            
            //инициализируем потоки
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

            //получаем запрос
            Request req = (Request)ois.readObject();
            
            //обрабатываем запрос
            
            * command = req.getCommand();
            if (command.equals("getScheduleStation")){
                listOfScheduleStation = new ArrayList<ScheduleStation>();
                listOfScheduleStation = getStationSchedule(req.getObj().toString());
                result = listOfScheduleStation;
                error = null;
            }
       
            
            //отправляем ответ
           oos.writeObject(new Response(null, listOfScheduleStation));
          
          
           ois.close();
           oos.close();
         
           s.close();
        
           //  ss.close();
            
            // Transaction tx = session.beginTransaction(); 
                // Transaction tx = session.beginTransaction();
        } catch (IOException ex){
            System.out.println(ex);
            //Logger.getLogger(TrainServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            //Logger.getLogger(TrainServer.class.getName()).log(Level.SEVERE, null, ex);
        }
      */      
        
            
             
             
        // SessionFactory sessionFactory =
       // HibernateUtil.configureSessionFactory();
       // Session session = sessionFactory.getCurrentSession();     
       // Transaction tx = session.beginTransaction(); 
        
       // Passenger p = new Passenger("Иса","Кириллов");
       // Ticket t = new Ticket();
       // session.persist(p);
       // tx.commit();
        
        //Назначить билет пассажиру Лев Державец на 666 поезд
        //Query q = session.createQuery(" from Passenger where"
         //       + " firstName like ?  and lastName like ?");
        //q.setString(0,"Лев");
        //q.setString(1,"Державец");
        //List results = q.list();
        
       // Passenger p = (Passenger)results.get(0);
        
       // Ticket t = new Ticket();
        //t.setPassenger(p);
        //t.setTrainId(666L);
        //System.out.print(((Passenger)l.get(0)).getId());
        // Session session = sessionFactory.getCurrentSession();     
     
        //Transaction tx = session.beginTransaction();     
        //t.setTrainId(666L);
        
        
        //Station station = new Station("Биберево");
        
       // session.persist(station);
        
        
        
     //   Station station = new Station("Залупово2");
     //   Train train = new Train(666l);
     //   Schedule schedule = new Schedule(train,station,null,null);
     //   session.persist(station);
     //   session.persist(train);
     //   session.persist(schedule);
     //   tx.commit();
        
      //      TrainDAO train = new TrainDAO();
    //try {
        
         //ждем подключения
        //s = wait4Connection(port);
        //получаем запрос
        //ois = new ObjectInputStream(s.getInputStream());
        //req = (Request)ois.readObject();
        //command = req.getCommand();
       //обрабатываем запрос
        //...
        // отвечаем
        
        //train.addTrain(321L);
        
     //Session session = HibernateUtil.getSessionFactory().openSession();
    //
    // Session session = sessionFactory.getCurrentSession();     
 
     //Transaction tx = session.beginTransaction();     
//        Train tr = new Train();
//     tr.setCapacity(123);
//     System.out.println(tr.getCapacity());
   // На данном этапе слушаем клиентский запрос на подключение
   
   //session.persist(tr);
     // На данном этапе слушаем клиентский запрос на подключение

       
        // На данном этапе слушаем клиентский запрос на подключение

         /*  
        
        Train tr = (Train)req.getObj();
        System.out.println(tr.getCapacity());
        
        
        /*
        if(command.equals("add trains")){
                System.out.println(command);
                
                listOfTrains = (ArrayList<Train>) req.getObj();
                
                for (int i = 0; i<listOfTrains.size(); i++){
                        Train t = listOfTrains.get(i);
                        System.out.println(""+t.getId() + "  " + t.getAmountOfPlaces() 
                                        + " " + t.getRouteId());			
                
                }
                listOfTrains.clear();
        }
        
        
        if(command.equals("get trains")){
                listOfTrains.add(new Train(3,10,16));
                listOfTrains.add(new Train(5,12,18));
                res = new Response(null, listOfTrains);
                oos = new ObjectOutputStream(s.getOutputStream());
                oos.writeObject(new Response("null" ,listOfTrains));
        }
        
        
        s.close();
        ois.close();
        
        ss.close();
        
        } catch (IOException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        } 
        
        
        // ....
        /*
        // Подключаемся к базе
        try{ 
          st = DBConnection.connect();	
        } catch (ClassNotFoundException e) {
                System.out.println(e);
        } catch (SQLException e) {
                System.out.println(e);
        }

        
        // Выполнение клиентского запроса
        /*
        DBWorker d = new DBWorker(st);
        ArrayList<TrainSchedule>  trains = null;
        try {
                trains = d.findTrains(1, 3, new Time(9,0,0), new Time(15,0,0));
                d.getScheduleOfStation(1);
        } catch (SQLException e) {
                e.printStackTrace();
        }
        for (int i = 0 ; i< trains.size(); i++){
                System.out.println(trains.get(i).getId());
        }
        
        
        
        // Отключаемся от базы при отключении клиента:
        try {
                DBConnection.disconnect();
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        */
    //} catch (Exception ex) {
   //     Logger.getLogger(TrainServer.class.getName()).log(Level.SEVERE, null, ex);
   // } } catch (IOException ex) {
        
	}
}
