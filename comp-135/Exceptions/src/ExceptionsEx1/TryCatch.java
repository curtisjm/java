package ExceptionsEx1;

import java.util.Scanner;

public class TryCatch {

    public static void main(String[] args) {
        int a, b, result;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter two numbers...");
        a = input.nextInt();
        b = input.nextInt();

        // before
        //result = a / b;
        //System.out.println(result);

        // after learning about exceptions
        try {       // tries code
            result = a / b;
            System.out.println(result);
        } catch(ArithmeticException e) {    // if finds exception
            System.out.println(e.getMessage());
            System.out.println("You can't divide by 0");
        }
    }
}
