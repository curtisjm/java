package DieProject;

import java.util.Random;

public class Die {
    // characteristics
    private int faceValue;
    public int NUMBER_OF_SIDES = 6;

    // constructor - set up objects by initializing the instance data variables
    public Die() {              // can put parameters inside parentheses
        faceValue = 1;
    }

    // getters & setters
    public int getFaceValue() {
        return faceValue;
    }

    public void setFaceValue(int newFaceValue) {
        // could add if statements to make sure faceValue is not negative or greater than NUMBER_OF_SIDES
        faceValue = newFaceValue;
    }

    // roll once
    public int roll() {
        // randomly select a number between 1-6
        Random rand = new Random();
        faceValue = rand.nextInt(NUMBER_OF_SIDES) + 1;
        return faceValue;
    }

    // if given number of times to roll die as a parameter
    public int roll(int rollCount) {
        // randomly select a number between 1-6
        Random rand = new Random();
        for(int i=1; i<=rollCount; i++) {
            faceValue = rand.nextInt(NUMBER_OF_SIDES) + 1;
        }
        return faceValue;
    }

    // returns textual representation of object
    public String toString() {
        return "The die shows: " + faceValue;
    }
}
