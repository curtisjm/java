package AudioStore;

public class AudioMain {

    public static void main(String[] args) {
        AudioItem item1 = new AudioItem("Happy",2.99,180);
        System.out.println(item1);
        System.out.println();
        AudioItem item2 = new AudioItem("Java Objects", 59.99, 100845);
        System.out.println(item2);
        System.out.println("Item 1 and item 2 are equal? " + item1.equals(item2));
        System.out.println();

        AudioMusicItem song1 = new AudioMusicItem("Rainbow Song", 2.49, 90, "Ella James", "Children's Music");
        System.out.println(song1);
        System.out.println();

        AudioBookItem book1 = new AudioBookItem("My Book", 99.99, 1200, "John Doe", 10);
        System.out.println(book1);
        System.out.println();

        /*
        AudioItem song2 = new AudioItem("My Song",240);
        System.out.println(song2);

        AudioItem book1 = new AudioItem("Intro to Java", 59.99, 24000);
        System.out.println(book1);

        System.out.println("Number of Audio Items: " + AudioItem.getNumAudioItems());

        AudioStoreAccount myAccount = new AudioStoreAccount("Me", "D123",10);
        System.out.println(myAccount);
        System.out.println(myAccount.getItemsPurchased());

        boolean success = myAccount.purchaseItem(song1);
        if(success) {
            System.out.println(myAccount.getItemsPurchased());
        } else {
            System.out.println("Error in purchase...");
        }

         */
    }
}
