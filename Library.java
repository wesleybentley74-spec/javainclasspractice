import java.util.ArrayList;
import java.util.List;

/**
 * Central library system that manages books and guest accounts.
 */
public class Library {
    private String name;
    private List<Book> books;     // All books in the library
    private List<GuestAccount> guests; // All guest accounts

    /**
     * Creates a new library with empty book and guest collections.
     */
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
        this.guests = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return new ArrayList<>(books);
    }

    public List<GuestAccount> getGuests() {
        return new ArrayList<>(guests);
    }

    // Adds a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Removes a book from the library
    public void removeBook(Book book) {
        books.remove(book);
    }

    // Registers a guest account with the library
    public void addGuest(GuestAccount guest) {
        guests.add(guest);
    }

    // Displays all books in the library
    public void displayInventory() {
        System.out.println("\n=== Library Inventory ===");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
