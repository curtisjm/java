package ExceptionsEx2;

public class Finally {

    public static void main(String[] args) {
        try {
            //long data[] = new long[1000000000000];
            int result = 12/0;
        } catch(Exception e) {
            System.out.println("In Catch");
            System.out.println(e.getMessage());
        // executes after try and catch
        } finally {
            System.out.println("Finally is executed before ending...");
        }
    }
}
