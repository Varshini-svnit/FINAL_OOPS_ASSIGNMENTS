package Lab2;

import java.util.Scanner;

class Student4 {
    private int admno;
    private String name;
    private float marksEng;
    private float marksMaths;
    private float marksSci;
    private float total;

    //  function to compute the total marks
    public void compute() {
        total = marksEng + marksMaths + marksSci;
    }

    // Function to accept data and invoke compute function
    public void readData(int admno, String name, float marksEng, float marksMaths, float marksSci) {
        this.admno = admno;
        this.name = name;
        this.marksEng = marksEng;
        this.marksMaths = marksMaths;
        this.marksSci = marksSci;
        compute();
    }

    // Show data function
    public void showData() {
        System.out.println("Admission Number: " + admno);
        System.out.println("Name: " + name);
        System.out.println("Marks in English: " + marksEng);
        System.out.println("Marks in Mathematics: " + marksMaths);
        System.out.println("Marks in Science: " + marksSci);
        System.out.println("Total Marks: " + total);
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        Student4 student = new Student4();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Admission Number: ");
        int admno = scanner.nextInt();

        scanner.nextLine();  // Consume the newline left by nextInt()

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Marks in English: ");
        float marksEng = scanner.nextFloat();

        System.out.print("Enter Marks in Mathematics: ");
        float marksMaths = scanner.nextFloat();

        System.out.print("Enter Marks in Science: ");
        float marksSci = scanner.nextFloat();

        student.readData(admno, name, marksEng, marksMaths, marksSci);
        student.showData();

        scanner.close();
    }
}
