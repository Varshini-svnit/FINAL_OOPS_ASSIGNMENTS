 package Lab4_5_6;

import java.util.Scanner;


class IntegerClass {
    private int value;

    // Constructor to initialize the value
    public IntegerClass(int value) {
        this.value = value;
    }

    // Method to compare the integer value with a string
    public int compareTo(String str) {
        // Convert the string to an integer
        try {
            int strValue = Integer.parseInt(str);
            // Compare the integer value with the parsed string value
            if (this.value > strValue) {
                return 1; // Means the integer value is greater than the string value
            } else if (this.value < strValue) {
                return -1; // Means the integer value is less than the string value
            } else {
                return 0; // Means the integer value is equal to the string value
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid string format. Unable to compare.");
            return -2; // Indicates an invalid string format
        }
    }

    // Method to display the integer value
    public void display() {
        System.out.println("Integer Value: " + value);
    }
}

public class Main {
    public static void main(String[] args) {
        IntegerClass obj1 = new IntegerClass(25);

        // Display the integer value
        obj1.display();

        // Compare the integer value with a string
        String str = "30";
        int result = obj1.compareTo(str);

        // Display the comparison result
        if (result == 1) {
            System.out.println("The integer value is greater than the string value.");
        } else if (result == -1) {
            System.out.println("The integer value is less than the string value.");
        } else if (result == 0) {
            System.out.println("The integer value is equal to the string value.");
        } else {
            System.out.println("Comparison failed due to invalid string format.");
        }
    }
}
