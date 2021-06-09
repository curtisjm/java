import java.util.Scanner;

public class rPower {

    public static int baseIn() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a base number");
        return input.nextInt();
    }

    public static int powerIn() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an exponent");
        return input.nextInt();
    }

    public static int calculation(int base, int power) {
        if (power > 0)
            return base * calculation(base, power - 1);
        else return 1;
    }

    public static void main(String[] args) {
        int base = baseIn();
        int power = powerIn();
        int calculation = calculation(base, power);
        System.out.println(base + " to the power of " + power + " is " + calculation);

    }
}
