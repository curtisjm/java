package IO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class InputOutputPractice {

    public static void main(String[] args) {
        PrintWriter out = null;
        try {
            FileWriter fw = new FileWriter("numbers.txt");
            BufferedWriter br = new BufferedWriter(fw);
            out = new PrintWriter(br);

            Random genreator = new Random();
            int maxNum = 500;
            for(int i = 0; i < 100; i++) {
                int randomNumber = genreator.nextInt(maxNum);
                out.println(randomNumber);
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            if(out != null) {
                out.close();
            }
        }

    }
}
