public class BreakContinueDemo1 {
    public static void main(String[] args) {

        System.out.println("Starting loop: ");
        for(int n=0; n<7; n++) {
            System.out.println("in loop: " + n);

            if (n == 2) {
                continue;
            }
            System.out.println(" survived first guard");

            if (n == 4) {
                break;
            }
            System.out.println(" survived the second guard");

        }
        System.out.println("end of loop or exit via break");

    }
}
