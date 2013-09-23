import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import com.tsystems.javaschool.commons.protocol.Request;
import com.tsystems.javaschool.commons.protocol.Response;


public class TrainClient {

    public static void main(String[] args) {

        Socket s;
        ObjectOutputStream oos;
        ObjectInputStream ois;
       // ArrayList<Train> listOfTrains = new ArrayList<Train>();
        //Train t = null;
        Request req;
        Response res;
        String command;
        
       
       
        /*try {
			
         s = new Socket("127.0.0.1" , 6666);
         oos = new ObjectOutputStream(s.getOutputStream());
			
         command = "get trains";
			
         t = new Train();
         t.setCapacity(124L);
                        
         req = new Request("sd",t);
         oos.writeObject(req);
         /*if (command.equals("add trains")){
         listOfTrains.add(new Train(1,50,1));
         listOfTrains.add(new Train(2,90,3));
         req = new Request(command,listOfTrains);		
			
         oos.writeObject(req);
         listOfTrains.clear();
         }
			
			
         System.out.println("Client console:  ");
			
         if (command.equals("get trains")){
         req = new Request(command,null);	
         oos.writeObject(req);
         ois = new ObjectInputStream(s.getInputStream());
         res = (Response)ois.readObject();
         if (!res.getError().equals(null)){
         listOfTrains = (ArrayList<Train>)res.getObj();
         for (int i = 0; i<listOfTrains.size(); i++){
         t = listOfTrains.get(i);
         System.out.println(""+t.getRouteId() + " " + t.getAmountOfPlaces()
         + "  " + t.getRouteId());
         }
         }
						
         }
                     
         s.close();
         oos.close();
			
         } catch (UnknownHostException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
         } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
         } //catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         //	e.printStackTrace();
         //}
	
         */

    }
}
