package InterfacesEx;

public abstract class AudioItem implements Downloadable, Comparable<AudioItem> {

    private String title;
    private double price;
    private int numSeconds;

    private static int numAudioItems = 0;
    private static final double DEFAULT_PRICE = 0.99;

    public AudioItem(String title, double price, int numSeconds) {
        this.title = title;
        this.price = price;
        this.numSeconds = numSeconds;
        numAudioItems++;
    }
    public AudioItem(String title, int numSeconds) {
        this(title, DEFAULT_PRICE, numSeconds);
    }

    public String getTitle() {
        return this.title;
    }
    public double getPrice() {
        return this.price;
    }
    public int getNumSeconds() {
        return this.numSeconds;
    }
    public static int getNumAudioItems() {
        return numAudioItems;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setPrice(double price) {
        if(price >= 0) {
            this.price = price;
        }
    }
    public void setNumSeconds(int numSeconds) {
        if(numSeconds > 0) {
            this.numSeconds = numSeconds;
        }
    }

    @Override
    public String toString() {
        String s = "Title: " + this.title;
        s += "\n\t Price: $" + this.price;
        s += "\n\t Duration: " + this.numSeconds + " seconds";
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof AudioItem){
            AudioItem otherAudioItem = (AudioItem) obj;
            boolean sameTitle, samePrice, sameDuration;
            sameTitle = this.title.equalsIgnoreCase(otherAudioItem.title);
            sameDuration = this.numSeconds == otherAudioItem.numSeconds;
            samePrice = Math.abs(this.price - otherAudioItem.price) < 0.0001;
            return sameTitle && sameDuration && samePrice;
        } else {
            return false;
        }
    }

    public abstract void playSample();

    @Override
    public void download() {
        System.out.println("\nDownloading " + title + " ...");
    }

    @Override
    public int compareTo(AudioItem otherItem) {
        if(title.equalsIgnoreCase(otherItem.title)) {
            if(price < otherItem.price) {
                return -1;
            } else if (price > otherItem.price) {
                return 1;
            }
            else return 0;
        }
        else {
            return title.compareToIgnoreCase(otherItem.title);
        }
    }
}
