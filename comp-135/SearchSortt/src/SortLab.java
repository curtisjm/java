import java.util.Arrays;
import java.util.Random;

public class SortLab {

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort (int[] arr) {
        // number of passes
        for(int i=1; i<arr.length; i++) {
            // comparison loop
            for(int j=0; j<arr.length-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] intArray = {20, 45, 78, 80, 24, 16};
        int[] intArray2 = {90, 75, 35, 23, 14, 6};
        int[] intArray3 = new int[100];
        Random ranNum = new Random();
        for (int i = 0; i < intArray3.length; i++) {
            intArray3[i] = ranNum.nextInt(100) + 1;
        }

        printArray(intArray);
        double startTime = System.nanoTime();
        bubbleSort(intArray);
        double endTime = System.nanoTime();
        double elapsedTime = endTime - startTime;
        printArray(intArray);
        System.out.println(elapsedTime);

        printArray(intArray2);
        double startTime2 = System.nanoTime();
        bubbleSort(intArray2);
        double endTime2 = System.nanoTime();
        double elapsedTime2 = endTime2 - startTime2;
        printArray(intArray2);
        System.out.println(elapsedTime2);

        printArray(intArray3);
        double startTime3 = System.nanoTime();
        bubbleSort(intArray3);
        double endTime3 = System.nanoTime();
        double elapsedTime3 = endTime3 - startTime3;
        printArray(intArray3);
        System.out.println(elapsedTime3);
        }
    }

