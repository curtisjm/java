import java.util.Arrays;

public class BubbleSort {

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
        printArray(intArray);
        bubbleSort(intArray);
        printArray(intArray);
    }
}
