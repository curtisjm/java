import java.util.Arrays;

public class FibSeq2 {

    // create array with sequence
    public static int[] fibSeqSeries() {
        int lim = 19;
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
            }

        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        int[] fibSeq = fibSeqSeries();
        sumEvenValues(fibSeq);
    }
}
