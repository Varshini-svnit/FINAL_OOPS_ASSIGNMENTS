package Lab4_5_6;

import java.util.Scanner;

class Individual {
    private String name;
    private double income;
    private double taxDue;

    // Method to input individual's data
    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter individual's name: ");
        name = scanner.nextLine();

        System.out.print("Enter individual's income: ");
        income = scanner.nextDouble();
    }

    // Method to compute tax
    public void computeTax() {
        if (income <= 100000) {
            taxDue = 0;
        } else if (income <= 150000) {
            taxDue = (income - 100000) * 0.10;
        } else if (income <= 200000) {
            taxDue = (50000 * 0.10) + (income - 150000) * 0.20;
        } else {
            taxDue = (50000 * 0.10) + (50000 * 0.20) + (income - 200000) * 0.30;
        }
    }

    // Method to display individual's details and tax
    public void displayInfo() {
        System.out.println("Individual Name: " + name);
        System.out.println("Income: Rs. " + income);
        System.out.println("Tax Due: Rs. " + taxDue);
    }
}

public class IncomeTaxCalculator {
    public static void main(String[] args) {
        Individual individual = new Individual();

        individual.inputData();
        individual.computeTax();
        individual.displayInfo();
    }
}
