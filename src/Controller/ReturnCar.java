package src.Controller;
import src.Model.*;
import java.util.*;
import java.sql.*;

public class ReturnCar implements Operation{

    public void operation(Database database,Scanner s, User user){

        System.out.println("Enter Rent ID(int):(-1 to show all rents)");
        int ID = s.nextInt();

        while(ID ==-1){
            new ViewCars().operation(database, s, user);
            System.out.println("Enter Car If(int):(-1 to show all cars)");
            ID = s.nextInt();
        }
        
        

        try{
            ResultSet rs = database.getStatement().executeQuery("SELECT * FROM 'cars' WHERE 'ID' = '"+ ID+"';");
            rs.next();

            Rent r = new Rent();
            r.setID(rs.getInt("ID"));
            r.setUser(user);
            int carID = rs.getInt("CarID");
            
            r.setDateTime(rs.getString("DateTime"));
            r.setHours(rs.getInt("Hours"));
            r.setTotal(rs.getDouble("Total"));
            r.setStatus(rs.getInt("Status"));
            
            if(r.getStatusToString().equals("Delayed")){
                System.out.println("Delayed by " + r.getDelayedHours()+" hours");
                System.out.println("Your will have to pay 1000 as fine");
            }

            String update = "UPDATE 'rents' SET 'Status'= 1 WHERE 'ID' = " + ID+";";
            database.getStatement().executeQuery(update);
           System.out.println("Car return successfully.");
           

        }catch(SQLException e){
            e.printStackTrace();
        }


    }
    
}
