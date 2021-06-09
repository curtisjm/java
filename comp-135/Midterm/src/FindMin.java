import java.util.Arrays;
import java.util.Random;

public class FindMin {

    public static int findMin () {
        int[] values = new int[100];
        Random ranNum = new Random();
        // fills array with random numbers 1-200
        for (int i = 0; i < values.length; i++) {
            values[i] = ranNum.nextInt(200) + 1;
        }
        // sorts array and returns value at index 1, which will be the smallest one
        Arrays.sort(values);
        return values[0];
    }
    public static void main(String[] args) {
        int minValue = findMin();
        System.out.println(minValue);
    }
}
