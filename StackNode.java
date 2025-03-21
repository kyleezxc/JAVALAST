public class StackNode {
    StackNode next;
    String bookTitle, bookAuthor, bookBorrower, dateBorrowed;
    int bookID;

    StackNode(int bookID, String bookTitle, String bookAuthor, String bookBorrower, String dateBorrowed){
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookBorrower = bookBorrower;
        this.dateBorrowed = dateBorrowed;
        this.next = null;
    }
}
