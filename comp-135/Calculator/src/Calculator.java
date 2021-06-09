import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        Scanner operation = new Scanner(System.in);

        System.out.println("What operation would you like to do?");             // all of the inputs
        System.out.println("(Enter +, -, *, /, square, cube, or exponent)");
        String op = operation.next();
        Scanner input = new Scanner(System.in);


        if (op.equals("+"))                                     // if the operator is for addition
        {
            System.out.println("What is your first number?");
            double num1 = input.nextDouble();
            System.out.println("What is your second number?");
            double num2 = input.nextDouble();
            System.out.println("Your answer is: " + (num1 + num2));
            System.exit(1);
        }

        if (op.equals("-"))                                     // if the operator is subtraction
        {
            System.out.println("What is your first number?");
            double num1 = input.nextDouble();
            System.out.println("What is your second number?");
            double num2 = input.nextDouble();
            System.out.println("Your answer is: " + (num1 - num2));
            System.exit(1);
        }

        if (op.equals("*"))                                     // if the operator is for multiplication
        {
            System.out.println("What is your first number?");
            double num1 = input.nextDouble();
            System.out.println("What is your second number?");
            double num2 = input.nextDouble();
            System.out.println("Your answer is: " + (num1 * num2));
            System.exit(1);
        }

        if (op.equals("/"))                                      // if the operator is for division
        {
            System.out.println("What is your first number?");
            double num1 = input.nextDouble();
            System.out.println("What is your second number?");
            double num2 = input.nextDouble();
                if (num2 == 0) {                                // can't divide by 0, so it's an invalid input as num2
                    System.out.println("Invalid Denominator");
                    System.exit(1);
                }
            System.out.println("Your answer is: " + (num1 / num2));
            System.exit(1);
        }

        if (op.equals("square"))                                // if the desired operation is squaring, only one input necessary
        {
            System.out.println("What number would you like to square?");
            double num1 = input.nextDouble();
            System.out.println("Your answer is: " + (num1 * num1));
            System.exit(1);
        }

        if (op.equals("cube"))                                  // if the desired operation is cubing, again, one one input necessary
        {
            System.out.println("What number would you like to cube?");
            double num1 = input.nextDouble();
            System.out.println("Your answer is: " + (num1 * num1 * num1));
            System.exit(1);
        }

        if (op.equals("exponent"))                              // if the desired operation is any exponent equation, input base and power
        {
            System.out.println("What is your base number?");
            double base = input.nextDouble();
            System.out.println("What exponent do you want?");
            double power = input.nextDouble();
            double answer = Math.pow(base, power);
            System.out.println("Your answer is: " + (answer));
        }

        else
        {
            System.out.println("Invalid Input");                // if an invalid operator was input
        }
        System.exit(1);

    }
}