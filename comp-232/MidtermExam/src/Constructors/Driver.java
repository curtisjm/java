package Constructors;

public class Driver {

    // output from this programs is:
        // In alpha...
        // In beta...
        // In beta...
    // which shows us that the order these constructors are called in are alpha, beta, then gamma.

    public static void main(String[] args) {
        Gamma test = new Gamma();
    }
}
