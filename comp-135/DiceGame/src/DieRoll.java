import java.util.Scanner;

public class DieRoll {
    public static void main(String[] args) {

        // 1. Start with a random number generated from 1 - 6
        int dice = (int)(Math.random()*6)+1;
        // System.out.println(dice);

        // 2. Ask user to guess
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your guess");
        int guess = input.nextInt();

        // 3. Decide the winner
        if (guess != dice) {
            System.out.println("Oops. Wrong Guess. Computer Wins!");
        } else {
            System.out.println("We have a winner! Correct guess!");
        }

    }
}
