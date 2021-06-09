import java.util.Arrays;
import java.util.Random;

public class SortLab2 {

    public static void bubbleSort(int[] arr) {
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

    public static void compareBubbleSelection() {
        int timesRun = 1000;

        double totalTimeSelection = 0;
        double totalTimeBubble = 0;

        for(int x=1; x<timesRun; x++) {
            int[] intArray = new int[5000];
            Random ranNum = new Random();
            for (int i = 0; i < intArray.length; i++) {
                intArray[i] = ranNum.nextInt(500) + 1;
            }

            // time for selection
            double startTimeSelection = System.nanoTime();
            selectionSort(intArray);
            double endTimeSelection = System.nanoTime();
            double elapsedTimeSelection = endTimeSelection - startTimeSelection;
            totalTimeSelection += elapsedTimeSelection;

            // time for bubble
            double startTimeBubble = System.nanoTime();
            bubbleSort(intArray);
            double endTimeBubble = System.nanoTime();
            double elapsedTimeBubble = endTimeBubble - startTimeBubble;
            totalTimeBubble += elapsedTimeBubble;
        }

        // average time for selection
        double averageTimeSelection = totalTimeSelection / timesRun;

        // average time for bubble
        double averageTimeBubble = totalTimeBubble / timesRun;

        // compare averages
        if(averageTimeBubble > averageTimeSelection)
            System.out.println("Selection Sort is Faster");
        else
            System.out.println("Bubble Sort is Faster");
    }

    public static void main(String[] args) {
        compareBubbleSelection();
    }
}
