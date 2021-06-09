package CommonChars;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Driver {

    private static String commonChars(String s1, String s2) {
        StringBuilder commChars = new StringBuilder();
        HashMap<Character, Integer> charsMap = new HashMap<>();

        for(int i = 0; i < s1.length(); i++) {
            if(!charsMap.containsKey(s1.charAt(i))) {
                charsMap.put(s1.charAt(i), 0);
            }
        }
        for(int i = 0; i < s2.length(); i++) {
            if(charsMap.containsKey(s2.charAt(i))) {
                charsMap.put(s2.charAt(i), 1);
            }
        }
        for(Map.Entry<Character, Integer> entry : charsMap.entrySet()) {
            if(entry.getValue() > 0) {
                commChars.append(entry.getKey());
            }
        }
        return commChars.toString();
    }

    public static void main(String[] args) {
        String s1, s2;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter string 1: ");
        s1 = scan.nextLine();
        System.out.print("Enter string 2: ");
        s2 = scan.nextLine();
        System.out.println("Common characters: " + commonChars(s1, s2));
    }
}
