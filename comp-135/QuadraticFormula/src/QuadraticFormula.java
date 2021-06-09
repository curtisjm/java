import java.util.Scanner;

public class QuadraticFormula {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("A quadratic equation in standard form is expressed as: ax^2 + bx + c. We will solve for x.");
        System.out.println("Enter the value of a");
        double a = input.nextDouble();
        System.out.println("Enter the value of b");
        double b = input.nextDouble();
        System.out.println("Enter the value of c");
        double c = input.nextDouble();
        System.out.println("In the equation " + a + "x^2 + " + b + "x + " + c + ",");

        double discriminant = ((b * b) - (4 * a * c));

        if(discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            System.out.println("x = " + root1 + ", " + root2);
        } else if(discriminant == 0) {
            double root = (-b) / (2 * a);
            System.out.println("x = " + root);
        } else {
            System.out.println("There are no real roots");
        }

    }
}
