package ExceptionsEx3;

public class Propagation {

    static int sum(int n1, int n2) {
        if(n1 == 0)
            throw new ArithmeticException("First parameter is not valid");
        else
            return n1+n2;
    }

    public static void main(String[] args) {
        // exceptions propagate through methods
        // can be handled in main method
        try {
            int res = sum(0,12);
            System.out.println(res);
        } catch(ArithmeticException ae) {
            System.out.println("Arithmetic exception handled");
        }
    }
}
