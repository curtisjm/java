public class FirstArray {

    public static void main(String[] args) {

        int[] anArray;  // declaring an array

        anArray = new int[10];  // initialize

        // int[] anArray = new int[10]; is a more efficient way

        System.out.println("The array length is " + anArray.length);

        // array assignment
        anArray[0] = 100;   // [index] = value
        anArray[1] = 200;
        anArray[2] = 300;
        anArray[3] = 400;
        anArray[4] = 500;
        anArray[5] = 600;
        anArray[6] = 700;
        anArray[7] = 800;
        anArray[8] = 900;
        anArray[9] = 1000;

        // array print, dereference
        System.out.println("Element at index 0: " + anArray[0]);
        System.out.println("Element at index 1: " + anArray[1]);
        System.out.println("Element at index 2: " + anArray[2]);
        System.out.println("Element at index 3: " + anArray[3]);
        System.out.println("Element at index 4: " + anArray[4]);
        System.out.println("Element at index 5: " + anArray[5]);
        System.out.println("Element at index 6: " + anArray[6]);
        System.out.println("Element at index 7: " + anArray[7]);
        System.out.println("Element at index 8: " + anArray[8]);
        System.out.println("Element at index 9: " + anArray[9]);

        System.out.println();

        // same thing as above, just written in a loop
        int[] anotherArray = new int[10];
        int assignment = 100;

        for(int i = 0; i < anotherArray.length; i++) {
            anotherArray[i] = assignment;
            System.out.println("Element at index " + i + ": " + anotherArray[i]);
            assignment = assignment + 100;
        }

        System.out.println();

        // with initializer lists
        int[] oneMoreArray = {100, 200, 300, 400, 500, 600, 700, 800, 900, 100};
        System.out.println("The length of the array is " + oneMoreArray.length);

        for(int i = 0; i < anotherArray.length; i++) {
            System.out.println("Element at index " + i + ": " + oneMoreArray[i]);
        }
    }
}
