# Library Management System - Implementation Documentation

## Overview
This project implements a **Library Management System** based on UML design principles. The system demonstrates core object-oriented programming concepts including aggregation, encapsulation, and interaction between multiple classes.

## UML Design

The system includes the following classes with the specified relationships:

```
MAIN CLASSES:

┌──────────────────────────┐
│      Librarian           │
├──────────────────────────┤
│ Main Methods:            │
│ • addBooks(Book)         │
│ • removeBooks(Book)      │
└──────────────────────────┘

┌──────────────────────────┐
│      Guest               │
├──────────────────────────┤
│ Main Methods:            │
│ • createAccounts()       │
│ • checkoutBooks(Book)    │
└──────────────────────────┘

SUPPORTING CLASSES:

┌──────────────────────────┐
│      Library             │
├──────────────────────────┤
│ Aggregates: Books,       │
│ Guest Accounts           │
└──────────────────────────┘

┌──────────────────────────┐
│      Book                │
├──────────────────────────┤
│ Represents library items │
└──────────────────────────┘

┌──────────────────────────┐
│    GuestAccount          │
├──────────────────────────┤
│ Represents guest profile │
│ and checked out books    │
└──────────────────────────┘
```

## Class Descriptions

### 1. **Librarian.java**
- **Purpose**: Manages library operations and inventory
- **Key UML Methods**:
  - `addBooks(Book book)` - Adds a book to the library inventory
  - `removeBooks(Book book)` - Removes a book from the library inventory
- **Supporting Methods**:
  - `viewInventory()` - Displays all books in the library
- **Aggregation**: Contains reference to `Library` object

### 2. **Guest.java**
- **Purpose**: Represents a library visitor
- **Key UML Methods**:
  - `createAccounts()` - Creates a new `GuestAccount` for the guest
  - `checkoutBooks(Book book)` - Checks out a book (requires active account)
- **Supporting Methods**:
  - `returnBook(Book book)` - Returns a previously checked out book
  - `getAccount()` - Retrieves guest's account information
- **Aggregation**: Contains reference to `Library` object and `GuestAccount`

### 3. **Library.java**
- **Purpose**: Central management system for all books and guest accounts
- **Responsibilities**:
  - Maintains list of all available books
  - Maintains list of all guest accounts
  - Provides book and guest lookup functionality
- **Aggregation**: Contains multiple `Book` objects and `GuestAccount` objects

### 4. **Book.java**
- **Purpose**: Represents a book in the library
- **Attributes**:
  - `title` - Book title
  - `author` - Book author
  - `isbn` - Unique identifier (ISBN)
  - `available` - Availability status (can be checked out or not)
- **Methods**: Getters/setters for all attributes

### 5. **GuestAccount.java**
- **Purpose**: Represents a guest's account and tracked books
- **Attributes**:
  - `accountId` - Unique UUID for each account
  - `guestName` - Name of the guest
  - `checkedOutBooks` - List of currently checked out books
  - `creationDate` - Account creation date
- **Methods**: Book management (add, return, retrieve)

## Key Design Patterns

### Aggregation Relationships
- **Librarian HAS-A Library**: The librarian manages the library
- **Guest HAS-A Library**: The guest accesses the library
- **Library HAS-MANY Books**: The library contains many books
- **Library HAS-MANY GuestAccounts**: The library manages multiple guest accounts
- **GuestAccount HAS-MANY Books**: Tracks books checked out by each guest

### Encapsulation
- All classes use private attributes with public getter/setter methods
- Book availability is managed internally by the system
- Guest accounts are created through the `createAccounts()` method

## System Workflow

1. **Library Setup**: Create a `Library` instance
2. **Librarian Management**: Create a `Librarian` to manage the library
3. **Book Management**: Librarian uses `addBooks()` and `removeBooks()` to manage inventory
4. **Guest Registration**: Guest calls `createAccounts()` to create an account
5. **Checkout Process**: Guest uses `checkoutBooks()` to borrow books
6. **Return Process**: Guest can return books using `returnBook()`

## Running the Demo

The system includes `LibraryManagementSystem.java` which demonstrates:
- Creating a library and librarian
- Adding books to inventory
- Creating guest accounts
- Checking out books
- Handling unavailable books
- Returning books
- Viewing guest account information
- Removing books from inventory

**To run:**
```bash
javac *.java
java LibraryManagementSystem
```

## Files Included

1. `Book.java` - Book class
2. `Library.java` - Library management class
3. `GuestAccount.java` - Guest account class
4. `Librarian.java` - Librarian class (includes `addBooks()` and `removeBooks()`)
5. `Guest.java` - Guest class (includes `createAccounts()` and `checkoutBooks()`)
6. `LibraryManagementSystem.java` - Main demonstration program
7. `UML_DIAGRAM.md` - UML class diagram
8. `README.md` - This documentation file

## Compilation Status
✓ All classes compile without errors
✓ Demonstration program executes successfully
✓ All core UML methods functioning as designed
