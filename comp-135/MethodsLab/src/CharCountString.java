import java.util.Scanner;

public class CharCountString {

public static int stringCount(String num) {
    int count = 0;
    for (int i = 0; i < num.length(); i++) {
        if (num.charAt(i) != ' ') {
            count++;
        }
    } return count;
}

    public static void main(String[] args) {

        System.out.println("Enter a string");
        Scanner input = new Scanner(System.in);
        String in = input.nextLine();

        System.out.println("There are " + stringCount(in) + " characters in your string (not including spaces).");

    }
}
