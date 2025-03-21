public class SinglyNode {
   SinglyNode next;
   String bookTitle, bookAuthor;
   int bookID;

   SinglyNode(int bookID, String bookTitle, String bookAuthor) {
      this.bookID = bookID;
      this.bookTitle = bookTitle;
      this.bookAuthor = bookAuthor;
      next = null;
   }
}
