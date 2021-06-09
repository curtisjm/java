package Books;

import java.awt.print.Book;

public class BookMain {
    public static void main(String[] args) {
        MyBook myBook = new MyBook("My Book Title", "John Doe", "1122334455667", 2000);
        System.out.println(myBook);
    }
}