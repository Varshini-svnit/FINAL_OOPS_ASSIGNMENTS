package java_labs;

import java.util.Scanner;

public class Gas_mileage {
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        double totalMiles = 0;
        double totalGallons = 0;
        int tripCount = 0;

        while (true) {
        
            System.out.print("Enter miles driven (or -1 to exit): ");
            double milesDriven = scanner.nextDouble();
            
            System.out.print("Enter gallons used: ");
            double gallonsUsed = scanner.nextDouble();
            
            double mpg = milesDriven / gallonsUsed;
            System.out.printf("Miles per gallon for this trip: %.2f%n", mpg);
            
            totalMiles=totalMiles+ milesDriven;
            totalGallons= totalGallons+ gallonsUsed;
            tripCount++;
            
            if (totalGallons > 0) {
                double combinedMpg = totalMiles / totalGallons;
                System.out.printf("Combined miles per gallon for all trips: %.2f%n", combinedMpg);
            }
        int t=tripCount;
        System.out.println("total trips: ");
        System.out.println(t);
        
    
        
        if (tripCount > 0) {
            double finalMpg = totalMiles / totalGallons;
            System.out.printf("Final combined miles per gallon: %.2f%n", finalMpg);
        } 
        else {
            System.out.println("No trips were recorded.");
        }
     }
  }
}
