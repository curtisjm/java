import java.util.Scanner;

public class Pyramid2 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("How many steps of a pyramid do you want?");

        int count = 1;
        int rows = input.nextInt();

        while (rows <= 0) {
            System.out.println("Invalid Input");
            System.out.println("Enter an integer greater than 0");
            rows = input.nextInt();
        }

        for (int i = rows; i > 0; i--) {

            for (int x = 1; x <= i * 2; x++) {
                System.out.print(" ");
            }

            for (int x = 1; x <= count; x++) {
                System.out.print(x + " ");
            }

            for (int x = count - 1; x >= 1; x--) {
                System.out.print(x + " ");
            }

            System.out.println("");
            count++;

        }

    }
}