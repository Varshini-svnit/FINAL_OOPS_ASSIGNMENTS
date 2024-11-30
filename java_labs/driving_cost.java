package java_labs;
import java.util.Scanner;

public class driving_cost {
      
	public static void main (String args[])
	{
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Total miles driven per day");
		double miles=sc.nextDouble();
		
		System.out.println("cost per gallon of gasoline");
		double costpergallon=sc.nextDouble();
		
		System.out.println("average fees per day");
		double averagefees=sc.nextDouble();
		
		System.out.println("tolls per day");
		double tolls=sc.nextDouble();
		
		
		double gasolineCost = miles * costpergallon;

	    double totalCost = gasolineCost + averagefees + tolls;
	    
	    System.out.println("Cost per day of driving to work: ");
	    
	    System.out.println(totalCost);
	    
	    

	}
}

