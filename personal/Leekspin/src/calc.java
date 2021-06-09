import java.util.Scanner;

public class calc {
    public static void main(String[] args) {

        Scanner operation = new Scanner(System.in);

        System.out.println("What operation would you like to do?");
        System.out.println("(Enter +, -, *, /, square, cube, or exponent)");
        String op = operation.next();
        Scanner input = new Scanner(System.in);


        if (op.equals("+")) {
            System.out.println("What is your first number?");
            double num1 = input.nextDouble();
            System.out.println("What is your second number?");
            double num2 = input.nextDouble();
            double answer = num1 + num2;
            if (answer == 69) {
                System.out.println("HEhahahhahahhahhahahahaha");
            } else {
                System.out.println("Your answer is: " + (answer));
            }
        }

        if (op.equals("-")) {
            System.out.println("What is your first number?");
            double num1 = input.nextDouble();
            System.out.println("What is your second number?");
            double num2 = input.nextDouble();
            double answer = num1 - num2;
            if (answer == 69) {
                System.out.println("HEhahahhahahhahhahahahaha");
            } else {
                System.out.println("Your answer is: " + (answer));
            }
        }

        if (op.equals("*")) {
            System.out.println("What is your first number?");
            double num1 = input.nextDouble();
            System.out.println("What is your second number?");
            double num2 = input.nextDouble();
            double answer = num1 * num2;
            if (answer == 69) {
                System.out.println("HEhahahhahahhahhahahahaha");
            } else {
                System.out.println("Your answer is: " + (answer));
            }
        }

        if (op.equals("/")) {
            System.out.println("What is your first number?");
            double num1 = input.nextDouble();
            System.out.println("What is your second number?");
            double num2 = input.nextDouble();
            if (num2 == 0) {
                System.out.println("Invalid Denominator");
                System.exit(1);
            }
            double answer = num1 / num2;
            if (answer == 69) {
                System.out.println("HEhahahhahahhahhahahahaha");
            } else {
                System.out.println("Your answer is: " + (answer));
            }
        }

        if (op.equals("square")) {
            System.out.println("What number would you like to square?");
            double num1 = input.nextDouble();
            double answer = num1 * num1;
            if (answer == 69) {
                System.out.println("HEhahahhahahhahhahahahaha");
            } else {
                System.out.println("Your answer is: " + (answer));
            }
        }

        if (op.equals("cube")) {
            System.out.println("What number would you like to cube?");
            double num1 = input.nextDouble();
            double answer = (num1 * num1 * num1);
            if (answer == 69) {
                System.out.println("HEhahahhahahhahhahahahaha");
            } else {
                System.out.println("Your answer is: " + (answer));
            }
        }

        if (op.equals("exponent")) {
            System.out.println("What is your base number?");
            double base = input.nextDouble();
            System.out.println("What exponent do you want?");
            double power = input.nextDouble();
            double answer = Math.pow(base, power);
            if (answer == 69) {
                System.out.println("HEhahahhahahhahhahahahaha");
            } else {
                System.out.println("Your answer is: " + (answer));
            }


        }
    }
}