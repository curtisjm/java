package GenInfo;

public class Driver2 <T> {

    private T t;
    public T get() {
        return t;
    }
    public void set(T t1) {
        this.t = t1;
    }

    public static void main(String[] args) {
        Driver2 <String> type = new Driver2<>();
        type.set("Umbrella");
        System.out.println(type.get());
        System.out.println();

        Driver2 <Integer> type1 = new Driver2<>();
        type1.set(123);
        System.out.println(type1.get());
        System.out.println();

        // raw type
        Driver2 type3 = new Driver2();
        // set it, it infers (finds type on the fly)
        type3.set(12.45);
        System.out.println(type3.get());
        // can change the type (auto-boxing)
        type3.set("rain coat");
        System.out.println(type3.get());
        System.out.println();
    }
}
