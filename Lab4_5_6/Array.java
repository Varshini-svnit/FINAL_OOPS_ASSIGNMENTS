package Lab4_5_6;

import java.util.Scanner;

class ArrayExample {
    private int[] arr;
    private int size;

    // Constructor to allocate memory dynamically for the array
    public ArrayExample(int size) {
        this.size = size;
        arr = new int[size];  // Dynamically allocate memory for the array
        System.out.println("Memory allocated for array of size " + size);
    }

    // Function to input values into the array
    public void inputValues() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter " + size + " elements for the array:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }
    }

    // Function to display values of the array
    public void displayValues() {
        System.out.print("Array elements are: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void deallocateMemory() {
        arr = null; 
        System.out.println("Memory deallocated (simulated).");
    }
}

public class Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        ArrayExample obj = new ArrayExample(size);

     
        obj.inputValues();

     
        obj.displayValues();

      
        obj.deallocateMemory();

    }
}
