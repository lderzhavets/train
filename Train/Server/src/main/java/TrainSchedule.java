import java.sql.Time;
import java.text.*;
import java.util.Calendar;


public class TrainSchedule {

	private int id;
	private Time timeDeparture;
	private Time timeArrive;
	
	public  TrainSchedule(int id, Time timeDeparture, Time timeArrive ){
		this.id = id;
		this.timeArrive = timeArrive;
		this.timeDeparture = timeDeparture;		
	}

	public int getId(){
		return id;
	}
}
