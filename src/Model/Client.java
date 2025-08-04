package src.Model;
import java.util.*;
import src.Controller.*;

public class Client extends User{
    
    private Operation[] operations = new Operation[] {new ViewCars(),
                                                    new RentCar(),
                                                    new ReturnCar(),
                                                    new ShowUserRents(super.getID()),
                                                    new EditUserData(),
                                                    new Quit()};
    public Client(){
        super();
    }

    public void showList(Database database,Scanner s){
        System.out.println("\n1. View Cars");
        System.out.println("2. Rent Car");
        System.out.println("3. Return Car");
        System.out.println("4. Show My Rents");
        System.out.println("5. Edit Personal Details");
        System.out.println("6. Quit");

        int i = s.nextInt();
        if(i<1 || i>6) {
            showList(database,s);
            return;
        }
        operations[i-1].operation(database,s,this);
        if(i!=6) showList(database,s);
    }
}
