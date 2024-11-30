package Lab4_5_6;

import java.util.Scanner;

class Publication {
    protected String title;
    protected String authorName;
    protected double price;

    public void getData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter title: ");
        title = scanner.nextLine();

        System.out.print("Enter author's name: ");
        authorName = scanner.nextLine();

        System.out.print("Enter price: ");
        price = scanner.nextDouble();
    }

    public void displayData() {
        System.out.println("Title: " + title);
        System.out.println("Author's Name: " + authorName);
        System.out.println("Price: Rs. " + price);
    }
}

class Book extends Publication {
    private int pageCount;

    @Override
    public void getData() {
        super.getData();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter page count: ");
        pageCount = scanner.nextInt();
    }

    @Override
    public void displayData() {
        super.displayData();
        System.out.println("Page Count: " + pageCount);
    }
}

class Ebook extends Publication {
    private double playTime;

    @Override
    public void getData() {
        super.getData();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter playing time (in hours): ");
        playTime = scanner.nextDouble();
    }

    @Override
    public void displayData() {
        super.displayData();
        System.out.println("Playing Time: " + playTime + " hours");
    }
}

public class PublicationTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter details for Book:");
        Book book = new Book();
        book.getData();

        System.out.println("\nEnter details for Ebook:");
        Ebook ebook = new Ebook();
        ebook.getData();

        System.out.println("\nDetails of Book:");
        book.displayData();

        System.out.println("\nDetails of Ebook:");
        ebook.displayData();
    }
}
