package RandNumGenBenLaw;

public class GenNumsMathClass {

    public String[] randNums;

    public GenNumsMathClass(int numCount, int maxValue, int minValue) {
        randNums = new String[numCount];
        for(int i=0; i<randNums.length; i++) {
            int rand = (int) (Math.random() * maxValue - minValue + 1) + minValue;
            randNums[i] = String.valueOf(rand);
        }
    }
}