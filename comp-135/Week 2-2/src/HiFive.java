import java.util.Scanner;

public class HiFive {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter an integer");
        int num = input.nextInt();

        if (num % 5 == 0) //if num is divisible by 5, it will have remainder 0
        {
            System.out.println("Hi Five");
        }

        if (num % 2 == 0)
        {
            System.out.println("Hi Even");
        }

    }
}
