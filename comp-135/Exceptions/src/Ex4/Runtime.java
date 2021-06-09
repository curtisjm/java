package Ex4;

public class Runtime {

    public static void main(String[] args) {
        String[] animals = {"cat", "jaguar", "cow", "dog", "goat"};

        try {
            for (int c=0; c<5; c++) {
                System.out.println(animals[c]);
            }
        } catch(ArrayIndexOutOfBoundsException aoB) {
            System.out.println("Oops you overstepped... " + aoB.getMessage());
        }
    }
}
