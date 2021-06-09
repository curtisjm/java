
import java.sql.*;

import java.util.Scanner;

public class AddressBook {

    private Scanner scan = new Scanner(System.in);
    private String input = "";

//    private final String PASSWORD = "Nelsondog7";
//    private final String URL = "jdbc:mysql://localhost:3306/addressBook";
//    private final String USER = "root";

    private final String PASSWORD = "raks71uyoy7mfo8v";
    private final String URL = "jdbc:mysql://digital-ocean-mysql-do-user-8865550-0.b.db.ondigitalocean.com:25060/addressBook";
    private final String USER = "doadmin";

    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;

    private void loadAddressBook() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch(Exception e) {
            throw e;
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void addContact() throws Exception {
        Contact newContact = new Contact();
        scan.nextLine();

        System.out.println();
        System.out.println("-- Add Contact --");
        System.out.println("What is your contact's first name?");
        input = scan.nextLine();
        newContact.setFirstName(input);
        System.out.println("What is your contact's last name?");
        input = scan.nextLine();
        newContact.setLastName(input);
        System.out.println("What is your contact's address?");
        input = scan.nextLine();
        newContact.setAddress(input);
        System.out.println("What is your contact's phone number?");
        input = scan.nextLine();
        newContact.setPhoneNumber(input);

        try {
            String query = "insert into contacts(firstName, lastName, address, phoneNumber) values(?, ?, ?, ?)";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.setString(1, newContact.getFirstName());
            preparedStatement.setString(2, newContact.getLastName());
            preparedStatement.setString(3, newContact.getAddress());
            preparedStatement.setString(4, newContact.getPhoneNumber());
            preparedStatement.executeUpdate();
            System.out.println("Successfully added this new contact: ");
            System.out.println(newContact);
        } catch(Exception e) {
            System.out.println("Failed to add contact.");
            e.printStackTrace();
        }
        mainMenu();
    }

    private void updateContact() throws Exception {
        System.out.println();
        input = scan.nextLine();
        System.out.println("--- Update Contact ---");
        System.out.println("Enter the phone number of the contact you want to update: ");
        String oldNumber = scan.nextLine();
        Contact updatedContact = new Contact();
        System.out.println("Enter a new first name: ");
        input = scan.nextLine();
        updatedContact.setFirstName(input);
        System.out.println("Enter a new last name: ");
        input = scan.nextLine();
        updatedContact.setLastName(input);
        System.out.println("Enter a new address: ");
        input = scan.nextLine();
        updatedContact.setAddress(input);
        System.out.println("Enter a new phone number: ");
        input = scan.nextLine();
        updatedContact.setPhoneNumber(input);
        try {
            String query = "update contacts " +
                    "set firstName = '" + updatedContact.getFirstName() + "'," +
                    "lastName = '" + updatedContact.getLastName() + "'," +
                    "address = '" + updatedContact.getAddress() + "'," +
                    "phoneNumber = '" + updatedContact.getPhoneNumber() + "'" +
                    "where phoneNumber = '" + oldNumber + "'";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch(Exception e) {
            System.out.println("Failed to update contact.");
        }
        mainMenu();
    }

    private void deleteContact() throws Exception {
        System.out.println();
        System.out.println("--- Delete Contact ---");
        System.out.println("Enter the phone number of the contact you want to delete: ");
        input = scan.next();

        try {
            String query = "delete from contacts where phoneNumber = '" + input + "'";
            preparedStatement = connect.prepareStatement(query);
            preparedStatement.executeUpdate();
            System.out.println("Removed contact with phone number: " + input);
        } catch(Exception e) {
            System.out.println("Failed to delete contact.");
        }
        mainMenu();
    }

    private void listContacts() throws Exception {
        System.out.println();
        System.out.println("--- Your Address Book ---");
        try {
            preparedStatement = connect.prepareStatement("select * from contacts");
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                System.out.println("Name: " + resultSet.getString("firstName") + " " + resultSet.getString("lastName")
                        + "\nAddress: " + resultSet.getString("address")
                        + "\nPhone Number: " + resultSet.getString("phoneNumber"));
                System.out.println();
            }
        } catch(Exception e) {
            System.out.println("Failed to list contacts.");
        }
        mainMenu();
    }

    private void quitProgram() throws Exception {
        System.out.println();
        System.out.println("Quitting program...");
        close();
        System.exit(0);
    }

    private void mainMenu() throws Exception {
        System.out.println();
        System.out.println("--- Main Menu ---");
        System.out.println("Type \"help\" for a list of commands or proceed to a subsequent menu if you already know how.");
        input = scan.next();

        while(!input.equalsIgnoreCase("add") && !input.equalsIgnoreCase("update") && !input.equalsIgnoreCase("delete") && !input.equalsIgnoreCase("list") &&
                !input.equalsIgnoreCase("sample") && !input.equalsIgnoreCase("search") && !input.equalsIgnoreCase("quit")) {
            if(input.equalsIgnoreCase("help")) {
                System.out.println();
                System.out.println("-- Command List --");
                System.out.println("\"add\" - add a new contact to your address book");
                System.out.println("\"update\" - update an existing contact");
                System.out.println("\"delete\" - delete a contact");
                System.out.println("\"list\" - list all contacts in your address book");
                System.out.println("\"search\" - search for a given contact");
                System.out.println("\"sample\" - program will add sample contacts to your address book");
                System.out.println("\"quit\" - ends the program");
            } else {
                System.out.println();
                System.out.println("Invalid input. Type \"help\" for a list of commands.");
            }
            input = scan.next();
        }

        switch(input.toLowerCase()) {
            case "add": addContact();
                break;
            case "update": updateContact();
                break;
            case "delete": deleteContact();
                break;
            case "list": listContacts();
                break;
            case "quit": quitProgram();
                break;
        }
    }

    public static void main(String[] args) throws Exception {
        AddressBook aB = new AddressBook();
        aB.loadAddressBook();
        aB.mainMenu();
    }

}
