public class NestedLoopsDemo1 {
    public static void main(String[] args) {

        int height =5;
        int width = 20;

        // prints box of stars
        for (int i=0; i<height; i++) {
            for (int j =0; j<width; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }

    }
}
