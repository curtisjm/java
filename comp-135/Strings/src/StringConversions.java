import java.util.Scanner;

public class StringConversions {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter first number");
        String input1 = input.nextLine();

        // convert input1 to int
        int intValue = Integer.parseInt(input1);
        System.out.println(intValue);

        // sting to double
        double doubleValue = Double.parseDouble(input1);
        System.out.println(doubleValue);

        // double to string
        String doubleString = String.valueOf(doubleValue);
        System.out.println(doubleValue);

    }
}
