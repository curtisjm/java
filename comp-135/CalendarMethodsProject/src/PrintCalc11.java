import java.util.Scanner;

public class PrintCalc11 {

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
                System.out.println("This is too far back even for me...");
                System.exit(1);
            }
            return year;
        }

        public static int askMonth() {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a month (1-12)");
            int month = input.nextInt();
            return month;
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
