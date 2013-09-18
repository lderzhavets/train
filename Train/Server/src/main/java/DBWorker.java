import java.sql.*;
import java.util.ArrayList;


public class DBWorker{

	private Statement st;
	
	public DBWorker(Statement st){
		this.st= st;
	}
	
	public ArrayList<TrainSchedule> findTrains(int firstStation, int secondStation, 
			Time timeFrom, Time timeTo) throws SQLException{
		
	String sql	= "select T.id, "
			+ "(select time from stationschedule where trainid=t.id and stationid=r1.stationid) as time1, "
			+ "(select time from stationschedule where trainid=t.id and stationid=r2.stationid) as time2  "
			+ "from train T "
			+ "join route R1 on T.routeId = R1.id " 
			+ "join route R2 on T.routeId = R2.id "
			+ "where R1.stationId = " + firstStation
			+ " and R2.stationId = " + secondStation
			+ " having time1<time2 "
 			+ " and time1> '" + timeFrom + "'"
			+ " and time1< '" + timeTo + "'";
	
	
	ResultSet rs = st.executeQuery(sql); 
	
	ArrayList<TrainSchedule>  ar= new ArrayList<TrainSchedule>();

	while(rs.next()){
		ar.add(new TrainSchedule(rs.getInt("id"), rs.getTime("time1"),rs.getTime("time2")));
	}
	
	return ar;
	}
	
	public ArrayList<Time> getScheduleOfStation(int stationId) throws SQLException{
		
		
		String sql = "select stationschedule.time, stationschedule.trainId"
					 	+ " from stationschedule"
						+ " where stationschedule.stationId  = " + stationId
						+	" ORDER BY time ASC";
		
		
		ResultSet rs = st.executeQuery(sql); 
		
		ArrayList<Time>  ar= new ArrayList<Time>();

		rs.next();
		System.out.println(rs.getTime("time").toString());
		
		//while(rs.next()){
		//	ar.add(rs.getInt("id"));
		//}
									
						
		return null;
	}
	
}
