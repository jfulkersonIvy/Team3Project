// Project: Library Management System
// Author: Jonathan Fulkerson
// Date: 11/13/2023

package library;

import java.util.ArrayList;
import java.util.Scanner;

// This class holds the main method
public class LibraryApp {

    // This is where the GUI will be called when we have that functionality and basic
    // calls will be made to use different functions of the app
    public static void main(String[] args) {

        // Create an arraylist of books to simulate our inventory
        ArrayList<Book> availableBooks = new ArrayList<>();
        ArrayList<Book> checkedOutBooks = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        // Initialize the books
        availableBooks.add(new Book("Don Quixote", "Miguel de Cervantes", 9780486821955L));
        availableBooks.add(new Book("Alice's Adventures in Wonderland", "Lewis Carroll", 9780486275437L));
        availableBooks.add(new Book("The Adventures of Huckleberry Finn", "Mark Twain", 9780486280615L));
        availableBooks.add(new Book("The Adventures of Tom Sawyer", "Mark Twain", 9780486400778L));
        availableBooks.add(new Book("Treasure Island", "Robert Louis Stevenson", 9798623553805L));

        // Create a boolean value to verify the user has a valid account
        boolean isValidAccount = false;
        User user = null;

        // While account has not been verified, we will continue to ask for the account
        while (!isValidAccount) {
            System.out.println("Enter your account number: ");
            int accountNumber = scan.nextInt();

            // Perform validation (Check vs test accounts in User.java)
            if (isValidAccount(accountNumber)) {
                user = new User(accountNumber);
                isValidAccount = true;
            } else {
                System.out.println("Invalid account number. Please try again.");
            }
        }
        boolean exit = false;

        // Print the library menu in console
        while (!exit) {
            System.out.println("\n=== Library Menu ===");
            System.out.println("1. View Available Books");
            System.out.println("2. Checkout a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Display Checked Out Books");
            System.out.println("5. Exit");

            System.out.println("\nEnter your choice: ");
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable Books:");
                    for (int i = 0; i < availableBooks.size(); i++) {
                        System.out.println((i + 1) + ". " + availableBooks.get(i).getTitle());
                    }
                    break;
                case 2:
                    System.out.println("\nAvailable Books:");
                    for (int i = 0; i < availableBooks.size(); i++) {
                        System.out.println((i + 1) + ". " + availableBooks.get(i).getTitle());
                    }
                    System.out.println("Enter the number of the book you want to checkout:");
                    int bookNumber = scan.nextInt();

                    if (bookNumber > 0 && bookNumber <= availableBooks.size()) {
                        Book selectedBook = availableBooks.get(bookNumber - 1);

                        if (selectedBook.isAvailable()) {
                            selectedBook.checkoutBook();
                            System.out.println("Book '" + selectedBook.getTitle() + "' Checked Out successfully!");

                            // Associate the book with the user by adding it to the user's checked-out books
                            user.addBook(selectedBook.getTitle());

                            // Move the checked-out book from available books to checked-out books
                            checkedOutBooks.add(selectedBook);
                            availableBooks.remove(selectedBook);
                        } else {
                            System.out.println("Sorry, the selected book is not available for checkout.");
                        }
                    } else {
                        System.out.println("Invalid book selection.");
                    }
                    break;
                case 3:
                    System.out.println("\nChecked Out Books:");
                    if (checkedOutBooks.isEmpty()) {
                        System.out.println("No books are checked out.");
                    } else {
                        for (int i = 0; i < checkedOutBooks.size(); i++) {
                            System.out.println((i + 1) + ". " + checkedOutBooks.get(i).getTitle());
                        }

                        System.out.println("Enter the number of the book you want to return:");
                        int returnBookNumber = scan.nextInt();

                        if (returnBookNumber > 0 && returnBookNumber <= checkedOutBooks.size()) {
                            Book returnedBook = checkedOutBooks.get(returnBookNumber - 1);
                            returnedBook.returnBook();
                            System.out.println("Book '" + returnedBook.getTitle() + "' Returned successfully!");

                            // Move the returned book from checked-out books to available books
                            availableBooks.add(returnedBook);
                            checkedOutBooks.remove(returnedBook);
                        } else {
                            System.out.println("Invalid book selection for return.");
                        }
                    }
                    break;
                case 4:
                    System.out.println("\nChecked Out Books:");
                    ArrayList<String> userCheckedOutBooks = user.getCheckedOutBooks();
                    if (userCheckedOutBooks.isEmpty()) {
                        System.out.println("You haven't checked out any books yet.");
                    } else {
                        for (int i = 0; i < userCheckedOutBooks.size(); i++) {
                            System.out.println((i + 1) + ". " + userCheckedOutBooks.get(i));
                        }
                    }
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting Library. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }

        scan.close();
    }

    private static boolean isValidAccount(int accountNumber) {
        // Our account numbers should be within 1000 and 9999
        return (accountNumber >= 1000 && accountNumber <= 9999);
    }
}