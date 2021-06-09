import java.util.Arrays;

public class SelectionSort {

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void selectionSort(int[] arr) {
        for(int i=0; i < arr.length-1; i++) {
            int minValue = i;
            for(int j=i+1; j <arr.length; j++) {
                // comparison
                if(arr[j] < arr[minValue])
                    minValue = j;
            }
            // swap
            int temp = arr[i];
            arr[i] = arr[minValue];
            arr[minValue] = temp;
        }
    }

    public static void main(String[] args) {
        int[] intArray = {20, 45, 78, 80, 24, 16};
        printArray(intArray);
        selectionSort(intArray);
        printArray(intArray);
    }
}
