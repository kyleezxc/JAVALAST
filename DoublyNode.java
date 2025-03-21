public class DoublyNode {
    DoublyNode next, prev;
    String bookTitle, bookAuthor;
    int bookID;

    DoublyNode(DoublyNode prev, int bookID, String bookTitle, String bookAuthor, DoublyNode next){
        this.prev = prev;
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.next = next;
    }
}
