package Lab4_5_6;

import java.util.Scanner;

class Employee {
    private String name;
    private double earning;
    private double bonus;

    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee name: ");
        name = scanner.nextLine();

        System.out.print("Enter employee earning: ");
        earning = scanner.nextDouble();
    }

    public void computeBonus() {
        if (earning >= 2000) {
            bonus = earning * 0.10;
        } else {
            bonus = 0;
        }
    }

    public void displayInfo() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Earning: " + earning);
        System.out.println("Bonus: " + bonus);
    }
}

public class EmployeeBonus {
    public static void main(String[] args) {
        Employee employee = new Employee();

        employee.inputData();
        employee.computeBonus();
        employee.displayInfo();
    }
}
