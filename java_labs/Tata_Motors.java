package java_labs;
import java.util.Scanner;

public class Tata_Motors {

    public static String modelOfCategory(String category) {
        
        String t = category.toUpperCase();
        
        if (t.equals("SUV"))  
            return "TATA SAFARI";
        else if (t.equals("SEDAN"))
            return "TATA INDIGO";
        else if (t.equals("ECONOMY"))
            return "TATA INDICA";
        else if (t.equals("MINI"))
            return "TATA NANO";
        else 
            return "INVALID CATEGORY";
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the category of car (SUV, SEDAN, ECONOMY, MINI): ");
        String t = sc.nextLine();
        
       
        String model = modelOfCategory(t);
        
       
        System.out.println("Car model available in the category \"" + t + "\": " + model);
        
        sc.close();
    }
}
