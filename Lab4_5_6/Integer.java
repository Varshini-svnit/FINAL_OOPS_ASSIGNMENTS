package Lab4_5_6;
import java.util.Scanner;

class IntegerClass {
    private int value;

    // Constructor to initialize the value
    public IntegerClass(int value) {
        this.value = value;
    }

    // Method to simulate '<<' (Output operator) using a custom method
    public void display() {
        System.out.println("Integer Value: " + value);
    }

    // Method to simulate '>>' (Input operator) using a custom method
    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer value: ");
        this.value = scanner.nextInt();
    }

    // Friend function equivalent: Accessor function to allow external class to modify value
    public static void friendFunction(IntegerClass obj, int newValue) {
        obj.value = newValue;
    }

    // Getter for value (if needed)
    public int getValue() {
        return value;
    }
}

public class Integer {
    public static void main(String[] args) {
        IntegerClass obj1 = new IntegerClass(10);

        // Simulating the '<<' (output) operator
        System.out.println("Using the << operator (displaying the value):");
        obj1.display();

        // Simulating the '>>' (input) operator
        System.out.println("\nUsing the >> operator (input new value):");
        obj1.input();

        // Display the updated value
        System.out.println("\nUpdated value:");
        obj1.display();

        // Using the "friend function" equivalent to set a value
        System.out.println("\nUsing the friend function to set a new value:");
        IntegerClass.friendFunction(obj1, 100);
        obj1.display();
    }

	public static int parseInt(String str) {
		 System.out.println("\nNumberFormatException.");
		return 0;
	}
}
