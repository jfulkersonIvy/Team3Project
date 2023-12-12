// Phase 3 - Library, Trace Crafton, 11/13/23
// Book class is used to create new book object and checkout/return

package library;

public class Book {

    private String title;
    private String author;
    // Use long data type since ISBNs are 13 digits
    private long ISBN;
    private boolean available;
    
    // Constructor
    public Book(String title, String author, long ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.available = true;
    }

    // Get book title
    public String getTitle() {
        return title;
    }

    // Get book author
    public String getAuthor() {
        return author;
    }

    // Get book ISBN
    public long getISBN() {
        return ISBN;
    }

    // Identify book availability
    public boolean isAvailable() {
        return available;
    }

    // If available, check out book and make unavailable
    public void checkoutBook() {
        if (available) {
            available = false;
            System.out.println("Checked out successfully!");
        } else {
            System.out.println("Sorry, this book is currently unavailable.");
        }
    }

    // If checked out, return book
    public void returnBook() {
        available = true;
        System.out.println("Book returned successfully!");
    }
}
