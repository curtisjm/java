public class DoWhileDemo2 {
    public static void main(String[] args) {

        int count = 1;
        int sum = 0;

        do {
            sum += count;
            count++;
        } while(count <= 100);
        System.out.println("Summation of 1 to 100 is " + sum);

    }
}
