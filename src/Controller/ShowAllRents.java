package src.Controller;
import src.Model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
public class ShowAllRents implements Operation{
    
    public void operation(Database database, Scanner s,User user){
        ArrayList<Rent> rents = new ArrayList<>();
        ArrayList<Integer> carIDs = new ArrayList<>();
        ArrayList<Integer> userIDs = new ArrayList<>();

         try{
            ResultSet rs = database.getStatement().executeQuery("SELECT * FROM 'rents';");
            while(rs.next()){
                Rent rent = new Rent();
                rent.setID(rs.getInt("ID"));
                carIDs.add(rs.getInt("CarID"));
                userIDs.add(rs.getInt("UserID"));
                rent.setDateTime(rs.getString("DateTime"));
                rent.setHours(rs.getInt("Hours"));
                rent.setTotal(rs.getDouble("Total"));
                rent.setStatus(rs.getInt("Status"));
                rents.add(rent);
            }
    
            for(int i=0;i<rents.size();i++){
                Rent r = rents.get(i);
            
                ResultSet rs1 = database.getStatement().executeQuery("SELECT * FROM 'cars' WHERE 'ID' = '" + userIDs.get(i)+"';");
                rs1.next();
                User u = new Client();
                u.setID(rs1.getInt("ID"));
                u.setFirstName(rs1.getString("FirstName"));
                u.setLastName(rs1.getString("LastName"));
                u.setEmail(rs1.getString("Email"));
                u.setPhoneNumber(rs1.getString("PhoneNumber"));
                u.setPassword(rs1.getString("Password"));
                r.setUser(u);


                ResultSet rs3 = database.getStatement().executeQuery("SELECT * FROM 'cars' WHERE 'ID' = '" + carIDs.get(i)+"';");
                rs3.next();
                Car car = new Car();
                car.setID(rs3.getInt("ID"));
                car.setBrand(rs3.getString("Brand"));
                car.setModel(rs.getString("Model"));
                car.setColor("Color");
                car.setYear(rs3.getInt("Year"));
                car.setPrice(rs3.getDouble("Price"));
                car.setAvailable(rs3.getInt("Status"));
                r.setCar(car);
                
                System.out.println("ID:\t\t"+r.getID());
                System.out.println("Name:\t\t"+r.getUser().getFirstName()+" "+r.getUser().getLastName());
                System.out.println("Email:\t\t"+r.getUser().getEmail());
                System.out.println("Car ID:\t\t"+r.getCar().getID());
                System.out.println("Car:\t\t"+r.getCar().getBrand()+" "+r.getCar().getModel()+" "+r.getCar().getColor());
                System.out.println("Date Time:\t"+r.getDateTime());
                System.out.println("Hours:\t\t"+r.getHours());
                System.out.println("Total:\t\t"+r.getTotal());
                System.out.println("Status:\t\t"+r.getStatusToString());
                System.out.println("------------------------------\n");
            }
            

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
