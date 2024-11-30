package Lab2;

import java.util.Scanner;

class Matrix {
    private int rows, cols;
    private int[][] matrix;

    // Constructor to allocate memory dynamically for the matrix
    public Matrix(int r, int c) {
        rows = r;
        cols = c;
        matrix = new int[rows][cols]; // Dynamically allocate memory for the matrix
    }

    // Function to input matrix elements
    public void inputMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter matrix elements: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Element[" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    // Function to display the matrix
    public void displayMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Function to add two matrices
    public Matrix add(Matrix m2) {
        // Check if matrices are of the same size
        if (this.rows != m2.rows || this.cols != m2.cols) {
            System.out.println("Matrix dimensions must be the same for addition!");
            System.exit(1); // Exit the program if dimensions don't match
        }

        // Create a new matrix for the result
        Matrix result = new Matrix(this.rows, this.cols);

        // Add corresponding elements of the matrices
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.matrix[i][j] = this.matrix[i][j] + m2.matrix[i][j];
            }
        }

        return result; // Return the result matrix
    }

    // Destructor-like method for cleanup (Java handles garbage collection automatically)
    @Override
    protected void finalize() throws Throwable {
        // Cleanup can be done here if necessary, Java uses garbage collection
        System.out.println("Matrix object is being garbage collected.");
        super.finalize();
    }
}

public class MatrixAddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        // Create two Matrix objects
        Matrix m1 = new Matrix(rows, cols);
        Matrix m2 = new Matrix(rows, cols);

        System.out.println("Enter elements for the first matrix:");
        m1.inputMatrix();

        System.out.println("Enter elements for the second matrix:");
        m2.inputMatrix();

        System.out.println("First Matrix:");
        m1.displayMatrix();

        System.out.println("Second Matrix:");
        m2.displayMatrix();

        // Add the matrices
        Matrix result = m1.add(m2);

        System.out.println("Resultant Matrix after addition:");
        result.displayMatrix();
    }
}
