import java.util.Scanner;

public class Division {

    public static void main(String[] args) {
        int a, b, result;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter 2 numbers");
        a = input.nextInt();
        b = input.nextInt();

        try {
            result = a / b;
            System.out.println("Result = " + result);
        } catch(ArithmeticException aE) {
            System.out.println(aE.getMessage());
            System.out.println("Exception Caught: Don't divide by 0");
        }

    }
}
