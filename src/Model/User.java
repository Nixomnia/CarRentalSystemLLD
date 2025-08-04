package src.Model;
import java.util.*;

public abstract class User {
    private int ID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;

    public User(){}
    public int getID() {
        return ID;
      }
      
      public String getFirstName() {
        return firstName;
      }
      
      public String getLastName() {
        return lastName;
      }
      
      public String getEmail() {
        return email;
      }
      
      public String getPhoneNumber() {
        return phoneNumber;
      }
      
      public String getPassword() {
        // Consider returning a hashed version of the password for security reasons
        return password;
      }

      public void setID(int ID) {
        this.ID = ID;
      }
      
      public void setFirstName(String firstName) {
        this.firstName = firstName;
      }
      
      public void setLastName(String lastName) {
        this.lastName = lastName;
      }
      
      public boolean setEmail(String email) {

        // if(valid(email)) { this.email = email; return true;}
        // return false;
        this.email = email;
        return true;
      }
      
      public boolean setPhoneNumber(String phoneNumber) {
        // You can add validation here to ensure a valid phone number format (optional)
        // if(valid(phoneNumber)) {this.phoneNumber = phoneNumber; return true;}
        // return false;
        this.phoneNumber = phoneNumber;
        return true;
      }
      
      public void setPassword(String password) {
        // It's highly recommended to HASH the password before storing it. 
        // This example doesn't perform hashing for simplicity, but refer to secure hashing techniques for real applications.
        this.password = password;
      }
      
      public abstract void showList(Database database,Scanner s);
}
