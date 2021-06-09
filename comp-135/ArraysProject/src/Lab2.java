import java.util.Arrays;
import java.util.Random;

public class Lab2 {

    public static void printGreaterThan(int[] values) {
        System.out.println("The values greater than 200 are: ");
        for (int i = 0; i < values.length; i++) {
            if (values[i] > 200)
                System.out.print(values[i] + " ");
        }
    }

    public static void displayBackwards(int[] values) {
        System.out.println("Values in reverse order:");
        for (int i = values.length; i > 0; i--)
            System.out.print(values[i - 1] + " ");
    }

    public static void findMaxValue(int[] values) {
       Arrays.sort(values);
       int maxValue = values[values.length - 1];
        System.out.println("The greatest number in the arrays is " + maxValue);
    }

    public static void elementCount(int[] values) {
        System.out.println("The length of the array is " + values.length);
    }

    public static void greaterSum(int[] values) {
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] > 200)
                sum += values[i];
        }
        System.out.println("The sum of all numbers in the array greater than 200 is " + sum);
    }

    public static void even(int[] values) {
        System.out.println("The even numbers are: ");
        for (int i = 0; i < values.length; i++) {
            if (values[i] % 2 == 0)
                System.out.print(values[i] + " ");
        }
    }

        public static void main(String[]args){
            int[] values = new int[100];
            Random ranNum = new Random();

            for (int i = 0; i < values.length; i++) {
                values[i] = ranNum.nextInt(500) + 1;
            }

            printGreaterThan(values);
            displayBackwards(values);
            findMaxValue(values);
            elementCount(values);
            findMaxValue(values);
            greaterSum(values);
            even(values);

        }
    }
