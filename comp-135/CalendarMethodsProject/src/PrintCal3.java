import java.util.Scanner;

public class PrintCal3 {

    public static void main(String[] args) {
        int year = askYear();
        int month = askMonth();

        printMonth(year, month);
    }

    public static int askYear() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a year");
        int year = input.nextInt();
        if (year < 1800) {
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

    // A stub for printMonth
    public static void printMonth(int year, int month) {
        printMonthTitle(year, month);
        printMonthBody(year, month);
    }

    // A stub for printMonthTitle
    public static void printMonthTitle(int year, int month) {
        System.out.println("\t\t" + getMonthName(month) + " " + year);
        System.out.println("------------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat ");

    }

    // A stub for printMonthBody
    public static void printMonthBody(int year, int month) {
        // Get start day of the week for first date in that month
        int startDay = getStartDay(year, month);
        // Get the number of days in that month
        int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);

        // space stuff
        int i = 0;
        for (i = 0; i < startDay; i++)
            System.out.print("    ");

        for (i = 1; i <= numberOfDaysInMonth; i++) {
            System.out.printf("%4d", i);        // jumps 4 places, then prints
            if((i + startDay) % 7 == 0)      // is it the weekend, go to next line
                System.out.println();

        }

    }

    public static String getMonthName(int month) {
        String monthName = "";
        switch(month) {
            case 1: monthName = "January";
                break;
            case 2: monthName = "February";
                break;
            case 3: monthName = "March";
                break;
            case 4: monthName = "April";
                break;
            case 5: monthName = "May";
                break;
            case 6: monthName = "June";
                break;
            case 7: monthName = "July";
                break;
            case 8: monthName = "August";
                break;
            case 9: monthName = "September";
                break;
            case 10: monthName = "October";
                break;
            case 11: monthName = "November";
                break;
            case 12: monthName = "December";
                break;
        }
        return monthName;
    }

    public static int getNumberOfDaysInMonth(int year, int month) {
        if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            return 31;
        if(month == 4 || month == 6 || month == 9 || month == 11)
            return 30;
        if(month == 2)
            return isLeapYear(year) ? 29 : 28; // if true return 29, else 28
        return 0; // month is very wrong
    }

    public static int getStartDay(int year, int month) {
        // start with known starting point
        final int START_DAY_FOR_JAN_1800 = 3;
        // get total number of days from 1/1/1800 to month/1/year
        int totalNumberOfDays = getTotalNumberOfDays(year, month);

        return(totalNumberOfDays + START_DAY_FOR_JAN_1800) % 7;
    }

    public static int getTotalNumberOfDays(int year, int month) {
        int total = 0;
        // total days from 1800 to 1/1/year
        for (int i = 1800; i < year; i++)
            if (isLeapYear(i))
                total = total + 366;
            else
                total = total + 365;
        // add days from January to selected month to get total
        for (int i = 1; i < month; i++)
            total = total + getNumberOfDaysInMonth(year, i);

        return total;
    }

    public static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

}
