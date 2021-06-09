public class FibonacciSequence {
    public static void main(String[] args) {

        long num1 = 0, num2 = 1, output = 0;
        System.out.println(num1);

        for(long i=0; i<=50; i++) {
            output = num1 + num2;
            System.out.println(output);
            num1 = num2;
            num2 = output;
        }
    }
}
