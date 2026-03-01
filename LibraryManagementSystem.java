/**
 * Wesley Bentley
 * CIST 211
 * Doctor G
 * 
 * The Purpose of these files are to help demonstrate the use of UML diagrams in 
 * 
 * Java programming. The main classes in this project are Guest, 
 * Librarian, Book, GuestAccount, and Library. Each class has its own set of attributes 
 * and methods that interact with each other to create a functional library management 
 * system.
 *
 * 
 */
public class LibraryManagementSystem {
    public static void main(String[] args) {
        System.out.println(" LIBRARY MANAGEMENT SYSTEM \n");

        // Create library and librarian
        Library library = new Library("City Central Library");
        System.out.println("Library created: " + library.getName());
        Librarian librarian = new Librarian("John Smith", library);
        System.out.println("Librarian hired: " + librarian);

        // Create books
        Book book1 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book book2 = new Book("1984", "George Orwell");
        Book book3 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Book book4 = new Book("Pride and Prejudice", "Jane Austen");

        // Librarian adds books (UML Method)
        System.out.println("\n--- LIBRARIAN ADDING BOOKS ---");
        librarian.addBooks(book1);
        librarian.addBooks(book2);
        librarian.addBooks(book3);
        librarian.addBooks(book4);
        librarian.viewInventory();

        // Create guests
        System.out.println("\n--- GUESTS CREATING ACCOUNTS ---");
        Guest guest1 = new Guest("Alice Johnson", library);
        Guest guest2 = new Guest("Bob Williams", library);

        // Guests create accounts (UML Method)
        guest1.createAccounts();
        guest2.createAccounts();

        // Guests checkout books (UML Method)
        System.out.println("\n--- GUESTS CHECKING OUT BOOKS ---");
        guest1.checkoutBooks(book1);
        guest1.checkoutBooks(book2);
        guest2.checkoutBooks(book3);

        // Try to checkout unavailable book
        System.out.println("\n--- ATTEMPTING TO CHECKOUT UNAVAILABLE BOOK ---");
        guest2.checkoutBooks(book1);

        // View inventory after checkouts
        System.out.println("\n--- LIBRARY INVENTORY AFTER CHECKOUTS ---");
        librarian.viewInventory();

        // Guests return books
        System.out.println("\n--- GUESTS RETURNING BOOKS ---");
        guest1.returnBook(book1);
        guest2.checkoutBooks(book2);

        // Display guest accounts
        System.out.println("\n--- GUEST ACCOUNT INFORMATION ---");
        System.out.println("Guest 1: " + guest1.getAccount());
        System.out.println("  Checked out books: " + guest1.getAccount().getCheckedOutBooks().size());
        for (Book book : guest1.getAccount().getCheckedOutBooks()) {
            System.out.println("    - " + book.getTitle());
        }

        System.out.println("\nGuest 2: " + guest2.getAccount());
        System.out.println("  Checked out books: " + guest2.getAccount().getCheckedOutBooks().size());
        for (Book book : guest2.getAccount().getCheckedOutBooks()) {
            System.out.println("    - " + book.getTitle());
        }

        // Librarian removes book (UML Method)
        System.out.println("\n--- LIBRARIAN REMOVING BOOK ---");
        librarian.removeBooks(book4);

        // Final inventory
        System.out.println("\n--- FINAL LIBRARY INVENTORY ---");
        librarian.viewInventory();
        
        System.out.println("\n========== END OF DEMONSTRATION ==========");
    }
}
