import java.util.Scanner;

public class AO {

    public static void main(String[] args) {
        int count;
        String temp;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of strings you want to enter");
        count = input.nextInt() + 1;
        String[] text = new String[count];
        System.out.println("Enter your strings");
        for(int i=0; i<count; i++) {
            text[i] = input.nextLine();
        }
        for (int i=0; i<count; i++) {
            for (int j=i+1; j<count; j++) {
                if (text[i].compareTo(text[j])>0) {
                    temp = text[i];
                    text[i] = text[j];
                    text[j] = temp;
                }
            }
        }
        for (int i=0; i<count-1; i++) {
            System.out.println(text[i] + "\n");
        }
        System.out.print(text[count-1] + "\n");
    }
}
