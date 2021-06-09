public class BinarySearch {
    // most efficient way to search
    // requires sorted array

    public static int binarySearch(int[] arr, int first, int last, int searchValue) {
        // find midpoint in array
        // compares searchValue to mid point
        // remove half of array that the value is not in
        int mid = (first + last) / 2;
        while(first <= last) {
            if(arr[mid] < searchValue) {
                first = mid + 1;
            }
            else if(arr[mid] == searchValue) {
                return mid;
            }
            else {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] intArray = {10, 25, 36, 57, 90, 100};
        int searchValue = 57;
        int length = intArray.length;
        System.out.println("Value found at index " + binarySearch(intArray,0, length, searchValue));
    }
}
