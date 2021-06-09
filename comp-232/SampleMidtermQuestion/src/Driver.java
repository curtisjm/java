import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Driver {

    private static final String COMMA_DELIMITER = ",";
    private static ArrayList<Name> names = new ArrayList<>();

    private static void readFile() {
        String line = "";
        String tmpName = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader("names.txt"));
            StringTokenizer st;
            while((line = br.readLine()) != null) {
                st = new StringTokenizer(line, COMMA_DELIMITER);
                while(st.hasMoreTokens()) {
                    tmpName = st.nextToken().replaceAll("\"", "");
                    names.add(new Name(tmpName));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sortNames() {
        Collections.sort(names);
    }

    private static void printNames() {
        for(Name n : names) {
            System.out.println(n);
        }
    }

    private static long findTotalScore() {
        long totalScore = 0;
        for(int i = 0; i < names.size(); i++) {
            totalScore += ((i + 1) * names.get(i).getNumValue());
        }
        return totalScore;
    }

    public static void main(String[] args) {
        readFile();
        sortNames();
        //printNames();
        System.out.println("Total score: " + findTotalScore());
    }

}
