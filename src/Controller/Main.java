package src.Controller;
import java.sql.*;
import java.util.*;
import src.Model.*;

public class Main{
    public static void main(String[] args){
        Database database = new Database();
        Scanner s = new Scanner(System.in);
        
        System.out.println("Welcome to XYZ Rental System!");

        System.out.println("Enter you email:\n(-1) to create new Account");
        String email = s.next();
        if(email=="-1"){
            new AddNewAccount(0).operation(database,s,null);

        }
        System.out.println("Enter password:");
        String password = s.next();

        ArrayList<User> users = new ArrayList<>();
        
        try{
            String select = "SELECT * FROM 'users';";
            ResultSet rs = database.getStatement().executeQuery(select);
            while(rs.next()){
                User user;
                int ID = rs.getInt("ID");
                String firstName = rs.getString("First Name");
                String lastName = rs.getString("LastName");
                String em = rs.getString("Email");
                String ph = rs.getString("PhoneNumber");
                String pass = rs.getString("Password");
                int type = rs.getInt("Type");
                
                if(type==0){
                    user = new Client();
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setEmail(em);
                    user.setID(ID);
                    user.setPhoneNumber(ph);
                    user.setPassword(pass);
                }
                else if(type==1){
                    user = new Admin();
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setEmail(em);
                    user.setID(ID);
                    user.setPhoneNumber(ph);
                    user.setPassword(pass);
                }
                else{
                    System.out.println("Account doesn't exist!");
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        boolean loggedIn = false;
        for(User u : users ){
            if(u.getEmail().equals(email) && u.getPassword().equals(password)){
                System.out.println("Welcome "+ u.getFirstName() + " "+ u.getLastName()+"!");
                loggedIn = true;
                u.showList(database,s);
            }
            if(!loggedIn){
                System.out.println("Email or password doesn't match");
                s.close();
            }
        }

    }
}