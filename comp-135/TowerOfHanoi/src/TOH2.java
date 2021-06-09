import java.util.ArrayList;
import java.util.Scanner;

public class TOH2 {

    public static int diskCount() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of disks");
        int diskCount = input.nextInt();
        while (diskCount <= 0) {
            System.out.println("Enter an integer greater than 0");
            diskCount = input.nextInt();
        }
        return diskCount;
    }

    public static int rodCount() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of rods");
        int rodCount = input.nextInt();
        while (rodCount <= 0) {
            System.out.println("Enter an integer greater than 0");
            rodCount = input.nextInt();
        }
        // validation here
        return rodCount;
    }

    public static void towerCalc(int diskCount, ArrayList<Character> rodLetters, int rodCount, char[] alphabet) {
        char currentRod = rodLetters.get(0);
        char nextRod = rodLetters.get(rodLetters.get(rodLetters.size() - 1));
        char extraRod = rodLetters.get(rodLetters.get(rodLetters.size() - 2));
        if (diskCount > 1) {            // lower number = smaller disk
            towerCalc(diskCount - 1, rodLetters, rodCount, alphabet);
            for (int i = 1; i <= rodLetters.size(); i++) {
                rodLetters.set(i, alphabet[i - 1]);
            }
            System.out.println("Move disk " + diskCount + " from rod " + currentRod + " to rod " + nextRod);
            towerCalc(diskCount - 1, rodLetters, rodCount, alphabet);
            for (int i = 1; i <= rodLetters.size(); i++) {
                rodLetters.set(i, alphabet[i - 1]);
            }
        }
        else {
            System.out.println("Move disk 1 from rod " + currentRod + " to rod " + nextRod);
            System.out.println("else");
        }
    }

    public static char[] alphabet() {
        return new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    }

    public static void rodLetters(ArrayList<Character> rodLetters, int rodCount, char[] alphabet) {
        rodLetters.add('A');
        for (int i = rodCount + 1; i > 0; i--) {
            rodLetters.add(alphabet[i]);
        }
    }

    public static void main(String[] args) {
        int diskCount = diskCount();      // total number of disks, used to display which disk is being moved
        int rodCount = rodCount();
        char[] alphabet = alphabet();
        ArrayList<Character> rodLetters = new ArrayList<>();
        rodLetters(rodLetters, rodCount, alphabet);
        towerCalc(diskCount, rodLetters, rodCount, alphabet);        // name of rods, in order of A, C, B because of order moved
    }

}
