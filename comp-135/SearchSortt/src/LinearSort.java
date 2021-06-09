public class LinearSort {

    public static int linearSearch(int[] arr, int searchValue) {
        for(int i=1; i<arr.length; i++) {
            if (arr[i] == searchValue) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] intArray = {10, 45, 56, 37, 90};
        int searchValue = 37;
        System.out.println("Found value at index " + linearSearch(intArray, searchValue));
    }
}
