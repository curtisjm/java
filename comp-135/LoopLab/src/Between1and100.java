import java.util.Scanner;

public class Between1and100 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a number");
        int num = input.nextInt();

         while(num != 0) {
            if(num>= 1 && num<= 100) {
                System.out.println("Your number is between 1 and 100");
            } else {
                System.out.println("Your number is not between 1 and 100");
            }
             System.out.println("Enter another number or enter 0 to stop");
             num = input.nextInt();
         }
    }
}
