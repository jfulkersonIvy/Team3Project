package library;

import java.util.ArrayList;
import java.util.Objects;

public class User {

    private int accountNumber;
    private ArrayList<String> checkedOutBooks;
    private int numberOfBooksCheckedOut;
    // Optional: Adding user name fields
    private String firstName;
    private String lastName;

    // Constructors
    public User() {
        this(0); // Default account number
    }

    public User(int accountNumber) {
        this.accountNumber = accountNumber;
        this.checkedOutBooks = new ArrayList<>();
        this.numberOfBooksCheckedOut = 0;
    }

    // Optional: Constructor with user name
    public User(int accountNumber, String firstName, String lastName) {
        this(accountNumber);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getters and Setters
    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public ArrayList<String> getCheckedOutBooks() {
        return new ArrayList<>(checkedOutBooks); // Return a copy for encapsulation
    }

    public int getNumberOfBooksCheckedOut() {
        return numberOfBooksCheckedOut;
    }

    // Optional: Getters and Setters for names
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Add a book to the list of checked out books
    public void addBook(String bookTitle) {
        checkedOutBooks.add(bookTitle);
        numberOfBooksCheckedOut++;
    }

    // Remove a book from the list of checked out books
    public void returnBook(String bookTitle) {
        if (checkedOutBooks.remove(bookTitle)) {
            numberOfBooksCheckedOut--;
        }
    }

    // Overriding toString for better object representation
    @Override
    public String toString() {
        return "User{" +
               "accountNumber=" + accountNumber +
               ", checkedOutBooks=" + checkedOutBooks +
               ", numberOfBooksCheckedOut=" + numberOfBooksCheckedOut +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               '}';
    }

    // Overriding equals and hashCode for object comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return accountNumber == user.accountNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
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