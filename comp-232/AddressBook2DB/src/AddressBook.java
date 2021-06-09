
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class AddressBook {

    private ArrayList<Contact> addressBook = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);
    private String input = "";

    // change the value of PASSWORD to the password to your MySQL database
    private final String PASSWORD = "Nelsondog7";
    // change URL and USER if you have different ones
    private final String URL = "jdbc:mysql://localhost:3306/addressBook";
    private final String USER = "root";
    // you will also need to change the queries if you have different titles for your database and table

    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement = null;

    // used on start to get all contacts from the database and store them in the addressBook array list
    private void loadAddressBook() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connect.createStatement();
            preparedStatement = connect.prepareStatement("select * from addressBook.contacts");
            resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                addressBook.add(new Contact(resultSet.getString("firstName"), resultSet.getString("lastName"), resultSet.getString("address"), resultSet.getString("phoneNumber")));
            }

        } catch(Exception e) {
            throw e;
        } finally {
            close();
        }
    }

    // used on end to store all values from the addressBook arrayList in the database
    // will first erase past stored data, then replace it with what is in the arraylist
    private void storeAddressBook() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connect.createStatement();
            preparedStatement = connect.prepareStatement("TRUNCATE TABLE contacts");
            preparedStatement.executeUpdate();

            String query = "insert into contacts(firstName, lastName, address, phoneNumber) values(?, ?, ?, ?)";
            for(Contact c : addressBook) {
                preparedStatement = connect.prepareStatement(query);
                preparedStatement.setString(1, c.getFirstName());
                preparedStatement.setString(2, c.getLastName());
                preparedStatement.setString(3, c.getAddress());
                preparedStatement.setString(4, c.getPhoneNumber());
                preparedStatement.executeUpdate();
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
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // create a new contact object and add it to the addressBook array list
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

        addressBook.add(newContact);
        System.out.println("Successfully added this new contact: ");
        System.out.println(newContact);
        mainMenu();
    }

    // allows users to modify a contact already stored
    private void updateContact() throws Exception {
        System.out.println();
        System.out.println("--- Update Contact ---");
        System.out.println("Enter the number corresponding to the contact you want to update. " +
                "If you do not know this number, go back to the main menu by typing \"back\" and use the list command.");
        input = scan.next();

        while(!input.equalsIgnoreCase("back") && (Integer.parseInt(input) < 1 || Integer.parseInt(input) > addressBook.size())) {
            if(Integer.parseInt(input) < 1 || Integer.parseInt(input) > addressBook.size()) {
                System.out.println("Number does not correspond to one of your contacts. Please check your address book and try again.");
            } else {
                System.out.println("Invalid input. Type \"back\" to go back to the main menu or enter the number that corresponds to the contact you want to delete.");
            }
            input = scan.next();
        }

        int contactIndex = Integer.parseInt(input) - 1;
        System.out.println();
        System.out.println(addressBook.get(contactIndex));

        boolean cont = true;
        while(cont) {
            System.out.println("What would you like to change about this contact? Enter \"first\" for first name, \"last\" for last name, \"address\", or \"phone\" for phone number.");
            input = scan.next();

            while(!input.equalsIgnoreCase("first") && !input.equalsIgnoreCase("last") && !input.equalsIgnoreCase("address") && !input.equalsIgnoreCase("phone")) {
                System.out.println("Invalid Input. Enter \"first\" for first name, \"last\" for last name, \"address\", or \"phone\" for phone number.");
                input = scan.next();
            }

            switch(input) {
                case "first":
                    input = scan.nextLine();
                    System.out.println("Enter a new first name:");
                    input = scan.nextLine();
                    addressBook.get(contactIndex).setFirstName(input);
                    System.out.println("First name updated.");
                    break;
                case "last":
                    input = scan.nextLine();
                    System.out.println("Enter a new last name:");
                    input = scan.nextLine();
                    addressBook.get(contactIndex).setLastName(input);
                    System.out.println("Last name updated.");
                    break;
                case "address":
                    input = scan.nextLine();
                    System.out.println("Enter a new address:");
                    input = scan.nextLine();
                    addressBook.get(contactIndex).setAddress(input);
                    System.out.println("Address updated.");
                    break;
                case "phone":
                    input = scan.nextLine();
                    System.out.println("Enter a new phone number:");
                    input = scan.nextLine();
                    addressBook.get(contactIndex).setPhoneNumber(input);
                    System.out.println("Phone number updated.");
                    break;
            }

            System.out.println("Would you like to update another aspect of this contact? Enter \"yes\" or \"no\"");
            input = scan.next();
            while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no")) {
                System.out.println("Invalid input. Enter \"yes\" or \"no\"");
                input = scan.next();
            }

            if(input.equalsIgnoreCase("no")) {
                System.out.println("Updated contact:");
                System.out.println(addressBook.get(contactIndex));
                cont = false;
                mainMenu();
            }
        }
    }

    // remove a given contact from the array list, will be removed from the file once the data is persisted
    private void deleteContact() throws Exception {
        System.out.println();
        System.out.println("--- Delete Contact ---");
        System.out.println("Enter the number corresponding to the contact you want to delete. " +
                "If you do not know this number, go back to the main menu by typing \"back\" and use the list command.");
        input = scan.next();

        while(!input.equalsIgnoreCase("back") && (Integer.parseInt(input) < 1 || Integer.parseInt(input) > addressBook.size())) {
            if(Integer.parseInt(input) < 1 || Integer.parseInt(input) > addressBook.size()) {
                System.out.println("Number does not correspond to one of your contacts. Please check your address book and try again. Type \"back\" to return to the main menu or enter a new number.");
            } else {
                System.out.println("Invalid input. Type \"back\" to go back to the main menu or enter the number that corresponds to the contact you want to delete.");
            }
            input = scan.next();
        }

        if(input.equalsIgnoreCase("back")) {
            mainMenu();
        }

        addressBook.remove(Integer.parseInt(input) - 1);
        System.out.println("Removed contact number " + input);
        mainMenu();
    }

    // prints all contacts in the array list
    private void listContacts() throws Exception {
        if(addressBook.isEmpty()) {
            System.out.println();
            System.out.println("--- Your Address Book ---");
            System.out.println("** Your address book is empty **");
        } else {
            Collections.sort(addressBook);
            int i = 1;
            System.out.println();
            System.out.println("--- Your Address Book ---");
            for(Contact cont : addressBook) {
                System.out.println("(" + i + ")");
                System.out.println(cont);
                System.out.println();
                i++;
            }
        }
        mainMenu();
    }

    // search for a contact based on the characteristic given by the user
    private void searchForContact() throws Exception {
        System.out.println("--- Search For Contact ---");
        System.out.println("What characteristic would you like to search by? Enter \"first\" for first name, \"last\" for last name, \"address\", or \"phone\" for phone number.");
        input = scan.next();

        while(!input.equalsIgnoreCase("first") && !input.equalsIgnoreCase("last") && !input.equalsIgnoreCase("address") && !input.equalsIgnoreCase("phone")) {
            System.out.println("Invalid Input. Enter \"first\" for first name, \"last\" for last name, \"address\", or \"phone\" for phone number.");
            input = scan.next();
        }

        switch(input) {
            case "first":
                input = scan.nextLine();
                System.out.println("Enter a first name to search by:");
                input = scan.nextLine();
                System.out.println();
                System.out.println("Results found:");
                for(Contact cont : addressBook) {
                    if(cont.getFirstName().equalsIgnoreCase(input)) {
                        System.out.println(cont);
                        System.out.println();
                    }
                }
                break;
            case "last":
                input = scan.nextLine();
                System.out.println("Enter a last name to search by:");
                input = scan.nextLine();
                System.out.println();
                System.out.println("Results found:");
                for(Contact cont : addressBook) {
                    if(cont.getLastName().equalsIgnoreCase(input)) {
                        System.out.println(cont);
                        System.out.println();
                    }
                }
                break;
            case "address":
                input = scan.nextLine();
                System.out.println("Enter an address to search by:");
                input = scan.nextLine();
                System.out.println();
                System.out.println("Results found:");
                for(Contact cont : addressBook) {
                    if(cont.getAddress().equalsIgnoreCase(input)) {
                        System.out.println(cont);
                        System.out.println();
                    }
                }
                break;
            case "phone":
                input = scan.nextLine();
                System.out.println("Enter a phone number to search by:");
                input = scan.nextLine();
                System.out.println();
                System.out.println("Results found:");
                for(Contact cont : addressBook) {
                    if(cont.getPhoneNumber().equalsIgnoreCase(input)) {
                        System.out.println(cont);
                        System.out.println();
                    }
                }
                break;
        }
        mainMenu();
    }

    // allows a new user to add some sample contacts to their address book without having to enter information
    private void sampleContacts() throws Exception {
        addressBook.add(new Contact("Google", "HQ", "1600 Amphitheatre Parkway", "1-866-246-6453"));
        addressBook.add(new Contact("Amazon", "HQ2", "410 Terry Ave", "1 (888) 280-4331"));
        addressBook.add(new Contact("Microsoft", "Visitor Center", "15010 NE 36th, St. Redmond, WA 98052, US.", "1-425-882-8080"));
        addressBook.add(new Contact("Apple", "Park", "One Apple Park Way, Cupertino, CA 95014", "+1 (408) 996-1010"));
        addressBook.add(new Contact("Facebook", "Headquarters", "1 Hacker Way, Menlo Park, CA 94205", "1-650-308-7300"));
        System.out.println();
        System.out.println("** Added sample contacts to your address book **");
        mainMenu();
    }

    // begins the process of persisting the data stored in the array list and ends the program
    private void quitProgram() throws Exception {
        System.out.println();
        System.out.println("Quitting program...");
        storeAddressBook();
        System.exit(0);
    }

    // used to navigate between different submenus and perform different operations
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

        switch (input.toLowerCase()) {
            case "add": addContact();
                break;
            case "update": updateContact();
                break;
            case "delete": deleteContact();
                break;
            case "list": listContacts();
                break;
            case "search": searchForContact();
                break;
            case "sample": sampleContacts();
                break;
            case "quit": quitProgram();
                break;
        }
    }

    // loads contacts from the database, then takes users to the main menu
    public static void main(String[] args) throws Exception {
        AddressBook aB = new AddressBook();
        aB.loadAddressBook();
        aB.mainMenu();
    }

}
