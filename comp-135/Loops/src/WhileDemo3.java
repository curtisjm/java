public class WhileDemo3 {
    public static void main(String[] args) {

        int count = 1;
        int sum = 0;
        while(count <= 100) {
            sum += count;      // means sum = sum + count
            count++;

        }
        System.out.println("Summation of 1 to 100 is " + sum);
    }
}
