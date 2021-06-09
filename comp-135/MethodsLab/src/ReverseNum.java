import java.util.Scanner;

public class ReverseNum {

    public static int reverse(int num) {
        int reverse = 0;
        while (num != 0) {
            int lastDigit = num % 10;
            reverse = (reverse * 10) + lastDigit;
            num = num / 10;

        }return reverse;
    }

    public static void main(String[] args) {
        System.out.println("Enter an integer");
        Scanner input = new Scanner(System.in);
        int in = input.nextInt();

        System.out.println("The reverse of " + in +" is " + reverse(in));

    }
}
