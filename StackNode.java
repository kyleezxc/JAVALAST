import java.time.LocalDate;

public class StackNode {
    StackNode next;
    String bookTitle, bookAuthor, bookBorrower;
    int bookID;
    LocalDate date = LocalDate.now();
    
    StackNode(int bookID, String bookTitle, String bookAuthor, String bookBorrower, LocalDate date){
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookBorrower = bookBorrower;
        this.date = date;
        this.next = null;
    }
}
