import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

//import com.tsystems.javaschool.model.entity.*;


public class TrainServer {

	public static void main(String[] args)  {
	
		Statement st = null;
		
		
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
		
	}
}
