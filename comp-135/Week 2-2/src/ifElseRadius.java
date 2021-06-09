import java.util.Scanner;

public class ifElseRadius {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter Radius");
        double radius = input.nextDouble();
        if (radius >= 0)
        {
            double area = 3.14 * radius * radius;
            System.out.println("The Area is: " + area);
        }
        else {
            System.out.println("Invalid Input");
        }

    }
}
