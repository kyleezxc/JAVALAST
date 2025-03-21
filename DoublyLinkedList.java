public class DoublyLinkedList {
    DoublyNode head, tail;

    DoublyLinkedList() {
        this.head = tail = null;
    }

    DoublyLinkedList(DoublyNode head, DoublyNode tail) {
        this.head = head;
        this.tail = tail;
    }

    // for checking if the list is empty
    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    // for borrowing books, will call out the values stored on the singly node named book
    public void borrowBook(SinglyNode book) {
        
        // will check out if the book(singly) is empty or not
        if (book == null) {
            System.out.println("Book not available for borrowing !");
            return;
        }

        // if the book(singly linked list) is not empty it will check the doubly if it is empty or not
        if (head == null) {
            // if the doubly is empty, it will create a new node with prev and next refernce has null data
            DoublyNode newBook = new DoublyNode(null, book.bookID, book.bookTitle, book.bookAuthor, null);
            head = newBook;
        } else {
            // if the doubly is not empty, will create a new node that the prev has null data and the next
            // reference will point out to the head, and sets the new node as the new head
            DoublyNode newBook = new DoublyNode(null, book.bookID, book.bookTitle, book.bookAuthor, head);
            head = newBook;
        }
        System.out.println("\nBook Borrowed: " + book.bookTitle);
    }

    // method for return book with the return type singly node (singly linked list)
    // because the book borrowed should be stored back in singly linked list
    public SinglyNode returnBook(String bookTitle) {
        if (head == null) {
            System.out.println("No books currently borrowed.");
            return null;
        }

        // creates a new reference variable to traverse on the current borrowed list (doubly)
        // and checks if the list is not empty and the current book title is similar with the user's given title
        DoublyNode current = head;
        while (current != null && !current.bookTitle.equalsIgnoreCase(bookTitle)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Book not found in the borrower's list.");
            return null;
        }

        if (current.prev != null) {
            current.prev.next = current.next;
        }
        if (current.next != null) {
            current.next.prev = current.prev;
        }
        if (current == head) {
            head = current.next;
        }

        // will return the book information that the user is looking for.
        return new SinglyNode(current.bookID, current.bookTitle, current.bookTitle);
    }

    // public void displayBorrowedBook() {
    //     if (head == null) {
    //         System.out.println("No books currently borrowed.");
    //         return;
    //     }

    //     DoublyNode current = head;
    //     System.out.println("--- Borrowed Books ----");
    //     while (current != null) {
    //         System.out.println("ID: " + current.bookID + "\nTitle: " + current.bookTitle + "\nAuthor: "
    //                 + current.bookAuthor + "\n-------------------------------\n");
    //         current = current.next;
    //     }
    // }
}
