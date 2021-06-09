import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListPractice2 {

    public static void arrayListNum() {
        Scanner input = new Scanner(System.in);
        ArrayList<Double> nums = new ArrayList<>();

        boolean stillEntering = true;
        while (stillEntering) {
            double numsIn = input.nextDouble();
            if(numsIn == 0)
                stillEntering = false;
            else
                nums.add(0, numsIn);
        }
        System.out.println(nums);
        
    }

    public static void main(String[] args) {
        arrayListNum();
    }
}
