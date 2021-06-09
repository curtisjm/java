
public class PythagoreanTriplet {

    public static void main(String[] args) {
        int num = 1000;
        for(int a = 1; a <= (num / 3); a++) {
            for(int b = (a + 1); b <= (num / 2); b++) {
                int c = num - a - b;
                if(Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c,2)) {
                    System.out.println("a = " + a + ", b = " + b + ", c = " + c);
                    System.out.println("Product abc = " + a*b*c);
                    break;
                }
            }
        }
    }

}
