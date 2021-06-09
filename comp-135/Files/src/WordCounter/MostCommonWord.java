package WordCounter;

import java.io.File;

public class MostCommonWord extends File {

    private int totalWords;

    public MostCommonWord(File myFile) {
        super(String.valueOf(myFile));
        totalWords = 1;
    }

}
