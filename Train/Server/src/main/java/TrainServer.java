import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.ArrayList;

import com.tsystems.javaschool.commons.protocol.*;
import com.tsystems.javaschool.commons.obj.*;

//import com.tsystems.javaschool.model.entity.*;


public class TrainServer {

	public static void main(String[] args)  {
	
		Statement st = null;
		int port = 6666;
		ObjectInputStream ois;
		ObjectOutputStream oos = null;
		Socket s;
		String command;
		ArrayList<Train> listOfTrains = new ArrayList<Train>();
		Request req;
		Response res;
		
		try {
			ServerSocket ss = new ServerSocket(port);
		
		System.out.println("Server console: ");	
		System.out.println("Waiting for client");
		s = ss.accept(); //тут поток останавливается
		System.out.println("Connection is established");	
		
		ois = new ObjectInputStream(s.getInputStream());
		req = (Request)ois.readObject();
		command = req.getCommand();
		
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
		
		
		/*
		// На данном этапе слушаем клиентский запрос на подключение
		// ....
		
		// Подключаемся к базе
		try{ 
		  st = DBConnection.connect();	
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	
		
		// Выполнение клиентского запроса
		
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
	}
}
