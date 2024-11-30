package Lab2;


import java.util.Scanner;

class Topper6  {
    String name;
    int marks;

    Topper6(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine(); 

        String topper = "";
        int maxMarks = -1;

        for (int i = 0; i < n; i++) {
            System.out.print("Enter name of student " + (i + 1) + ": ");
            String name = scanner.nextLine();
            System.out.print("Enter marks of " + name + ": ");
            int marks = scanner.nextInt();
            scanner.nextLine(); 

            if (marks > maxMarks) {
                maxMarks = marks;
                topper = name;
            }
        }

        System.out.println("Topper in the class is: " + topper);
        scanner.close();
    }
}
