package InterfacesEx;

import java.util.ArrayList;
import java.util.Collections;

public class Driver {

    public static void main(String[] args) {
        ArrayList<AudioItem> itemList = new ArrayList<>();
        itemList.add(new AudioMusicItem("Piano Man", 240, "Billy Joel", "Singalong"));
        itemList.add(new AudioBookItem("Harry Potter Complete Collection", 240.99, 417600, "J.K. Rowling", 198));
        itemList.add(new AudioMusicItem("Don't Stop Believing", 0.49, 185, "Journey", "Rock"));
        itemList.add(new AudioMusicItem("I Want to Hold Your Hand", 1.29, 158, "Beatles", "Classic"));
        itemList.add(new AudioBookItem("Watership Down", 20.99, 54000, "Richard Adams", 47));
        itemList.add(new AudioMusicItem("I Will Always Love You", 0.49, 173, "Dolly Parton", "Country"));
        itemList.add(new AudioMusicItem("I Will Always Love You", 173, "Whitney Houston", "Country"));

        // needs compareTo in order to work
        Collections.sort(itemList);

        for(AudioItem item : itemList) {
            System.out.println(item.getTitle() + " Price: " + item.getPrice());
        }
        for(AudioItem item : itemList) {
            item.playSample();
        }
    }
}
