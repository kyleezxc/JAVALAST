// Coded By: BISAYA CODERS TOO
// Done By: 03/21/2025

import java.time.LocalDate;
import java.util.*;

public class LibraryManagementSystem {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);

      SinglyLinkedList bookList = new SinglyLinkedList();
      DoublyLinkedList borrowList = new DoublyLinkedList();
      Stack borrowedHistory = new Stack();
      LocalDate date = LocalDate.now();

      int option, bookID;
      String bookTitle, bookAuthor, bookBorrower;

      while (true) {
         try {
            Menu();
            System.out.print(">> ");
            option = scan.nextInt();
            scan.nextLine();
            switch (option) {
               case 1:
                  System.out.println("-------------------------------");
                  System.out.print("Enter Book ID: ");
                  bookID = scan.nextInt();
                  scan.nextLine();
                  System.out.print("Enter Book Title: ");
                  bookTitle = scan.nextLine();
                  System.out.print("Enter Book Author: ");
                  bookAuthor = scan.nextLine();
                  bookList.addBook(bookID, bookTitle, bookAuthor);
                  break;

               case 2:
                  System.out.println("-------------------------------");
                  bookList.displayBook();
                  break;

               case 3:
                  System.out.println("-------------------------------");
                  System.out.print("Enter Book Title to Search: ");
                  bookTitle = scan.nextLine();
                  bookList.searchBook(bookTitle);
                  break;

               case 4:
                  System.out.println("-------------------------------");
                  // checks if the singly is empty or not
                  if (bookList.isEmpty()) {
                     System.out.println("Library is empty, book not found !");
                     break;
                  }
                  System.out.print("Enter Book Title to Borrow: ");
                  bookTitle = scan.nextLine();

                  // initialize singly node to store the removed book from the list
                  SinglyNode borrowed = bookList.removeBook(bookTitle);
                  if (borrowed == null) {
                     System.out.println("Book not found!");
                  } else {
                     System.out.print("Enter Book's Borrower: ");
                     bookBorrower = scan.nextLine();
                     // after getting user input, the data that is in borrowed node will be passed to the 
                     // borrow list (Doubly)
                     borrowList.borrowBook(borrowed);

                     // will also store the data's in book borrowed history(stack)
                     borrowedHistory.storeBook(borrowed.bookID, borrowed.bookTitle, borrowed.bookAuthor, bookBorrower, date);
                  }
                  break;

               case 5:
                  System.out.println("-------------------------------");
                  System.out.print("Enter Book Title: ");
                  bookTitle = scan.nextLine();
                  // initialize return variable (node) for storing the book information from borrow list (doubly)
                  // to the singly (returned node)
                  SinglyNode returned = borrowList.returnBook(bookTitle);
                  if (returned != null) {
                     bookList.addBook(returned.bookID, returned.bookTitle, returned.bookAuthor);
                  }
                  break;

               case 6:
                  System.out.println("-------------------------------");
                  borrowedHistory.displayHistory();
                  break;

               case 7:
                  System.out.println("-------------------------------");
                  System.out.println("Exiting program...");
                  return;

               default:
                  System.out.println("-------------------------------");
                  System.out.println("Invalid Choice, Try Again!");
            }
         } catch (InputMismatchException e) {
            System.out.println("-------------------------------");
            System.out.println("Invalid Input Type, Please Try Again :)");
            scan.nextLine();
         }
      }
   }

   // Memu for Menu Selection
   public static void Menu() {
      System.out.println("\n--- Menu Library System ---");
      System.out.println("1. Add Book (Singly)");
      System.out.println("2. Display Book Available (Singly)");
      System.out.println("3. Search Book (Singly)");
      System.out.println("4. Borrow Book (Doubly)");
      System.out.println("5. Return Book (Doubly)");
      System.out.println("6. Track Borrow History (Stack)");
      System.out.println("7. Exit");
   }
}
