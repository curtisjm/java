package SS;

public class SumSquare {

    // expected result: 25164150

    public static void main(String[] args) {
        // value of n being plugged into formulas, the "nth term"
        int number = 100;
        // use sum of natural numbers formula: S = [n(n+1)] / 2
        int sum = (number * (number + 1)) / 2;
        // use formula for sum of squares of natural numbers: S = [n(n+1)(2n+1)] / 6
        int squares = (number * (number + 1) * (2 * number + 1)) / 6;
        // find the difference
        int difference = (sum * sum) - squares;
        System.out.println("Difference: " + difference);
    }
}
