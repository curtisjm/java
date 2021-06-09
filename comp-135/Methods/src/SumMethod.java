public class SumMethod {
    // reusable
    public static int sum (int i1, int i2) {
        int result = 0;
        for(int i = i1; i<=i2; i++) {
            result += i;
        }
        return result;
    }
    public static void main(String[] args) {

        System.out.println("Sum of 1 to 10 is " + sum(1,10));
        System.out.println("Sum of 10 to 100 is " + sum(10,100));
    }
}
