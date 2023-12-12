// Project: Library Management System
// Author: Stephen Torrijas
// Date: 11/13/2023
// Description: This class represents a user in the library system. 
// It includes details like the user's account number, the books they have checked out, 
// and the total number of books they have checked out.

package library;

import java.util.ArrayList;

public class User {

    private int accountNumber;
    private ArrayList<String> checkedOutBooks;
    private int numberOfBooksCheckedOut;

    // Constructor with no arguments
    // Initializes a new user with a default account number and an empty list of checked out books
    public User() {
        this.accountNumber = 0; // Default account number
        this.checkedOutBooks = new ArrayList<>();
        this.numberOfBooksCheckedOut = 0;
    }

    // Constructor with account number
    // Initializes a new user with the provided account number and an empty list of checked out books
    public User(int accountNumber) {
        this.accountNumber = accountNumber;
        this.checkedOutBooks = new ArrayList<>();
        this.numberOfBooksCheckedOut = 0;
    }

    // Get the account number of the user
    public int getAccountNumber() {
        return accountNumber;
    }

    // Set the account number of the user
    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    // Get the list of books checked out by the user
    public ArrayList<String> getCheckedOutBooks() {
        return checkedOutBooks;
    }

    // Add a book to the list of checked out books
    public void addBook(String bookTitle) {
        checkedOutBooks.add(bookTitle);
        numberOfBooksCheckedOut++;
    }

    // Remove a book from the list of checked out books
    public void returnBook(String bookTitle) {
        checkedOutBooks.remove(bookTitle);
        numberOfBooksCheckedOut--;
    }

    // Get the number of books checked out by the user
    public int getNumberOfBooksCheckedOut() {
        return numberOfBooksCheckedOut;
    }
    
    // Static method to create test user accounts
    public static ArrayList<User> createTestUsers() {
        ArrayList<User> testUsers = new ArrayList<>();

        // Create and add test users to the list
        testUsers.add(new User(1001)); // User with account number 1001
        testUsers.add(new User(1002)); // User with account number 1002
        testUsers.add(new User(1003)); // User with account number 1003

        return testUsers;
    }

    // Initialization block to create test users when the class is loaded
    static {
        ArrayList<User> testUsers = createTestUsers();
        // Optionally, you can perform additional actions with the testUsers list here
    }
}