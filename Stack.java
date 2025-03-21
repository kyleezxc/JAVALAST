public class Stack {
    StackNode head;

    public boolean isEmpty(){
        if(head == null){
            return true;
        }else{
            return false;
        }
    }

    public void storeBook(int bookID, String bookTitle, String bookAuthor, String bookBorrower, String dateBorrowed){
        StackNode newNode = new StackNode(bookID, bookTitle, bookAuthor, bookBorrower, dateBorrowed);

        if(isEmpty()){
            head = newNode;
        }else{
            newNode.next = head;
            head = newNode; 
        }
    }

    

    public void displayHistory(){
        StackNode current = head;

        if(isEmpty()){
            System.out.println("No book borrowed before !");
            return;
        }
        System.out.println("Book Borrowed History");
        while(current != null){
            System.out.println("Book ID       : " + current.bookID + "\nBook Title    : " + current.bookTitle + "\nBook Author   : " + current.bookAuthor + "\nBook Borrower : " 
            + current.bookBorrower + "\nDate Borrowed : " + current.dateBorrowed);
            current = current.next;
        }
    }
}
