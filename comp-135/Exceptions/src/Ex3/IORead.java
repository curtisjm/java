package Ex3;

import javax.imageio.IIOException;
import java.io.*;

public class IORead {

    public static void main(String[] args) {
        File ioFile = new File("io.txt");
        // need buffer to read into memory location
        BufferedInputStream bis = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(ioFile);
            bis = new BufferedInputStream(fis);
            // inhale while dats is in the input stream
            while(bis.available() > 0) {
                // do something
                System.out.println((char)bis.read());
            }
            // Would handle exceptions here. That's why you wouldn't always throw exceptions in method signature.
        } catch (IIOException ioE) {
            System.out.println("Something went wrong while performing IO");
        } catch (FileNotFoundException foE) {
            System.out.println("No such file found");
        } catch (Exception e) {
            System.out.println("A generic exception occurred");
        } finally {
            try {
                if(bis != null && fis != null)
                    bis.close();
                    fis.close();
            } catch (IOException ioE) {
                System.out.println("Streams not closable...");
            }
        }
    }
}
