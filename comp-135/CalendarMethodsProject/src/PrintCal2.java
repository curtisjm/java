import java.util.Scanner;

public class PrintCal2 {
    public static void main(String[] args) {

        int year = askYear();
        int month = askMonth();

        printMonth(year, month);

    }

    public static int askYear() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a year");
        int year = input.nextInt();
        if (year < 1900) {
            System.out.println("That is too far back even for me...");
            System.exit(1);
        }
        return year;
    }

    public static int askMonth() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a month (1-12)");
        int month = input.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Invalid Input");
            System.out.println("Enter a number between 1 and 12");
            System.exit(1);
        }
        return month;
    }

    // A stub for printMonth ex:
    public static void printMonth(int year, int month) {
        System.out.println(month + " : " + year);
    }

    // A stub for printMonthTitle
    public static void printMonthTitle(int year, int month) {
        //month name helper method
    }


    // A stub for printMonthBody
    public static void printMonthBody(int year, int month) {

    }
    public static String getMonthName(int month) {
        return "January";
    }

    public static int getStartDate(int year, int month) {
        return 1; // dummy
    }

    public static int getNumberOfDaysInMonth(int year, int month) {
        return 31;
    }

    public static int getTotalNumberOfDays(int year, int month) {
        return 1000; // dummy
    }

    public static boolean isLeapYear(int year) {
        return true;
    }
}
