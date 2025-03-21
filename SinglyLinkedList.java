public class SinglyLinkedList {
   SinglyNode head, tail;
   int size = 0;

   SinglyLinkedList() {
      this.head = null;
      this.tail = null;
   }

   SinglyLinkedList(SinglyNode head, SinglyNode tail) {
      this.head = head;
      this.tail = tail;
   }

   public boolean isEmpty() {
      if (head == null) {
         return true;
      } else {
         return false;
      }
   }

   public void addBook(int bookID, String bookTitle, String bookAuthor) {
      SinglyNode newBook = new SinglyNode(bookID, bookTitle, bookAuthor);
      if (isEmpty()) {
         head = newBook;
         System.out.println("Book '" + bookTitle + "' successfully added.");
         System.out.println("-------------------------------");
         size++;
      } else {
         newBook.next = head;
         head = newBook;
         System.out.println("Book '" + bookTitle + "' successfully added.");
         System.out.println("-------------------------------");
         size++;
      }
   }

   public void displayBook() {

      if (isEmpty()) {
         System.out.println("Library is empty.");
      } else {
         SinglyNode current = head;
         System.out.println("----- Library Information -----");
         while (current != null) {
            System.out.print(
                  "\nID: " + current.bookID + "\nTitle: " + current.bookTitle + "\nAuthor: " + current.bookAuthor
                        + "\n-------------------------------\n");
            current = current.next;
         }
      }
   }

   public boolean searchBook(String title) {
      SinglyNode current = head;

      while (current != null) {
         if (current.bookTitle.equalsIgnoreCase(title)) {
            System.out.println("\n--- Book Found ---");
            System.out.println("Book ID: " + current.bookID + "\nBook Title: " + current.bookTitle + "\nBook Author: "
                  + current.bookAuthor);
            System.out.println("----------------");
            return true;
         }
         current = current.next;
      }
      System.out.println("\n--- Book not Found ---");
      return false;
   }

   public SinglyNode removeBook(String bookTitle) {
      if (head == null) {
         return null;
      }

      if (head.bookTitle.equalsIgnoreCase(bookTitle)) {
         SinglyNode borrowed = head;
         head = head.next;
         return borrowed;
      }

      SinglyNode prev = null, current = head;

      while(current != null && !current.bookTitle.equalsIgnoreCase(bookTitle)){
         prev = current;
         current = current.next;
      }

      if(current == null){
         return null;
      }

      prev.next = current.next;
      return current;
   }
}
