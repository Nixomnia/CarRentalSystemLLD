package src.Controller;
import java.util.Scanner;
import src.Model.*;

public class Quit implements Operation{
        public void operation(Database database, Scanner s,User user){
            System.out.println("Thanks for visiting us!");
            s.close();
        }
}
