import java.util.Scanner;

public class StringToNum {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number");
        String num = input.next();
        int output = Integer.parseInt(num);

        System.out.println(output);
    }
}
