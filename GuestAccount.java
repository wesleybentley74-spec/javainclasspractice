import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Represents a guest's account in the library.
 * Tracks the guest's checked-out books and account information.
 */
public class GuestAccount {
    private String accountId;           // Unique account identifier
    private String guestName;           // Guest's name
    private List<Book> checkedOutBooks; // Books the guest has checked out

    /**
     * Creates a new guest account with a unique ID.
     */
    public GuestAccount(String guestName) {
        this.accountId = UUID.randomUUID().toString();
        this.guestName = guestName;
        this.checkedOutBooks = new ArrayList<>();
    }

    public String getAccountId() {
        return accountId;
    }

    public String getGuestName() {
        return guestName;
    }

    // Adds book if available, marks book as unavailable
    public void addCheckedOutBook(Book book) {
        if (book.isAvailable()) {
            checkedOutBooks.add(book);
            book.setAvailable(false);
        }
    }

    // Removes book from guest's list and marks as available
    public void returnBook(Book book) {
        if (checkedOutBooks.contains(book)) {
            checkedOutBooks.remove(book);
            book.setAvailable(true);
        }
    }

    public List<Book> getCheckedOutBooks() {
        return new ArrayList<>(checkedOutBooks);
    }

    @Override
    public String toString() {
        return String.format("GuestAccount{accountId='%s', guestName='%s', booksCheckedOut=%d}",
                accountId, guestName, checkedOutBooks.size());
    }
}
