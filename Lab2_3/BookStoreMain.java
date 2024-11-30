package Lab2;

import java.util.Scanner;

class Book {
    String title;
    String subject;
    double price;

    public Book(String title, String subject, double price) {
        this.title = title;
        this.subject = subject;
        this.price = price;
    }

    public void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Subject: " + subject);
        System.out.println("Price: " + price);
    }
}

class BookStore {
    private Book[] books;

    public BookStore(int size) {
        books = new Book[size];
    }

    public void addBook(int index, Book book) {
        if (index >= 0 && index < books.length) {
            books[index] = book;
        }
    }

    public void displayCheapestBook(String subject) {
        Book cheapestBook = null;
        for (Book book : books) {
            if (book != null && book.subject.equals(subject)) {
                if (cheapestBook == null || book.price < cheapestBook.price) {
                    cheapestBook = book;
                }
            }
        }
        if (cheapestBook != null) {
            System.out.println("Cheapest book for subject " + subject + ":");
            cheapestBook.displayBookDetails();
        } else {
            System.out.println("No books found for the subject: " + subject);
        }
    }
}

public class BookStoreMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of books: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        BookStore bookStore = new BookStore(n);

        for (int i = 0; i < n; i++) {
            System.out.print("Enter book title: ");
            String title = scanner.nextLine();

            System.out.print("Enter book subject: ");
            String subject = scanner.nextLine();

            System.out.print("Enter book price: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline

            Book book = new Book(title, subject, price);
            bookStore.addBook(i, book);
        }

        System.out.print("Enter subject to find the cheapest book: ");
        String subjectToFind = scanner.nextLine();

        bookStore.displayCheapestBook(subjectToFind);

        scanner.close();
    }
}

