public class ContinueDemo1 {
    public static void main(String[] args) {

        String searchMe = "peter piper picked a peck of pickled peppers";
        int total = searchMe.length();          // finds length of string
        System.out.println("searchMe is " + total + " characters long");

        int numP = 0;
        for(int i=0; i<total; i++) {
            if(searchMe.charAt(i) != 'p')       // determines characters in string, counts number of p's
                continue;                       // will not count letter if it is not p
            numP++;                             // adds to numP count if letter is a p
        }
        System.out.println("Found " + numP + " p's in this string");
    }
}
