package com.example.AddressBookIVService;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;

public class MySQL {

    private final String PASSWORD = "Nelsondog7";
    private final String URL = "jdbc:mysql://localhost:3306/addressBook";
    private final String USER = "root";

    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;

    private Gson gson = new Gson();

    private static MySQL instance = new MySQL();

    private MySQL() {
        loadAddressBook();
    }

    public static MySQL getInstance() {
        return instance;
    }

    private void loadAddressBook() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String makeList() {
        ArrayList<Contact> contacts = new ArrayList<>();
        try {
            preparedStatement = connect.prepareStatement("select * from addressBook.contacts");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                contacts.add(new Contact(resultSet.getString("firstName"), resultSet.getString("lastName"), resultSet.getString("address"), resultSet.getString("phoneNumber")));
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return gson.toJson(contacts);
    }

    public void addContact(String json) {
        Contact newContact = gson.fromJson(json, Contact.class);
        try {
            String query = "insert into addressbook.contacts(firstName, lastName, address, phoneNumber) values(?, ?, ?, ?)";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, newContact.getFirstName());
            preparedStatement.setString(2, newContact.getLastName());
            preparedStatement.setString(3, newContact.getAddress());
            preparedStatement.setString(4, newContact.getPhoneNumber());
            preparedStatement.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteContact(String json) {
        Contact oldContact = gson.fromJson(json, Contact.class);
        try {
            String query = "delete from addressbook.contacts where phoneNumber = '" + oldContact.getPhoneNumber() + "'";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void updateContact(String json) {
        Type contactListType = new TypeToken<ArrayList<Contact>>(){}.getType();
        ArrayList<Contact> contacts = gson.fromJson(json, contactListType);
        try {
            String query = "update addressbook.contacts " +
                    "set firstName = '" + contacts.get(1).getFirstName() + "'," +
                    "lastName = '" + contacts.get(1).getLastName() + "'," +
                    "address = '" + contacts.get(1).getAddress() + "'," +
                    "phoneNumber = '" + contacts.get(1).getPhoneNumber() + "'" +
                    "where phoneNumber = '" + contacts.get(0).getPhoneNumber() + "'";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
