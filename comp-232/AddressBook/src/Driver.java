import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Driver {

    public static ArrayList<Contact> addressBook = new ArrayList<>();
    public static Scanner scan = new Scanner(System.in);
    public static String input = "";
    public static final String DELIMITER = "!";

    // creates a file if this is the first time running the program or initiates the process of loading the stored data
    private static void createFile() {
        try {
            File myFile = new File("AddressBook.txt");
            if(myFile.createNewFile()) {
                System.out.println();
                System.out.println("Welcome to this address book program!");
                System.out.println("** New address book created for you **");
            } else {
                loadAddressBook();
                System.out.println();
                System.out.println("Welcome back to your address book!");
                System.out.println("** Loaded address book from file **");
            }
        } catch(IOException ioE) {
            System.out.println();
            System.out.println("Error creating file");
            System.out.println(ioE.getMessage());
        }
    }

    // used on end to store all values from the addressBook array list in the file
    // will overwrite everything previously stored in the file
    private static void storeAddressBook() throws IOException {
        Collections.sort(addressBook);
        FileWriter fw = new FileWriter("AddressBook.txt");
        PrintWriter pw = new PrintWriter(fw);
        pw.write("\n");
        for(Contact cont : addressBook) {
            pw.write(cont.getFirstName() + DELIMITER);
            pw.write(cont.getLastName() + DELIMITER);
            pw.write(cont.getAddress() + DELIMITER);
            pw.write(cont.getPhoneNumber() + "");
            pw.write("\n");
        }
        pw.close();
    }

    // used on start (assuming the address book already exists) to get all contacts from the file and store them in the addressBook array list
    private static void loadAddressBook() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("AddressBook.txt"));
            String line = "";
            br.readLine();

            while((line = br.readLine()) != null) {
                String[] contactDetails = line.split(DELIMITER);
                if(contactDetails.length > 0) {
                    Contact loadContact = new Contact(contactDetails[0], contactDetails[1], contactDetails[2], contactDetails[3]);
                    addressBook.add(loadContact);
                }
            }
        } catch (Exception e) {
            System.out.println("here");
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

    // create a new contact object and add it to the addressBook array list
    private static void addContact() throws IOException {
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
    private static void updateContact() throws IOException {
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
    private static void deleteContact() throws IOException {
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
    private static void listContacts() throws IOException {
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
    private static void searchForContact() throws IOException {
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
    private static void sampleContacts() throws IOException {
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
    private static void quitProgram() throws IOException {
        System.out.println();
        System.out.println("Quitting program...");
        storeAddressBook();
        System.exit(0);
    }

    // used to navigate between different submenus and perform different operations
    private static void mainMenu() throws IOException {
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

    // creates or loads a new file, then takes users to the main menu
    public static void main(String[] args) throws IOException {
        createFile();
        mainMenu();
    }

}
