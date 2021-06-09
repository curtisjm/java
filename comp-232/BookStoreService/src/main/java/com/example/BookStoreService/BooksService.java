package com.example.BookStoreService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


import com.google.gson.Gson;


import java.sql.*;
import java.util.ArrayList;


@Path("/books")
public class BooksService {

    private final String PASSWORD = "Nelsondog7";
    private final String URL = "jdbc:mysql://localhost:3306/BookStore";
    private final String USER = "root";

    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;

    private ArrayList<Book> books = new ArrayList<>();

    private void loadBooks() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connect.createStatement();
            preparedStatement = connect.prepareStatement("select * from BookStore.books");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                books.add(new Book(resultSet.getString("title"), resultSet.getString("author"), resultSet.getString("isbn"),
                        resultSet.getString("url"), resultSet.getDouble("price")));
            }
        } catch(Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    private void close() {
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
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @GET
    @Produces("application/json")
    public Response makeArray() throws Exception {
        loadBooks();
        Gson gson = new Gson();
        String json = "\"books\":" + gson.toJson(books);
        return Response.status(200).entity(json).build();
    }
}
