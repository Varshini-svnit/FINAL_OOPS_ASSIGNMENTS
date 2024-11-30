package Lab2;


import java.util.ArrayList;
import java.util.Scanner;

abstract class LibraryItem {
    String title;
    String author;

    public LibraryItem(String title, String author) {
        this.title = title;
        this.author = author;
    }

    abstract void displayDetails();
}

class Book extends LibraryItem {
    String isbn;

    public Book(String title, String author, String isbn) {
        super(title, author);
        this.isbn = isbn;
    }

    @Override
    void displayDetails() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
    }
}

class Journal extends LibraryItem {
    String volume;

    public Journal(String title, String author, String volume) {
        super(title, author);
        this.volume = volume;
    }

    @Override
    void displayDetails() {
        System.out.println("Journal Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Volume: " + volume);
    }
}

class Library {
    private ArrayList<LibraryItem> items;

    public Library() {
        items = new ArrayList<>();
    }

    public void addBook(String title, String author, String isbn) {
        Book book = new Book(title, author, isbn);
        items.add(book);
    }

    public void addJournal(String title, String author, String volume) {
        Journal journal = new Journal(title, author, volume);
        items.add(journal);
    }

    public void displayAllItems() {
        if (items.isEmpty()) {
            System.out.println("No items available in the library.");
        } else {
            for (LibraryItem item : items) {
                item.displayDetails();
                System.out.println();
            }
        }
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("Library Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Add Journal");
            System.out.println("3. Display All Items");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 1) {
                System.out.print("Enter book title: ");
                String title = scanner.nextLine();
                System.out.print("Enter book author: ");
                String author = scanner.nextLine();
                System.out.print("Enter book ISBN: ");
                String isbn = scanner.nextLine();
                library.addBook(title, author, isbn);
            } else if (choice == 2) {
                System.out.print("Enter journal title: ");
                String title = scanner.nextLine();
                System.out.print("Enter journal author: ");
                String author = scanner.nextLine();
                System.out.print("Enter journal volume: ");
                String volume = scanner.nextLine();
                library.addJournal(title, author, volume);
            } else if (choice == 3) {
                library.displayAllItems();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
