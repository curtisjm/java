import java.util.Arrays;
import java.util.Scanner;

public class ConcatShortWordsFile {

    // I would have normally done this in multiple methods, but the question only asked for one so I put it all in this one
    public static String concatShortWords() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter some words and enter \"stop\" when you are finished entering words");
        String[] wordsIn = new String[100];
        String output = "";
        int i = 1;

        wordsIn[0] = input.nextLine();
        while(!input.nextLine().equals("stop")) {
            wordsIn[i] = input.nextLine();
            if (wordsIn[i].length() <= 3) {
                output = output.concat(wordsIn[i]);
            }
            i++;
        }
        /*
        boolean stillEntering = true;
        while(stillEntering) {
            String userWord = input.nextLine();
            if(userWord.equals("stop")) {
                stillEntering = false;
            }
            else {
                wordsIn[i] = userWord;
                i++;
                if(wordsIn[i].length() <= 3) {
                    output = output.concat(wordsIn[i]);
                }
            }
        }
*/
        return output;

    }

    public static void main(String[] args) {
        String output = concatShortWords();
        System.out.println(output);
    }
}
