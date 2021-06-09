package GenericsType;

public class Driver {

    public static <T> boolean isEqual(GenType<T> g1, GenType<T> g2) {
        return g1.getT().equals(g2.getT());
    }

    public static void main(String[] args) {
        GenType<String> g1 = new GenType<>();
        g1.setT("Umbrella");
        GenType<String> g2 = new GenType<>();
        g2.setT("Umbrella");

        boolean isEqual = Driver.isEqual(g1, g2);
        System.out.println("Equality result is " + isEqual);
    }
}
