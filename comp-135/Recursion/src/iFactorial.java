public class iFactorial {

    // 5! = 5 * 4 * 3 * 2 * 1
    public static int iFact(int n) {
        int result = 1, i = 1;
        while (i <= n) {
            result *= i;    // result = result * i
            i++;
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println("Factorial of 5 is " + iFact(5));
    }
}
