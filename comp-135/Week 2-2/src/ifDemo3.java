public class ifDemo3 {
    public static void main(String[] args) {

        double a = 1.5, b =1.5;
        a += 0.0000000000000001; //a = a + 0.000000000000001
        // such a small number that double can't register it
        if (a == b) {
            System.out.println("a & b are equal"); }
        else {
            System.out.println("a & b are different"); }
    }
}

