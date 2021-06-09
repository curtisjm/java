package RandNumGenBenLaw;

import java.security.SecureRandom;

public class GenNumsSecureClass {

    public String[] randNums;

    public GenNumsSecureClass(int numCount, int maxValue, int minValue) {
        SecureRandom secureRandom = new SecureRandom();
        randNums = new String[numCount];
        for(int i=0; i<randNums.length; i++) {
            randNums[i] = String.valueOf(secureRandom.nextInt(maxValue) + minValue);
        }
    }
}