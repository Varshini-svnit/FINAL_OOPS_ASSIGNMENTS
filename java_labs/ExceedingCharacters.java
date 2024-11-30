
package java_labs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
 class ExceedingCharacters {
    
    public static void findExceedingCharacters(String inputString, int n) {
       
        Map<Character, Integer> charCount = new HashMap<>();
        
      
        for (char c : inputString.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        // Print characters whose count exceeds n
        System.out.print("Characters that exceed the threshold " + n + ": ");
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() > n) {
                System.out.print(entry.getKey() + " ");
            }
        }
        System.out.println(); // For a newline after printing the characters
    };
  public static void main(String[] args) {
        // Create scanner object for user input
        Scanner scanner = new Scanner(System.in);
        
        // Input the string from the user
        System.out.print("Enter the string: ");
        String inputString = scanner.nextLine();
        
        // Input the threshold number n
        System.out.print("Enter the threshold number n: ");
        int n = scanner.nextInt();
        
        // Call the function to find and print exceeding characters
        findExceedingCharacters(inputString, n);
        
        // Close the scanner
        scanner.close();
    }
}
