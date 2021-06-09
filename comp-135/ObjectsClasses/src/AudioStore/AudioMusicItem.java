package AudioStore;

public class AudioMusicItem extends AudioItem {
    private String artist;
    private String genre;

    public AudioMusicItem(String title, double price, int numSeconds, String artist, String genre) {
        // super calls constructor of parent class
        super(title, price, numSeconds);
        this.artist = artist;
        this.genre = genre;
    }
    public AudioMusicItem(String title, int numSeconds, String artist, String genre) {
        super(title, numSeconds);
        this.artist = artist;
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }
    public String getGenre() {
        return genre;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    // overrides toString in object class and parent class
    @Override
    public String toString() {
        String parentString = super.toString();
        parentString += "\n\t Artist: " + artist + "\n\t Genre: " + genre;
        return parentString;
    }
}
