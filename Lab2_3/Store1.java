package Lab2;

import java.util.Scanner;

class  Store1 {

    public static void computeAmount(int miners, int toasters, int fans) {
        final double MINER_PRICE = 1500.0;
        final double TOASTER_PRICE = 200.0;
        final double FAN_PRICE = 450.0;

        final double MINER_DISCOUNT = 0.05;
        final double TOASTER_DISCOUNT = 0.10;
        final double FAN_DISCOUNT = 0.15;

        final double SALES_TAX_RATE = 0.10;

        double minerTotal = miners * MINER_PRICE * (1 - MINER_DISCOUNT);
        double toasterTotal = toasters * TOASTER_PRICE * (1 - TOASTER_DISCOUNT);
        double fanTotal = fans * FAN_PRICE * (1 - FAN_DISCOUNT);

        double subTotal = minerTotal + toasterTotal + fanTotal;
        double totalAmount = subTotal * (1 + SALES_TAX_RATE);

        System.out.println("Amount Breakdown:");
        System.out.printf("Miners Total (after discount): Rs. %.2f%n", minerTotal);
        System.out.printf("Toasters Total (after discount): Rs. %.2f%n", toasterTotal);
        System.out.printf("Fans Total (after discount): Rs. %.2f%n", fanTotal);
        System.out.printf("Subtotal (after all discounts): Rs. %.2f%n", subTotal);
        System.out.printf("Total Amount (including 10%% sales tax): Rs. %.2f%n", totalAmount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of miners: ");
        int miners = scanner.nextInt();

        System.out.print("Enter the number of toasters: ");
        int toasters = scanner.nextInt();

        System.out.print("Enter the number of fans: ");
        int fans = scanner.nextInt();

        computeAmount(miners, toasters, fans);

        scanner.close();
    }
}
