import java.util.Scanner;

public class PyramidPrintNew {

    public static int input() {
        Scanner input = new Scanner(System.in);         // user inputs how many rows of the pyramid they want
        System.out.println("How many steps of a pyramid do you want?");

        int rows = input.nextInt();

        while (rows <= 0 || rows > 7) {                 // only allows valid inputs above 0 (can't have 0 or negative rows) and sets max to 7 (as specified by the assignment)
            System.out.println("Invalid Input");
            System.out.println("Enter an integer greater than 0 and less than 8");
            rows = input.nextInt();
        }
        return rows;
    }

    public static void output(int rows) {

        String factor = "1";                             // will convert to long and use to multiply by itself to generate the numbers for each row
        String addend = "1";                             // used to increment factor
        String product;                                  // used to output each row

        for (int i = rows; i > 0; i--) {                 // i is step (number of rows) to stop after desired number of rows is output

            for (int x = 1; x <= i * 2; x++) {           // adds spacing on the left side
                System.out.print(" ");
            }

            long numFactor = Long.parseLong(factor);       // creates long from factor to use for multiplication
            numFactor = numFactor * numFactor;             // does the multiplication to create the number palindrome
            product = Long.toString(numFactor);            // converts back to string
            product = product.replace("", " ").trim();          // puts spaces in between each character in the string
            System.out.println(product);

            factor += addend;                              // adds 1 to the previous string to be used in multiplication (ex: factor 11 becomes 111)

        }
    }

    public static void main(String[] args) {

        output(input());                                   // calls method to generate the pyramid with input method to get rows

    }
}
