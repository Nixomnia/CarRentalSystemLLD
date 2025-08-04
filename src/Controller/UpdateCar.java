package src.Controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import src.Model.*;

public class UpdateCar implements Operation {
    
    public void operation(Database database, Scanner s,User user){
        System.out.println("Enter car ID (int): (-1 to show all cars)");
        int ID = s.nextInt();
        while(ID==-1){
            new ViewCars().operation(database,s,user);
            System.out.println("Enter car ID (int): (-1 to show all cars)");
            ID = s.nextInt();
        }

        try{
            ResultSet rs = database.getStatement().executeQuery("SELECT * FROM 'cars' WHERE 'ID' ='"+ID+"';");
            rs.next();
            Car car= new Car();
            car.setID(rs.getInt("ID"));
            car.setBrand(rs.getString("Brand"));
            car.setModel(rs.getString("Model"));
            car.setColor(rs.getString("Color"));
            car.setYear(rs.getInt("Year"));
            car.setPrice(rs.getDouble("Price"));
            car.setAvailable(rs.getInt("Available"));
            if(car.isAvailable()>1){
                System.out.println("Car doesn't exist");
            }
            // System.out.println("Enter Brand:(-1:"+car.getBrand()+")");
            // String brand = s.next();
            // if(brand=="-1") brand = car.getBrand();

            // System.out.println("Enter Model:(-1:"+car.getBrand()+")");
            // String model = s.next();
            // if(model=="-1") model = car.getModel();

            System.out.println("Enter New Price per hour:(-1:"+car.getBrand()+")");
            Double price = s.nextDouble();
            if(price==-1) price = car.getPrice();

            String update = "Update 'cars' SET 'Price' = "+price+"WHERE 'ID' = "+ID+";";
            database.getStatement().executeQuery(update);

            System.out.println("Car details updated successfully");
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
