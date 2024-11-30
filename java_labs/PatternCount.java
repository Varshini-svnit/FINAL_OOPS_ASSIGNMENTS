package java_labs;

import java.util.Scanner;

public class PatternCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      
        System.out.print("Enter range start (a): ");
        int a = scanner.nextInt();
        System.out.print("Enter range end (b): ");
        int b = scanner.nextInt();
        scanner.nextLine(); 

       
        System.out.print("Enter pattern: ");
        String pattern = scanner.nextLine();

        
        int occurrences = countPatternInRange(a, b, pattern);

       
        System.out.println("The number of times '" + pattern + "' occurred between " + a + " and " + b + ": " + occurrences);
        
        scanner.close();
    }

    public static int countPatternInRange(int a, int b, String pattern) {
        int count = 0;
        for (int number = a; number <= b; number++) {
            if (String.valueOf(number).contains(pattern)) {
                count++;
            }
        }
        return count;
    }
}
