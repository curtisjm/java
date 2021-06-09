import java.util.Scanner;

public class Square {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number to square");
        int product = 0;

        for(int i=input.nextInt(); i!=0; i=input.nextInt()) {
            product = i * i;
            System.out.println(i + " squared is " + product);
            System.out.println("Enter another number or 0 to stop");
        }
    }
}
