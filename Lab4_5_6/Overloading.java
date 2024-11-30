package Lab4_5_6;

class IntegerClass {
    private int value;

    // Constructor to initialize the value
    public IntegerClass(int value) {
        this.value = value;
    }

    // Method to get the value
    public int getValue() {
        return value;
    }

    // Method to display the integer value
    public void display() {
        System.out.println("Integer Value: " + value);
    }
}

// This class simulates the behavior of a "friend function" in Java
class FriendFunction
{
    // Simulating the '+' operator as a friend function (by accessing private members)
    public static IntegerClass add(IntegerClass obj1, IntegerClass obj2) {
        // Adding values of two IntegerClass objects and returning the result
        return new IntegerClass(obj1.getValue() + obj2.getValue());
    }
}

public class Overloading {
    public static void main(String[] args) {
        // Create two IntegerClass objects
        IntegerClass obj1 = new IntegerClass(10);
        IntegerClass obj2 = new IntegerClass(20);

        // Display initial values
        obj1.display();
        obj2.display();

        // Use the simulated "friend function" to add two IntegerClass objects
        IntegerClass result = FriendFunction.add(obj1, obj2);

        // Display the result of the addition
        result.display();
    }
}
