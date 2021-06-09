
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the path to your text file: ");
        String filePath = input.nextLine();
        double total = 0, wordCount = 0, average = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line;
            while((line = br.readLine()) != null) {
                String[] scores = line.split(" ");
                for (String score : scores) {
                    total += Double.parseDouble(score);
                    wordCount++;
                }
            }
            average = total / wordCount;
            System.out.println("Total: " + total);
            System.out.println("Average: " + average);
        } catch (FileNotFoundException e) {
            System.out.println("Invalid file path");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
