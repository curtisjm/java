package DataExtractor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Parser {

    private static Connection connect = null;
    private static Statement statement = null;
    private static ResultSet resultSet = null;
    private static PreparedStatement preparedStatement = null;

    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\curti\\Desktop\\books.csv"));
            List<Book> bookList = new ArrayList<>();

            String line = "";
            br.readLine();

            while((line = br.readLine()) != null) {
                String[] bookDetails = line.split(COMMA_DELIMITER);
                try {
                    if(bookDetails.length > 0) {
                        Book book = new Book(bookDetails[0], bookDetails[1], Double.parseDouble(bookDetails[2]), Integer.parseInt(bookDetails[3]), Double.parseDouble(bookDetails[4]), Integer.parseInt(bookDetails[5]), bookDetails[6]);
                        bookList.add(book);
                    }
                } catch (Exception e) {
                    int pos2 = line.lastIndexOf("\"") + 2;
                    String tempName = line.substring(0, pos2);
                    line = line.substring(pos2);
                    String[] bookDetails2 = line.split(COMMA_DELIMITER);
                    Book book = new Book(tempName, bookDetails2[0], Double.parseDouble(bookDetails2[1]), Integer.parseInt(bookDetails2[2]), Double.parseDouble(bookDetails2[3]), Integer.parseInt(bookDetails2[4]), bookDetails2[5]);
                    bookList.add(book);
                }
            }

            for(Book b : bookList) {
                readDB(b);
            }

            getFromDB();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException ioE) {
                System.out.println("Error occurred while closing the Buffered Reader");
                ioE.printStackTrace();
            }
        }
    }

    private static void close() {
        try {
            if(resultSet != null) {
                resultSet.close();
            }
            if(statement != null) {
                statement.close();
            }
            if(connect != null) {
                connect.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readDB(Book book) throws Exception {
        try {
            // loads the MySQL driver into out program
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/booksCSV","root","Nelsondog7");
            statement = connect.createStatement();
            resultSet = statement.executeQuery("select * from booksCSV.books");

            // add books to table
            preparedStatement = connect.prepareStatement("insert into booksCSV.books values(default, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, book.getName());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setDouble(3, book.getUserRating());
            preparedStatement.setInt(4, book.getReviews());
            preparedStatement.setDouble(5, book.getPrice());
            preparedStatement.setInt(6, book.getYear());
            preparedStatement.setString(7, book.getGenre());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    private static void getFromDB() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/booksCSV", "root", "Nelsondog7");
        statement = connect.createStatement();

        preparedStatement = connect.prepareStatement("select * from booksCSV.books");
        resultSet = preparedStatement.executeQuery();
        top5(getBookList(resultSet));
    }

    private static ArrayList<Book> getBookList(ResultSet resultSet) throws SQLException {
        ArrayList<Book> bookList = new ArrayList<>();
        while(resultSet.next()) {
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            double userRating = resultSet.getDouble("userRating");
            int reviews = resultSet.getInt("reviews");
            double price = resultSet.getDouble("price");
            int yearPublished = resultSet.getInt("yearPublished");
            String genre = resultSet.getString("genre");
            bookList.add(new Book(title, author, userRating, reviews, price, yearPublished, genre));
        }
        return bookList;
    }

    private static void top5(ArrayList<Book> bookList) {
        Collections.sort(bookList);
        System.out.println("-- Top 5 Books --");
        for(int i=0; i<=5; i++) {
            System.out.println(bookList.get(i));
        }

        Book[] fictionTop5 = new Book[5];
        int fictionCount = 0;
        Book[] nonFictionTop5 = new Book[5];
        int nonFictionCount = 0;
        for(Book b : bookList) {
            if(b.getGenre().equalsIgnoreCase("fiction") && fictionCount < 5) {
                fictionTop5[fictionCount] = b;
                fictionCount++;
            } else if(b.getGenre().equalsIgnoreCase("non fiction") && nonFictionCount < 5) {
                nonFictionTop5[nonFictionCount] = b;
                nonFictionCount++;
            }
            if(fictionCount == 5 && nonFictionCount == 5) {
                break;
            }
        }

        System.out.println();
        System.out.println("-- Top 5 in Fiction --");
        System.out.println(Arrays.toString(fictionTop5));
        System.out.println();
        System.out.println("-- Top 5 in Non Fiction --");
        System.out.println(Arrays.toString(nonFictionTop5));
        System.out.println();
        System.out.println("-- MVP Author --");
        System.out.println(bookList.get(0).getAuthor());
    }
}
