/**
 * Manages the library's book inventory.
 * Main methods: addBooks() and removeBooks()
 */
public class Librarian {
    private String name;
    private Library library; // The library managed by this librarian

    /**
     * Creates a new librarian assigned to manage a library.
     */
    public Librarian(String name, Library library) {
        this.name = name;
        this.library = library;
    }

    // UML Method: Add a book to the library
    public void addBooks(Book book) {
        library.addBook(book);
        System.out.println("Librarian " + name + " added book: " + book.getTitle());
    }

    // UML Method: Remove a book from the library
    public void removeBooks(Book book) {
        library.removeBook(book);
        System.out.println("Librarian " + name + " removed book: " + book.getTitle());
    }

    // Helper method: Display the library inventory
    public void viewInventory() {
        System.out.println("\nLibrarian " + name + " viewing inventory...");
        library.displayInventory();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Librarian{name='%s'}", name);
    }
}
