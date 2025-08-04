package src.Controller;
import src.Model.*;
import java.util.*;
import java.sql.*;

public class RentCar implements Operation{

    public void operation(Database database,Scanner s, User user){

        System.out.println("Enter Car If(int):(-1 to show all cars)");
        int carID = s.nextInt();

        while(carID ==-1){
            new ViewCars().operation(database, s, user);
            System.out.println("Enter Car If(int):(-1 to show all cars)");
            carID = s.nextInt();
        }
        
        System.out.println("Enter number of hours:");
        int hours = s.nextInt();

        try{
            ResultSet rs0 = database.getStatement().executeQuery("SELECT * FROM 'cars' WHERE 'ID' = '"+ carID+"';");
            rs0.next();

            Car car= new Car();
            car.setID(rs0.getInt("ID"));
            car.setBrand(rs0.getString("Brand"));
            car.setModel(rs0.getString("Model"));
            car.setColor(rs0.getString("Color"));
            car.setYear(rs0.getInt("Year"));
            car.setPrice(rs0.getDouble("Price"));
            car.setAvailable(rs0.getInt("Available"));
            if(car.isAvailable()!=0){
                System.out.println("Car not available");
                return;
            }

            ResultSet rs1 = database.getStatement().executeQuery("SELECT COUNT(*) FROM 'rents';");
            rs1.next();
            int Id = rs1.getInt("COUNT(*)");
            double total = car.getPrice() * hours;
            Rent rent = new Rent();
            String insert = "INSERT into 'rents' ('ID','UserID','CarID','DateTime','Hours','Total','Status') VALUES (('" + Id + "','"+ user.getID()+ "','" + car.getID() + "','" +
            rent.getDateTime() + "','" + hours + "','" + total+"','0');";
            database.getStatement().executeQuery(insert);
            

           

        }catch(SQLException e){
            e.printStackTrace();
        }


    }
    
}
