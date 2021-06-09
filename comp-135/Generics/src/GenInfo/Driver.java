package GenInfo;

public class Driver {

    private Object t;
    public Object get() {
        return t;
    }
    public void set(Object o) {
        this.t = o;
    }

    public static void main(String[] args) {
        // class is name of current class
        Driver type = new Driver();
        type.set("Umbrella");
        String str = (String) type.get();

        System.out.println(str);
    }
}
