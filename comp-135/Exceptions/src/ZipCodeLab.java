import java.io.*;
import java.util.Scanner;

public class ZipCodeLab {

    public static boolean isValidZip(String zip) {
        if (zip.length() != 6)
            return false;
        if(zip.charAt(5) != 'E' && zip.charAt(5) != 'S')
            return false;
        try {
            zip = zip.substring(0,zip.length()-1);
            Integer.parseInt(zip);
            return true;
        } catch (NumberFormatException nf) {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter a zip code with a valid shipping code at the end or type \"quit\" to end program");
        Scanner input = new Scanner(System.in);
        File myFile = new File("zips.txt");
        String in = input.next();
        int validZipCount = 0;
        int invalidZipCount = 0;
        try {
            myFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;

        while(!in.equals("quit")) {
            if(isValidZip(in)) {
                validZipCount++;
                try {
                    fw = new FileWriter(myFile, true);
                    bw = new BufferedWriter(fw);
                    pw = new PrintWriter(bw);

                    pw.println(in);

                    System.out.println(in + " Successfully added to your list of zip codes");
                    pw.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        assert pw != null;
                        pw.close();
                        bw.close();
                        fw.close();
                    } catch (IOException ignored) {
                    }
                }
            } else {
                invalidZipCount++;
                System.out.println("Invalid Zip Code");
                System.out.println("Input has to be a string of five integers followed by \"E\" or \"S\"");
            }
            in = input.next();
        }
        System.out.println("Valid Zip Codes Added: " + validZipCount);
        System.out.println("Invalid Zip Code Attempts: " + invalidZipCount);
    }
}
