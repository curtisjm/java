import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class LabExercise {


    public static void main(String[] args) throws IOException {
        File myFile = new File("gettysburg.txt");
        int wordCount = 1;
            try {
                myFile.createNewFile();
                FileWriter fw = new FileWriter(myFile);
                PrintWriter pw = new PrintWriter(fw);
                pw.write("Four score and seven years ago our fathers brought forth on this continent, a new nation, conceived in Liberty, and dedicated to the proposition that all men are created equal.\n" +
                        "\n" +
                        "Now we are engaged in a great civil war, testing whether that nation, or any nation so conceived and dedicated, can long endure. We are met on a great battle-field of that war. We have come to dedicate a portion of that field, as a final resting place for those who here gave their lives that that nation might live. It is altogether fitting and proper that we should do this.\n" +
                        "\n" +
                        "But, in a larger sense, we can not dedicate -- we can not consecrate -- we can not hallow -- this ground. The brave men, living and dead, who struggled here, have consecrated it, far above our poor power to add or detract. The world will little note, nor long remember what we say here, but it can never forget what they did here. It is for us the living, rather, to be dedicated here to the unfinished work which they who fought here have thus far so nobly advanced. It is rather for us to be here dedicated to the great task remaining before us -- that from these honored dead we take increased devotion to that cause for which they gave the last full measure of devotion -- that we here highly resolve that these dead shall not have died in vain -- that this nation, under God, shall have a new birth of freedom -- and that government of the people, by the people, for the people, shall not perish from the earth.");
                pw.close();
                FileReader fr = new FileReader(myFile);
                BufferedReader br = new BufferedReader(fr);
                String line = "";
                while((line = br.readLine()) != null) {
                    for(int i =0; i<line.length(); i++) {
                        if(line.charAt(i) == ' ') {
                            wordCount++;
                        }
                    }
                }
                br.close();
            } catch(IOException ioE) {
                System.out.println(ioE.getMessage());
            } finally {
                System.out.println("Word Count: " + wordCount);
            }
    }
}
// most used word, count of occurances