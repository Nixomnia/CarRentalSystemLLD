package src.Controller;
import java.util.*;
import src.Model.*;
import java.sql.*;

public class DeleteCar implements Operation{

    public void operation(Database database, Scanner s,User user){
        System.out.println("Enter car ID (int): (-1 to show all cars)");
        int ID = s.nextInt();
        while(ID==-1){
            new ViewCars().operation(database,s,user);
            System.out.println("Enter car ID (int): (-1 to show all cars)");
            ID = s.nextInt();
        }

        try{
            String update = "UPDATE 'cars' SET 'Available'='2' WHERE 'ID' = '" + ID +"';";
            database.getStatement().executeQuery(update);
            System.out.println("Deleted car successfully");
        }
        catch(SQLException e){
            e.printStackTrace();
        }

    }
}
