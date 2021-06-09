package DataExtractor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.sql.*;

private Connection connect = null;
private Statement statement = null;
private ResultSet resultSet = null;
private PreparedStatement preparedStatement = null;

public class Parser {

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
}
