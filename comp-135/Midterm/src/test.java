import java.util.Scanner;

public class test {

    public static String concatShortWords() {
        // change these values for different word options
        String[] wordsIn =  {"dog", "banana", "bye", "cat", "apple", "an", "hello", "test", "bat"};
        String output = "";

        // adds word to output string if it is less than 4
        for(int i = 0; i < wordsIn.length; i++) {
            if (wordsIn[i].length() <= 3) {
                output = output.concat(wordsIn[i]);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        // calling method
        String output = concatShortWords();
        System.out.println(output);
    }
}
