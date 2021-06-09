package SD;

import java.math.BigInteger;

public class SumDigits {

    // expected output: 1366

    public static long sumDigits() {
        long sum = 0;
        String value = BigInteger.valueOf(2).pow(1000).toString();
        for(char c : value.toCharArray()) {
            sum += Character.getNumericValue(c);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumDigits());
    }
}
