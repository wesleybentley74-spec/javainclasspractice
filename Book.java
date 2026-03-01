/**
 * Represents a book in the library.
 * Tracks the book's title, author, and availability status.
 */
public class Book {
    private String title;      // Book title
    private String author;     // Book author
    private boolean available; // Whether book is available for checkout

    /**
     * Creates a new book. Books start as available by default.
     */
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    // Update availability when book is checked out or returned
    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return String.format("Book{title='%s', author='%s', available=%s}", title, author, available);
    }
}
