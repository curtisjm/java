package Lab.LabPt3B;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Lab.LabPt3A.User;

public class UserDataRead2 {

    public static ArrayList<User> users = new ArrayList<User>();
    public static final String COMMA_DELIMITER = ",";

    private static void loadUsers() {
        System.out.println();
        System.out.println("Loading users...");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("userdata.csv"));
            String line = "";
            br.readLine();

        while((line = br.readLine()) != null) {
            String[] userDetails = line.split(COMMA_DELIMITER);
            if(userDetails.length > 0) {
                User u = new User(userDetails[0], userDetails[1], userDetails[2], userDetails[3]);
                users.add(u);
            }
        }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch(IOException ioE) {
                System.out.println("An error occurred while closing the buffered reader");
                ioE.printStackTrace();
            }
        }
    }

    private static void printUsers() {
        System.out.println();
        System.out.println("Users:");
        for(User u : users) {
            System.out.println(u);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        loadUsers();
        printUsers();
    }
    
}
