
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        double a, b;
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the first complex number: ");
        a = input.nextDouble();
        b = input.nextDouble();
        Complex num1 = new Complex(a, b);

        System.out.println("Enter the second complex number: ");
        a = input.nextDouble();
        b = input.nextDouble();
        Complex num2 = new Complex(a, b);

        System.out.println(num1 + " + " + num2 + " = " + num1.add(num2));
        System.out.println(num1 + " - " + num2 + " = " + num1.subtract(num2));
        System.out.println(num1 + " * " + num2 + " = " + num1.multiply(num2));
        System.out.println(num1 + " / " + num2 + " = " + num1.divide(num2));
        System.out.println("| " + num1 + " | = " + num1.abs());
    }
}
