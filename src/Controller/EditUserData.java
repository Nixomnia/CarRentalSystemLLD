package src.Controller;
import java.sql.SQLException;
import java.util.*;
import src.Model.*;

public class EditUserData implements Operation{
    public void operation(Database database, Scanner s, User user){
        System.out.println("Enter First Name: (-1 to keep " + user.getFirstName()+")");
        String firstName = s.next();
        if(firstName.equals("-1")) firstName = user.getFirstName();

        System.out.println("Enter Last Name: (-1 to keep " + user.getLastName()+")");
        String lastName = s.next();
        if(lastName.equals("-1")) lastName = user.getLastName();

        System.out.println("Enter Email: (-1 to keep " + user.getEmail()+")");
        String email = s.next();
        if(email.equals("-1")) email= user.getEmail();

        System.out.println("Enter Phone Number: (-1 to keep " + user.getPhoneNumber()+")");
        String phoneNumber = s.next();
        if(phoneNumber.equals("-1")) phoneNumber = user.getLastName();

        String update = "UPDATE 'users' SET 'FirstName'='" + firstName + "','LastName'='"+
            lastName + "','Email'='"+ email +"','PhoneNumber'='"+phoneNumber + "' WHERE 'ID' = '"+user.getID()+"';";

            try{
            database.getStatement().executeQuery(update);
            System.out.println("Details updated successfully");
            }catch(SQLException e){
                e.printStackTrace();
            }


    }
}
