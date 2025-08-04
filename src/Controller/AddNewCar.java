package src.Controller;
import src.Model.*;
import java.util.*;
import java.sql.*;

public class AddNewCar implements Operation {
    
    public void operation(Database database,Scanner s,User user){
        System.out.print("Enter Brand: ");
        String brand = s.next();  // Brand is a string

        System.out.print("Enter Model: ");
        String model = s.next();  // Model is a string

        System.out.print("Enter Color: ");
        String color = s.next();  // Color is a string

        System.out.print("Enter Year of manufacturing (int): ");
        int year = s.nextInt();  // Assuming Year is an integer

        System.out.print("Enter Price per hour(double): ");
        double price = s.nextDouble();

        int available = 0;
        
        try{
            ResultSet rs = database.getStatement().executeQuery("SELECT COUNT(*) FROM 'cars';");
            rs.next();
            int ID = rs.getInt("COUNT(*)");

            String insert = "INSERT INTO 'cars' ('ID','Brand','Model','Color','Year','Price','Available') VALUES ('" +
            ID + "','"  + brand + "','"  + model + "','"  + color + "','"  + year + "','"  + price + "','"  +available + "');";

            database.getStatement().execute(insert);
            System.out.println("Car added successfully.");
        }catch(SQLException e){
            e.printStackTrace();
        }
        

    }
}
