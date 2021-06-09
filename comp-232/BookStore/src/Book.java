
public class Book {

    private String title, author, isbn, urlToImage;
    private double price;

    public Book(String title, String author, String isbn, String urlToImage, double price) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.urlToImage = urlToImage;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String name) {
        this.title = name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getUrlToImage() {
        return urlToImage;
    }
    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Title: " + title +
            "\nAuthor: " + author +
            "\nISBN: " + isbn +
            "\nImage: " + urlToImage +
            "\nPrice: $" + price;
    }
}
