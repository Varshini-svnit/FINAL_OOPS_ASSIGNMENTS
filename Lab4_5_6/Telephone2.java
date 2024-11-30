package Lab4_5_6;

import java.util.Scanner;

class Telephone {
    private String name;
    private int numberOfCalls;
    private double billAmount;

    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        name = scanner.nextLine();

        System.out.print("Enter number of calls made: ");
        numberOfCalls = scanner.nextInt();
    }


    public void computeBill() {
        if (numberOfCalls <= 100) {
            billAmount = 200;
        } else if (numberOfCalls <= 150) {
            billAmount = 200 + (numberOfCalls - 100) * 0.60;
        } else if (numberOfCalls <= 200) {
            billAmount = 200 + 50 * 0.60 + (numberOfCalls - 150) * 0.50;
        } else {
            billAmount = 200 + 50 * 0.60 + 50 * 0.50 + (numberOfCalls - 200) * 0.40;
        }
    }

   
    public void displayInfo() {
        System.out.println("Customer Name: " + name);
        System.out.println("Number of Calls: " + numberOfCalls);
        System.out.println("Telephone Bill: Rs. " + billAmount);
    }
}

public class Telephone2 {
    public static void main(String[] args) {
        Telephone customer = new Telephone();

        customer.inputData();
        customer.computeBill();
        customer.displayInfo();
    }
}
