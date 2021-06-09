package InterfacesEx;

public class AudioBookItem extends AudioItem {

    private String author;
    private int numChapters;

    public AudioBookItem(String title, double price, int numSeconds, String author, int numChapters) {
        super(title, price, numSeconds);
        this.author = author;
        this.numChapters = numChapters;
    }
    public AudioBookItem(String title, int numSeconds, String author, int numChapters) {
        super(title, numSeconds);
        this.author = author;
        this.numChapters = numChapters;
    }

    public String getAuthor() {
        return author;
    }
    public int getNumChapters() {
        return numChapters;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public void setNumChapters(int numChapters) {
        this.numChapters = numChapters;
    }

    @Override
    public String toString() {
        String parentString = super.toString();
        parentString += "\n\t Author: " + author + "\n\t Chapters: " + numChapters;
        return parentString;
    }

    @Override
    public void playSample() {
        System.out.println("Sampling " + getTitle() + "(1 chapter out of " + numChapters + ")");
    }
}
