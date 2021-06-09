import java.util.Scanner;

public class AreaOfTriangle {

    public static double area(double num1, double num2, double num3) {
        double p = (num1 + num2 + num3) / 2;
        double insideSqrt = p * (p - num1) * (p-num2) * (p - num3);
        return Math.sqrt(insideSqrt);

    }
    public static void main(String[] args) {

        System.out.println("*AREA OF A TRIANGLE CALCULATOR*");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the length of the first side");
        double side1 = input.nextDouble();
        System.out.println("Enter the length of the second side");
        double side2 = input.nextDouble();
        System.out.println("Enter the length of the third side");
        double side3 = input.nextDouble();

        System.out.println("The area of a triangle with side lengths of " + side1 + ", " + side2 + ", and " + side3 + " is: " + area(side1,side2,side3));
    }
}
