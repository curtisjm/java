package Books;

public class MyBook {
    private String bookTitle;
    private String bookAuthor;
    private String bookIsbnCode;
    private int bookPublicationYear;

    public MyBook(String title, String author, String isbn, int year) {
        bookTitle = title;
        bookAuthor = author;
        bookIsbnCode = isbn;
        bookPublicationYear = year;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public String getBookIsbnCode() {
        return bookIsbnCode;
    }

    public int getBookPublicationYear() {
        return bookPublicationYear;
    }

    public void setBookTitle(String newTitle) {
        bookTitle = newTitle;
    }

    public void setBookAuthor(String newAuthor) {
        bookAuthor = newAuthor;
    }

    public void setBookIsbnCode(String newIsbn) {
        bookIsbnCode = newIsbn;
    }

    public void setBookPublicationYear(int newYear) {
        bookPublicationYear = newYear;
    }


    public String toString() {
        return "Title: " + bookTitle + "\nAuthor: " + bookAuthor + "\nISBN Code: " + bookIsbnCode + "\nPublication Year: " + bookPublicationYear;
    }
}