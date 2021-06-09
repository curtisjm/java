package CE;

import java.util.Scanner;

public class CodeEntry {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean keepGoing = true;
        int numValid = 0;
        int numInvalid = 0;

        while(keepGoing) {
            System.out.println("Enter a zip code followed by a \"S\" or \"E\". Enter \"Q\" to quit.");
            String userInput = scan.nextLine();

            if(userInput.equalsIgnoreCase("q")) {
                keepGoing = false;
            } else {
                try {
                    String zipCodeString = userInput.substring(0,5);
                    int zipCode = Integer.parseInt(zipCodeString);
                    String shippingSpeedString = userInput.substring(5,6);
                    System.out.println("Shipping to " + zipCode);

                    if(zipCode >= 90000) {
                        System.out.println("\tShipping out West");
                    }
                    if(shippingSpeedString.equalsIgnoreCase("S")) {
                        System.out.println("\tStandard shipping speed");
                    } else if(shippingSpeedString.equalsIgnoreCase("E")) {
                        System.out.println("\tExpedited shipping speed");
                    } else {
                        // error has happened
                        throw new InvalidShippingCodeException();
                    }
                    numValid++;
                } catch(NumberFormatException e) {
                    System.out.println("Zip code is not numeric. Try again.");
                    numInvalid++;
                } catch(StringIndexOutOfBoundsException e) {
                    System.out.println("Input too shot. Try again.");
                    numInvalid++;
                } catch(InvalidShippingCodeException e) {
                    System.out.println("Invalid shipping speed code. Try again.");
                    numInvalid++;
                } finally {
                    System.out.println(numValid + " valid and " + numInvalid + " invalid codes entered.");
                }
            }

        }
    }
}
