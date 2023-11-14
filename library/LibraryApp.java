// Project: Library Management System
// Author: Jonathan Fulkerson
// Date: 11/13/2023

package library;

import java.util.Scanner;

// This class holds the main method
public class LibraryApp {

        // This is where the GUI will be called when we have that functionality and basic
        // calls will be made to use different functions of the app
    public static void main(String[] args) {

        // Set variables according to the entry in GUI
        Scanner scan = new Scanner(System.in);
        String account = scan.nextLine();

        // Create an instance of a user based on a given account number
        User user = new User(123);

        // Display user information
        System.out.println("User Account Number: " + user.getAccountNumber());

        // Create an instance of a book based on given parameters
        Book book = new Book("The Great Gatsby", "F. Scott Fitzgerald", 123456789);

        // Display book information
        System.out.println("Book Title: " + book.getTitle());
        System.out.println("Book Author: " + book.getAuthor());
        System.out.println("Book ISBN: " + book.getISBN());
        System.out.println("Book Availability: " + (book.isAvailable() ? "Available" : "Not Available"));

        // Check out the book to the user if available
        if (book.isAvailable()) {
            book.chekcoutBook();
            user.addBook(book.getTitle());
            System.out.println("Book Checked Out successfully!");
        } else {
            System.out.println("Book is not available for checkout.");
        }

        // Display updated user information
        System.out.println("Books Checked Out: " + user.getNumberOfBooksCheckedOut());
        System.out.println("Checked Out Books: " + user.getCheckedOutBooks());

        // Return the book
        book.returnBook();
        user.returnBook(book.getTitle());

        // Display updated user information after returning the book
        System.out.println("Books Checked Out: " + user.getNumberOfBooksCheckedOut());
        System.out.println("Checked Out Books: " + user.getCheckedOutBooks());
    }
}