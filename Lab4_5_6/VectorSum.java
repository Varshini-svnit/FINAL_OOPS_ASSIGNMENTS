package Lab4_5_6;


import java.util.Scanner;

class Vector {
    private int[] arr;
    private int size;

    public Vector(int size) {
        this.size = size;
        arr = new int[size];
    }

    
    public void inputVector() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter " + size + " elements for the vector:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
    }
    public void outputVector() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]);
            if (i != size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    
    public Vector add(Vector other) {
        if (this.size != other.size) {
            System.out.println("Vectors must be of the same size to add.");
            return null;
        }

        Vector result = new Vector(this.size);
        for (int i = 0; i < size; i++) {
            result.arr[i] = this.arr[i] + other.arr[i];
        }
        return result;
    }

    public Vector subtract(Vector other) {
        if (this.size != other.size) {
            System.out.println("Vectors must be of the same size to subtract.");
            return null;
        }

        Vector result = new Vector(this.size);
        for (int i = 0; i < size; i++) {
            result.arr[i] = this.arr[i] - other.arr[i];
        }
        return result;
    }

    // Method to simulate '<<' operator for output
    public void operatorLeftShift() {
        outputVector();
    }

    // Method to simulate '>>' operator for input
    public void operatorRightShift() {
        inputVector();
    }
}

public class VectorSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the vectors: ");
        int size = scanner.nextInt();

        Vector vector1 = new Vector(size);
        Vector vector2 = new Vector(size);

       
        System.out.println("Enter values for vector 1:");
        vector1.operatorRightShift();  
        System.out.println("Enter values for vector 2:");
        vector2.operatorRightShift();  

        System.out.print("Vector 1: ");
        vector1.operatorLeftShift(); 
        System.out.print("Vector 2: ");
        vector2.operatorLeftShift();  

        Vector sum = vector1.add(vector2);
        if (sum != null) {
            System.out.print("Sum of the vectors: ");
            sum.operatorLeftShift();
        }

 
        Vector diff = vector1.subtract(vector2);
        if (diff != null) {
            System.out.print("Difference of the vectors: ");
            diff.operatorLeftShift();
        }
    }
}
