package ArrayContains;

import java.util.Arrays;
import java.util.HashMap;

public class ModeArray {

    public static int mode(int[] arr) {
        HashMap<Integer, Integer> nums = new HashMap<>();
        int maxVal = 1;
        int x = 0;
        int count = 0;
        boolean xUpdated = false;
        for (int j : arr) {
            if (nums.get(j) != null) {
                count = nums.get(j);
                count++;
                nums.put(j, count);
                if (count > maxVal) {
                    maxVal = count;
                    x = j;
                    xUpdated = true;
                }
            } else {
                nums.put(j, 1);
            }
        }
        if(xUpdated) {
            return x;
        } else {
            Arrays.sort(arr);
            return arr[0];
        }
    }

    public static void main(String[] args) {
        int[] array1 = {99, 86, 99, 99, 95, 86};
        System.out.println(mode(array1));
    }
}
