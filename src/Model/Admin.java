package src.Model;
import src.Controller.*;
import java.util.Scanner ;

public class Admin extends User {

    private Operation[] operations = new Operation[] {new AddNewCar(),
                                                     new ViewCars(),
                                                     new UpdateCar(),
                                                     new DeleteCar(),
                                                     new ShowAllRents(),
                                                     new AddNewAccount(1),
                                                     new Quit()};
    public Admin(){
        super();
    }

    public void showList(Database database, Scanner s){
        System.out.println("\n1. Add New car");
        System.out.println("2. View Cars");
        System.out.println("3. Update Car Details");
        System.out.println("4. Delete Car");
        System.out.println("5. Show All Rents");
        System.out.println("6. Show All Rents of User");
        System.out.println("7. Add New Admin");
        System.out.println("8. Quit");
        
        int i= s.nextInt();
        if(i<1 || i>8){
            showList(database,s);
            return;
        }
        operations[i].operation(database,s,this);
        if(i!=8) showList(database,s);
    }

}
