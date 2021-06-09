package Ex3;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;

public class IOOperations {

    public static void main(String[] args) throws IOException {
        try {
            File myFile = new File("io.txt");
            boolean done = myFile.createNewFile();
            if(done) {
                System.out.println("File created successfully");
            } else {
                System.out.println("File already present at the specified location");
            }
        } catch (IIOException ioE) {
            System.out.println("Something went wrong while trying to create a file");
            // Ex: Could not make a file locally, so lets try plan B. Let's make it on AWS S3.
        }
    }
}
