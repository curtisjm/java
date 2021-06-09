import java.util.Arrays;

public class HashFunction {

    String[] theArray;
    int arraySize;
    int itemsInArray = 0;

    public static void main(String[] args) {

        HashFunction theFunc = new HashFunction(30);
        String[] elementsToAdd = {"1", "5", "17", "21", "26"};

        theFunc.hashFunction1(elementsToAdd, theFunc.theArray);

        // https://www.youtube.com/watch?v=B4vqVDeERhI
    }


    public void hashFunction1(String[] stringsForArray, String[] array) {

        for (int n= 0; n < stringsForArray.length; n++) {

            String newElementVal = stringsForArray[n];

            array[Integer.parseInt(newElementVal)] = newElementVal;

        }
    }

    HashFunction(int size) {

        arraySize = size;
        theArray = new String[size];
        Arrays.fill(theArray, "-1");
    }
}