public class rFactorial {

    // 5!, 1
    public static int rFact(int n) {
        // exit strategy
        if (n <= 1) return 1;       // base case, solution statement
        // can't use loops: divide and conquer
        else {
            return n*rFact(n-1);    // general case, use own function again
            // n = 5: 5 * rFact(4);
            // n = 4: 4 * rFact(3);
            // n = 2: 2 * rFact(1);
            // n = 1: return 1;
        }
    }

    public static void main(String[] args) {

        System.out.println("Factorial of 5 is " + rFact(5));
    }
}
