package AudioStore;

public class AudioItem {
    // instance data variable
    private String title;
    private double price;
    private int numSeconds;

    // static class variables - shared among all objects because it's static
    private static int numAudioItems = 0;

    // constant default price
    private static final double DEFAULT_PRICE = 0.99;

    // constructor
    public AudioItem(String title, double price, int numSeconds) {
        // use this if the same keywords are being used
        this.title = title;
        this.price = price;
        this.numSeconds = numSeconds;
        numAudioItems++;
    }

    // constructor 2 : overloading a constructor (changing its signature / number of parameters)
    public AudioItem(String title, int numSeconds) {
        // passing inputs to other constructor
        this(title, DEFAULT_PRICE, numSeconds);
    }

    // getters and setters
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
        // have some validation
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

    // override overrides default method in object class. Not necessary to use anymore
    @Override
    // text representation of our AudioItem
    public String toString() {
        String s = "Title: " + this.title;
        s += "\n\t Price: $" + this.price;
        s += "\n\t Duration: " + this.numSeconds + " seconds";
        return s;
    }

    public void playSample() {
        System.out.println("Sampling... " + title + "5 seconds out of " + numSeconds);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof AudioItem){
            AudioItem otherAudioItem = (AudioItem) obj;
            boolean sameTitle, samePrice, sameDuration;

            if(this.title.equalsIgnoreCase(otherAudioItem.title)) {
                sameTitle = true;
            } else {
                sameTitle = false;
            }
            if(this.numSeconds == otherAudioItem.numSeconds) {
                sameDuration = true;
            }
            else {
                sameDuration = false;
            }
            if(Math.abs(this.price - otherAudioItem.price) < 0.0001) {
                samePrice = true;
            }
            else {
                samePrice = false;
            }
            return sameTitle && sameDuration && samePrice;
        }
        else {
            return false;
        }
    }
}