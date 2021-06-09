package RandNumGenBenLaw;

import java.util.Random;

public class GenNumsRandClass {

    public String[] randNums;

    public GenNumsRandClass(int numCount, int maxValue, int minValue) {
        randNums = new String[numCount];
        Random rand = new Random();
        for(int i=0; i<randNums.length; i++) {
            randNums[i] = String.valueOf(rand.nextInt(maxValue) + minValue);
        }
    }
}
