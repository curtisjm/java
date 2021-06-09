import java.util.Random;

public class BenLaw {

        public static void main(String[] args) {
            String[] randNums = generateNums();
            int[] count = countDigits(randNums);
            reportResults(count);
        }

        public static String[] generateNums() {
            String[] randInts = new String[10000000];
            Random rand = new Random();
            for(int i=0; i<randInts.length; i++) {
                randInts[i] = String.valueOf(rand.nextInt(10000) + 1);
            }
            return randInts;
        }

        public static String[] generateNums2() {
            String[] randInts = new String[10000000];
            for(int i=0; i<randInts.length; i++) {
                int rand = (int) (Math.random() * 10000 - 1 + 1) + 1;
                randInts[i] = String.valueOf(rand);
            }
            return randInts;
        }

    public static String[] generateNums3() {
        String[] randInts = new String[10000000];
        Random rand = new Random();
        return randInts;
    }

    // Reads integers from input, computing an array of counts
        // for the occurrences of each leading digit (0-9).
        public static int[] countDigits(String[] randNums) {
            int[] count = new int[10];
            for(int i=0; i<randNums.length; i++) {
                int n = firstDigitOf(randNums[i]);
                count[firstDigit(n)]++;
            }
            return count;
        }

        // returns the first nonzero digit of a string, 0 if no such digit found
        public static int firstDigitOf(String token) {
            for (char ch : token.toCharArray()) {
                if (ch >= '1' && ch <= '9') {
                    return ch - '0';
                }
            }
            return 0;
        }

        // Reports percentages for each leading digit, excluding zeros
        public static void reportResults(int[] count) {
            System.out.println();
            if (count[0] > 0) {
                System.out.println("excluding " + count[0] + " tokens");
            }
            int total = sum(count) - count[0];
            System.out.println("Digit Count Percent");
            for (int i = 1; i < count.length; i++) {
                double pct = count[i] * 100.0 / total;
                System.out.printf("%5d %5d %6.2f\n", i, count[i], pct);
            }
            System.out.printf("Total %5d %6.2f\n", total, 100.0);
        }

        // returns the sum of the integers in the given array
        public static int sum(int[] data) {
            int sum = 0;
            for (int n : data) {
                sum += n;
            }
            return sum;
        }

        // returns the first digit of the given number
        public static int firstDigit(int n) {
            int result = Math.abs(n);
            while (result >= 10) {
                result = result / 10;
            }
            return result;
        }
    }