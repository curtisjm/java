import java.util.Scanner;

public class SwapVariables {

    public static void main(String[] args) {
        int x,y;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter value of x & y");
        x = input.nextInt();
        y = input.nextInt();
        System.out.println("Before Swapping -- x: " + x + " y: " + y);

        // swap
        int temp = x;
        x = y;
        y = temp;
        System.out.println("After Swapping -- x: " + x + " y: " + y);
    }
}
