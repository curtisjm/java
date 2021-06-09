package Rec;

public class ExponentR {

    // The given version will recur indefinitely due to its lack of a base case.
    // We must use an if statement and have two different returns in order to fix this issue.
    // Here is an example of how that is done:

    public static double exponent(double a, int n) {
        if(n != 0) {
            return a*exponent(a,n-1);
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(exponent(2, 8));
    }
}
