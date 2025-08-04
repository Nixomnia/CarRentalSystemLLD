package src.Controller;
import java.util.*;
import src.Model.*;
import java.sql.*;

public class ViewCars  implements Operation{
    public void operation(Database database, Scanner s, User user){
        System.out.println();
        String select = "SELECT * FROM 'cars';" ;
        ArrayList<Car> cars = new ArrayList<>();
        try{
            ResultSet rs = database.getStatement().executeQuery(select);
            while(rs.next()){
                Car car = new Car();
                car.setID(rs.getInt("ID"));
                car.setBrand(rs.getString("Brand"));
                car.setModel(rs.getString("Model"));
                car.setColor(rs.getString("Color"));
                car.setYear(rs.getInt("Year"));
                car.setPrice(rs.getDouble("Price"));
                car.setAvailable(rs.getInt("Available"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        for(Car c : cars){
            if(c.isAvailable()<2){
                System.out.println("ID:\t" + c.getID());
                System.out.println("Brand:\t" + c.getBrand());
                System.out.println("Model:\t" + c.getModel());
                System.out.println("Price:\t" + c.getPrice());
                System.out.println("Color:\t" + c.getColor());
                System.out.println("Status:\t" + (c.isAvailable()==0 ? "Available" : "Not Available"));
                System.out.println("------------------------\n");
            }

        }
    }
}
