import java.util.Arrays;
import java.util.Scanner;

public class CardTrick {
    // to keep track of the amount of times the ints are split into groups
    private static int useCount = 0;

    // create an array of ints from 1-21
    // this array could be random, but I left it like this because it's easier to see what is happening in the output
    public static int[] myIntArr() {
        int[] myIntArray = new int [21];
        for(int i=0; i<myIntArray.length; i++) {
            myIntArray[i] = i+1;
        }
        return myIntArray;
    }

    // asks user to make their choice and continue to next method
    public static void start(int[] myInts) {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose and remember a number from the following array:");
        System.out.println(Arrays.toString(myInts));
        System.out.println("Press \"0\" to proceed");
        if(input.next().equals("0")) {
            createPiles(myInts);
        } else {
            System.out.println("Invalid Input");
        }
    }

    public static void createPiles(int [] myInts) {
        // create arrays for each pile of 7
        int[] pile1 = new int[7];
        int[] pile2 = new int[7];
        int[] pile3 = new int[7];
        // used to walk through full array
        int x = 0;
        // distribute into the 7 piles in breadthwise order
        for(int i=0; i<7; i++) {
            pile1[i] = myInts[x];
            pile2[i] = myInts[x+1];
            pile3[i] = myInts[x+2];
            x+=3;
        }
        whichPile(pile1, pile2, pile3);
    }

    public static void whichPile(int[] pile1, int[] pile2, int[] pile3) {
        Scanner input = new Scanner(System.in);
        // user inputs which pile their number is in
        System.out.println("Which group is your number in?");
        System.out.println("Group 1: " + Arrays.toString(pile1));
        System.out.println("Group 2: " + Arrays.toString(pile2));
        System.out.println("Group 3: " + Arrays.toString(pile3));
        System.out.println("Enter \"1\", \"2\", or \"3\"");
        // provides pile to next method
        switch (input.next()) {
            case "1": newIntArr(pile1, pile2, pile3, 1);
                break;
            case "2": newIntArr(pile1, pile2, pile3, 2);
                break;
            case "3": newIntArr(pile1, pile2, pile3, 3);
                break;
        }
    }

    public static void newIntArr(int[] pile1, int[] pile2, int[] pile3, int whichPile) {
        int[] newIntArray = new int [21];
        // puts the smaller arrays back into a larger one, with the pile containing the user's selection in the middle
        switch (whichPile) {
            case 1:
                System.arraycopy(pile2,0,newIntArray,0,7);
                System.arraycopy(pile1,0,newIntArray,7,7);
                System.arraycopy(pile3,0,newIntArray,14,7);
                useCount++;
                break;
            case 2:
                System.arraycopy(pile1,0,newIntArray,0,7);
                System.arraycopy(pile2,0,newIntArray,7,7);
                System.arraycopy(pile3,0,newIntArray,14,7);
                useCount++;
                break;
            case 3:
                System.arraycopy(pile1,0,newIntArray,0,7);
                System.arraycopy(pile3,0,newIntArray,7,7);
                System.arraycopy(pile2,0,newIntArray,14,7);
                useCount++;
                break;
        }
        // makes a guess if the numbers have been sorted three times
        if(useCount == 3) {
            guess(newIntArray);
        } else {
            createPiles(newIntArray);
        }
    }

    public static void guess(int[] intArr) {
        Scanner input = new Scanner(System.in);
        // user's choice will always be 11th from the "top"
        int guess = intArr[10];
        System.out.println("Is your number " + guess + "?");
        System.out.println("Enter \"yes\" or \"no\"");
        String confirm = input.next();
        // lets the user tell us if we got it right
        if(confirm.equals("yes")) {
            System.out.println("Great! Thanks for playing :)");
        } else if(confirm.equals("no")) {
            System.out.println("Well that's awkward...");
        } else {
            System.out.println("Invalid Input");
        }
    }

    public static void main(String[] args) {
        // call myInts in main so we can have a single array to be working off of
        int[] myIntArr = myIntArr();
        // call first method, which other ones will be started from
        start(myIntArr);
    }
}
