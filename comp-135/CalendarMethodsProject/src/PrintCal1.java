import java.util.Scanner;

public class PrintCal1 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a year");
        int year = input.nextInt();

        System.out.println("Enter a month (1-12)");
        int month = input.nextInt();

        printMonth(year, month);

    }
    // A stub for printMonth ex:
    public static void printMonth(int year, int month) {
        System.out.println(month + " : " + year);
    }
    // A stub for printMonthTitle
    public static void printMonthTitle(int year, int month) {

    }
    // A stub for printMonthBody
    public static void printMonthBody(int year, int month) {

    }
}
