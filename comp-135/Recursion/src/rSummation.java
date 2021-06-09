public class rSummation {

    public static int rSum(int k ) {
        if (k > 0)
            return k + rSum(k-1);
        else
            return 0;
    }

    public static void main(String[] args) {
        int result = rSum(10);  // 1 + 2 + 3 ... + 10
        System.out.println(result);
    }
}
