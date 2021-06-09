import java.io.*;

public class FilesEx1 {

    public static void main(String[] args) {
        File myFile = new File("notes.txt");
        System.out.println(myFile.exists());
            try {
                myFile.createNewFile();
                FileWriter fw = new FileWriter(myFile); // ready to write
                PrintWriter pw = new PrintWriter(fw);   // pw can write now
                pw.write("Around the rugged rock, ran the ragged rascal");
                pw.close(); // always have to close after writing to file

                // read file
                FileReader fr = new FileReader(myFile); // myFile can be replaced by file path
                BufferedReader br = new BufferedReader(fr);
                String line = "";
                // while there are more lines to read in the file
                while((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                br.close();
            } catch(IOException ioE) {
                System.out.println(ioE.getMessage());
            }
    }
}
