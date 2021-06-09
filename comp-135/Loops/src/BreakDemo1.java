public class BreakDemo1 {
    public static void main(String[] args) {

        int sum = 0;
        int num = 0;

        while(num < 20) {
            num++;
            sum += num;     // sum = sum + num
            if(sum >= 100) {
                break;      // will exit loop when sum is over 100
            }
        }
        System.out.println("The number is " + num);
        System.out.println("The sum is " + sum);
    }
}
