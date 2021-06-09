
public class Before {

    private Object t;
    public Object get() {
        return t;
    }
    public void set(Object t) {
        this.t = t;
    }

    public static void main(String[] args) {
        Before bType = new Before();
        bType.set("Umbrella");
        String str = (String) bType.get();
        System.out.println(str);
    }

}
