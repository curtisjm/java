import java.util.Arrays;

public class FibSeq {

    // create array with sequence
    public static int[] fibSeqSeries() {
        // change lim to put more values from the sequence in the array
        int lim = 20;
        int[] fibSeq = new int[lim];
        // both first values have to be 1
        fibSeq[0] = 1;
        fibSeq[1] = 1;
        // creates sequence and stores it it fibSeq array
        for(int i = 2; i < lim; i++) {
            fibSeq[i] = fibSeq[i - 1] + fibSeq[i - 2];
        }
        return fibSeq;
    }

    // calculate sum of even values
    public static void sumEvenValues(int[] fibSeq) {
        int sum = 0;
        for(int i = 0; i < fibSeq.length; i++) {
            if(fibSeq[i] % 2 == 0) {
                sum += fibSeq[i];
                    if(sum > 2300) {
                        sum -= fibSeq[i];
                        break;
                    }
                }
            }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        int[] fibSeq = fibSeqSeries();
        System.out.println(Arrays.toString(fibSeq));
        sumEvenValues(fibSeq);
    }
}
