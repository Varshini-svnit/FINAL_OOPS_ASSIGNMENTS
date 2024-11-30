package java_labs;

import java.util.HashSet;
import java.util.Scanner;

public class PerfectStringChecker {

    public static boolean isPerfectString(String inputString) {
       
        HashSet<Character> charSet = new HashSet<>();
        
     
        for (char c : inputString.toCharArray()) {
          
            if (!charSet.add(c)) {
                return false; 
            }
        }
        
        
        return true;
    }

    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);
        
   
        System.out.print("Enter the string: ");
        String inputString = scanner.nextLine();
        
      
        if (isPerfectString(inputString)) {
            System.out.println("The string is a perfect string.");
        } else {
            System.out.println("The string is not a perfect string.");
        }

     
        scanner.close();
    }
}
