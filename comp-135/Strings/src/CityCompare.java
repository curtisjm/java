import java.util.Scanner;

public class CityCompare {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter first city");
        String city1 = input.nextLine();

        System.out.println("Enter second city");
        String city2 = input.nextLine();

        // compare city 1 to city 2. which is greater?  (based on alphabetical order) (case sensitive unless use IgnoreCase)
        if (city1.compareTo(city2) < 0)
            System.out.println("The cities in alphabetical order are " + city1 + " " + city2);
        else
            System.out.println("The cities in alphabetical order are " + city2 + " " + city1);
    }
}
