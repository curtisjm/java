import java.util.Arrays;

public class Copy2 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5};
        int[] nums2 = new int[nums1.length];

        for(int i=0; i<nums1.length; i++) {
            nums2[i] = nums1[i];
        }
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));

        int[] smallArray = new int[100];
        for(int i=0; i<smallArray.length; i++) {
            smallArray[i] = i+1;
        }

        // wrote code to change smallArray
        // now you need a bigger array

        int[] biggerArray = new int[200];
        for(int i=0; i<smallArray.length; i++) {
            biggerArray[i] = smallArray[i];
        }
        int oldSmallArraySize = smallArray.length;
        System.out.println("Size is " + oldSmallArraySize);
        smallArray = biggerArray;
        for(int i=oldSmallArraySize; i<smallArray.length; i++) {
            smallArray[i] = i+1;
        }
        System.out.println(Arrays.toString(smallArray));
        System.out.println(Arrays.toString(biggerArray));
    }
}
