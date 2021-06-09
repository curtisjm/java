package WordCounter;

import java.io.*;

public class CountTotalWords {

    private File myFile;

    public CountTotalWords(File myFile) {
        this.myFile = myFile;
    }

    public File getMyFile() {
        return myFile;
    }

    public void setMyFile(File myFile) {
        this.myFile = myFile;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        try {
            FileReader fr = new FileReader(myFile);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                s.append(line).append("\n");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s.toString();
    }

    public int countTotalWords () throws IOException {
        String[] words;
        int wordCount = 0;
        FileReader fr = new FileReader(myFile);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while((line = br.readLine()) != null) {
            words = line.split(" ");
            wordCount += words.length;
        }
        br.close();
        return wordCount;
    }
}