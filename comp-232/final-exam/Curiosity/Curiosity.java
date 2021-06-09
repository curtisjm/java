
// What value is returned for the call curiosity(6, 3)? --> 18
// What function does curiosity() compute for positive n and m? --> multiplication

public class Curiosity {

    public static int curiosity(int n, int m) {
        if (m <= 0) return 0;
        else return n + curiosity(n, m - 1);
    }

    public static void main(String[] args) {
        System.out.println(curiosity(6, 3));
    }
}
