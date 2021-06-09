package GenericsEx;

public class Driver {

    public static <T extends Comparable<T> > T maximum(T x,T y, T z) {
        // assume x is max
        T max = x;
        // compareTo returns something greater than 0 if true
        if(y.compareTo(max) > 0) {
            max = y;
        }
        if(z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.printf("Max of %d %d & %d is %d \n", 3, 4, 5, maximum(3,4,5));
        System.out.printf("Max of %f %f & %f is %f \n", 3.3, 4.4, 5.5, maximum(3.3,4.4,5.5));
        System.out.printf("Max of %s %s & %s is %s \n", "pear", "apple", "orange", maximum("pear", "apple", "orange"));
    }

}
