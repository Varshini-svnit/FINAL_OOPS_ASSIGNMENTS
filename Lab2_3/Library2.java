package Lab2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

class Library2 {

    public static void calculateDueDate(String issueDate, int dueDays) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy");
        LocalDate issueLocalDate = LocalDate.parse(issueDate, formatter);
        LocalDate dueDate = issueLocalDate.plusDays(dueDays);

        System.out.println("Issue Date: " + issueLocalDate.format(formatter));
        System.out.println("Due Date: " + dueDate.format(formatter));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the issue date (dd-MM-yy): ");
        String issueDate = scanner.nextLine();

        System.out.print("Enter the number of days for the book to be due: ");
        int dueDays = scanner.nextInt();

        calculateDueDate(issueDate, dueDays);

        scanner.close();
    }
}
