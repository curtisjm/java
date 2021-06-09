package RandNumGenBenLaw;

// Info on Benford's Law: https://www.isaca.org/resources/isaca-journal/past-issues/2011/understanding-and-applying-benfords-law

public class RandNumGenMain {

    public static void main(String[] args) {
        GenNumsRandClass randNumsGen = new GenNumsRandClass(1000000, 10000, 1);
        //GenNumsMathClass randNumsGen = new GenNumsMathClass(1000000, 10000, 1);
        //GenNumsSecureClass randNumsGen = new GenNumsSecureClass(1000000, 10000, 1);
        //MyRandNumGen randNumsGen = new MyRandNumGen(1000000, 10000, 1);
        String[] randNums = randNumsGen.randNums;
        TestBenfordsLaw testBenfordsLaw = new TestBenfordsLaw(randNums);
        System.out.println(testBenfordsLaw);
    }
}
