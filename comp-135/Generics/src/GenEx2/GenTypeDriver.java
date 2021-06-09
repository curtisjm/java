package GenEx2;

public class GenTypeDriver {

    public static <T> boolean isEqual(GenericsType<T> g1, GenericsType<T> g2) {
        System.out.println(g1.getT());
        System.out.println(g2.getT());
        return g1.getT().equals(g2.getT());
    }

    public static void main(String[] args) {
        GenericsType<String> g1 = new GenericsType<>();
        g1.setT("Umbrella");

        GenericsType<String> g2 = new GenericsType<>();
        g2.setT("Umbrella");

        boolean isEqual = GenTypeDriver.<String> isEqual(g1,g2);
        System.out.println("Equality is: " + isEqual);
    }
}
