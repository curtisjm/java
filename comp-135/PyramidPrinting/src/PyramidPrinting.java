import java.util.Scanner;

public class PyramidPrinting {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("How many steps of a pyramid do you want?");

        int count = 1;                                  // start at one so you can keep adding 1 as you go across
        int rows = input.nextInt();                     // number of rows in the pyramid

        if(rows <= 0) {                                 // in case input is <= 0
            System.out.println("Invalid Input");
            System.out.println("Enter an integer greater than 0");
        }

        for(int i = rows; i > 0; i--) {                 // i is step (number of rows)

           for(int x = 1; x <= i*2; x++) {              // left side spaces
                System.out.print(" ");                  // use print, not println, to not have one number per line
            }

            for(int x = 1; x <= count; x++) {           // left side numbers + space
                System.out.print(x + " ");
            }

            for(int x = count - 1; x >= 1; x--) {       // right side numbers + space
                System.out.print(x + " ");
            }

            System.out.println("");                    // move to next line so each layer is stacked
            count++;                                   // increment number on row

        }

    }
}
