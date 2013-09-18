import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class DBConnection {
	
	private static Connection conn;
	
	public static Statement connect() throws SQLException, ClassNotFoundException{
		
		Class.forName("com.mysql.jdbc.Driver");
			
	
			
		 conn = (Connection) DriverManager.getConnection(
				            "jdbc:mysql://localhost:3306/train_test",
				            "root", "1234");
	
	  	if (conn == null) {
        System.out.println("Нет соединения с БД!");
        System.exit(0);
        }else {System.out.println("Hoooooray!");}
	    
	  	return  (Statement) conn.createStatement();
		
	}
	 
	public static void disconnect() throws SQLException{
		conn.close();
	}
}
