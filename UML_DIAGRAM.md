# Library Management System - UML Class Diagram

```
┌─────────────────────────────────────┐
│          Library                    │
├─────────────────────────────────────┤
│ - books: List<Book>                 │
│ - guests: List<GuestAccount>        │
│ - name: String                      │
├─────────────────────────────────────┤
│ + getBooks(): List<Book>            │
│ + getGuests(): List<GuestAccount>   │
│ + addBook(Book): void               │
│ + removeBook(Book): void            │
│ + addGuest(GuestAccount): void      │
└─────────────────────────────────────┘
         △                    △
         │ uses               │ uses
         │                    │
         │                    │
┌─────────────────────────────────────┐  ┌──────────────────────┐
│      Librarian                      │  │   Book               │
├─────────────────────────────────────┤  ├──────────────────────┤
│ - name: String                      │  │ - title: String      │
│ - employeeId: String                │  │ - author: String     │
│ - library: Library                  │  │ - isbn: String       │
├─────────────────────────────────────┤  │ - available: boolean │
│ + addBooks(Book): void              │  ├──────────────────────┤
│ + removeBooks(Book): void           │  │ + getTitle(): String │
│ + viewInventory(): List<Book>       │  │ + getAuthor(): String│
└─────────────────────────────────────┘  │ + isAvailable(): ..  │
                                         └──────────────────────┘

┌──────────────────────────────────────┐
│      Guest                           │
├──────────────────────────────────────┤
│ - name: String                       │
│ - library: Library                   │
├──────────────────────────────────────┤
│ + createAccounts(): GuestAccount     │
│ + checkoutBooks(Book): void          │
└──────────────────────────────────────┘
         │
         │ creates
         │
┌──────────────────────────────────────┐
│      GuestAccount                    │
├──────────────────────────────────────┤
│ - accountId: String                  │
│ - guestName: String                  │
│ - checkedOutBooks: List<Book>        │
│ - creationDate: LocalDate            │
├──────────────────────────────────────┤
│ + addCheckedOutBook(Book): void      │
│ + returnBook(Book): void             │
│ + getCheckedOutBooks(): List<Book>   │
└──────────────────────────────────────┘

RELATIONSHIPS:
- Librarian HAS-A Library (aggregation)
- Guest HAS-A Library (aggregation)
- Library HAS-MANY Books (aggregation)
- Library HAS-MANY GuestAccounts (aggregation)
- GuestAccount HAS-MANY Books (aggregation)
```
