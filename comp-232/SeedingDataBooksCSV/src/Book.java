
public class Book implements Comparable<Book> {

    private String name;
    private String author;
    private double userRating;
    private int reviews;
    private double price;
    private int year;
    private String genre;

    public Book(String name, String author, double userRating, int reviews, double price, int year, String genre) {
        this.name = name;
        this.author = author;
        this.userRating = userRating;
        this.reviews = reviews;
        this.price = price;
        this.year = year;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public double getUserRating() {
        return userRating;
    }
    public void setUserRating(double userRating) {
        this.userRating = userRating;
    }
    public int getReviews() {
        return reviews;
    }
    public void setReviews(int reviews) {
        this.reviews = reviews;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        String s = "\nName: " + name;
        s += "\nAuthor: " + author;
        s += "\nUser Rating: " + userRating;
        s += "\nReviews: " + reviews;
        s += "\nPrice: $" + price;
        s += "\nYear: " + year;
        s += "\nGenre: " + genre;
        return s;
    }

    @Override
    public int compareTo(Book otherBook) {
        if (userRating < otherBook.userRating) {
            return 1;
        } else if (userRating > otherBook.userRating) {
            return -1;
        } else {
            return 0;
        }
    }
}
