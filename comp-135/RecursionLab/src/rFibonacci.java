import java.util.Scanner;

public class rFibonacci {

    public static int input() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number in the series that you want");
        return input.nextInt();
    }

    public static int fibSeq(int input) {
        // long num1 = 0, num2 = 1, output = 0;
        // System.out.println(num1);
        if (input <= 1) {
            return input;
        }
        else {
            return fibSeq(input - 1) + fibSeq(input - 2);
        }

    }

    public static void main(String[] args) {
        int input = input();
        fibSeq(input);
    }
}
