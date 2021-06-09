
public class After<T> {

    private T t;
    public T get() {
        return t;
    }
    public void set(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        After<String> sType = new After<>();
        sType.set("Umbrella");
        After sType2 = new After();
        sType2.set("Rain coat");
        // autoboxing
        sType2.set(10);
        System.out.println(sType.get());
        System.out.println(sType2.get());
    }
}
