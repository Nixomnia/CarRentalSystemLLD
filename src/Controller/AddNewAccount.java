package src.Controller;
import java.sql.*;
import java.util.*;
import src.Model.*;

public class AddNewAccount implements Operation{

    private int accType;
    public AddNewAccount(int accType){
        this.accType = accType;
    }

    public void operation(Database database,Scanner s,User user){
       
        System.out.println("Enter First Name:");
        String firstName = s.next();
        System.out.println("enter Last Name:");
        String lastName = s.next();
        System.out.println("Enter Email:");
        String email = s.next();
        System.out.println("Enter Phone Number:");
        String phoneNumber = s.next();
        System.out.println("Enter Password:");
        String password = s.next();
        System.out.println("Confirm Password");
        String confirmPassword = s.next();
        while(!password.equals(confirmPassword)){
            System.out.println("Passwords don't match");
            System.out.println("Enter Password");
            password = s.next();
            System.out.println("Confirm Password");
            confirmPassword = s.next();
        }

        try{
            ArrayList<String> emails = new ArrayList<>();
            ResultSet rse = database.getStatement().executeQuery("SELECT 'Email' from `users`;");
            while(rse.next()){
                emails.add(rse.getString("Email"));
            }

            if(emails.contains(email)){
                System.out.println("Email already in use");
                return;
            }
            ResultSet rs = database.getStatement().executeQuery("Select COUNT(*) from `users`;");
            rs.next();
            int ID = rs.getInt("COUNT(*)");
            String insert = "INSERT INTO 'users' ('ID','FirstName','LastName','Email', 'PhoneNumber','Password','Type') Values" + " ('" 
            + ID+"','"+firstName+"','"+lastName+"','"+email+"','"+"','"+phoneNumber + "','"+password+"','"+accType+"');";

            database.getStatement().execute(insert);
            System.out.println("Account created successfully\n");

            if(accType==0){
                    user = new Client();
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setEmail(email);
                    user.setID(ID);
                    user.setPhoneNumber(phoneNumber);
                    user.setPassword(password);
                    user.showList(database, s);
                }
                else if(accType==1){
                    user = new Admin();
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setEmail(email);
                    user.setID(ID);
                    user.setPhoneNumber(phoneNumber);
                    user.setPassword(password);
                    user.showList(database, s);
                }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
