import java.util.Scanner;

public class test {

    public static void output(int rows) {
        int count = 1;
        String factor = "1";
        String addends = "1";

        for (int x = 1; x <= count; x++) {
            int numFactor = Integer.parseInt(factor);
            numFactor = numFactor * numFactor;
            System.out.println(numFactor + " ");
            count++;
            factor += addends;
        }
/*
        for (int i = rows; i > 0; i--) {                 // i is step (number of rows)

            for (int x = 1; x <= i * 2; x++) {
                System.out.print(" ");
            }

            for (int x = 1; x <= count; x++) {
                int numFactor = Integer.parseInt(factor);
                numFactor = numFactor * numFactor;
                System.out.println(numFactor + " ");
            }

            System.out.println("");                    // move to next line so each layer is stacked

            count++;                                   // increment number on row
            factor += addends;

        }

 */
    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("How many steps of a pyramid do you want?");

        int rows = input.nextInt();

        while (rows <= 0 || rows > 7) {
            System.out.println("Invalid Input");
            System.out.println("Enter an integer greater than 0 and less than 8");
            rows = input.nextInt();
        }
        output(rows);

    }
}
