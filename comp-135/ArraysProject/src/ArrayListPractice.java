import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListPractice {

    public static void main(String[] args) {
        arrayListStrings();
    }

    public static void arrayListStrings() {
        Scanner input = new Scanner(System.in);
        ArrayList<String> wordList = new ArrayList<>();
        System.out.println("Enter words. Duplicates will not be stored. Enter \"quit\" to quit");

        boolean stillEntering = true;
        while(stillEntering) {
            String userWord = input.nextLine();
            if(userWord.contentEquals("quit")) {
                stillEntering = false;
            }
            else if(!wordList.contains(userWord)){
                wordList.add(0, userWord);
            }
        }
        System.out.println(wordList);

    }
}
