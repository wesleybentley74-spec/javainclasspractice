/**
 * Represents a guest in the library system.
 * Main methods: createAccounts() and checkoutBooks()
 */
public class Guest {
    private String name;
    private Library library;      // The library system
    private GuestAccount account; // Guest's account (null until created)

    /**
     * Creates a new guest. Must create account before checking out books.
     */
    public Guest(String name, Library library) {
        this.name = name;
        this.library = library;
        this.account = null;
    }

    // UML Method: Create a new guest account
    public GuestAccount createAccounts() {
        account = new GuestAccount(name);
        library.addGuest(account);
        System.out.println("Guest " + name + " created new account. Account ID: " + account.getAccountId());
        return account;
    }

    // UML Method: Check out a book from the library
    public void checkoutBooks(Book book) {
        if (account == null) {
            System.out.println("Error: Guest " + name + " must create an account first!");
            return;
        }
        if (book.isAvailable()) {
            account.addCheckedOutBook(book);
            System.out.println("Guest " + name + " checked out book: " + book.getTitle());
        } else {
            System.out.println("Error: Book '" + book.getTitle() + "' is not available.");
        }
    }

    // Helper method: Return a book to the library
    public void returnBook(Book book) {
        if (account != null && account.getCheckedOutBooks().contains(book)) {
            account.returnBook(book);
            System.out.println("Guest " + name + " returned book: " + book.getTitle());
        } else {
            System.out.println("Error: This book was not checked out by this guest.");
        }
    }

    public GuestAccount getAccount() {
        return account;
    }

    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return String.format("Guest{name='%s', hasAccount=%s}", name, account != null);
    }
}
