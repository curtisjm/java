package Lab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class HashtagDriver {

    public static void main(String[] args) {
        HashMap<String, Integer> myMap = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("KatyPerryTweets.txt"));
            String line;
            while((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, " ");
                while(st.hasMoreTokens()) {
                    String tmpStr = st.nextToken();
                    if(tmpStr.startsWith("#")) {
                        tmpStr = tmpStr.replaceAll("\\s", "");
                        if(myMap.containsKey(tmpStr)) {
                            int hashtagCount = myMap.get(tmpStr);
                            hashtagCount++;
                            myMap.put(tmpStr, hashtagCount);
                        } else {
                            myMap.put(tmpStr, 1);
                        }
                    }
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Map.Entry<String, Integer>> sortList = new LinkedList<>(myMap.entrySet());
        sortList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue().compareTo(o1.getValue()));
            }
        });

        System.out.println("--- Hashtags in order of usage ---");
        for(Map.Entry<String, Integer> x : sortList) {
            System.out.println(x.getKey() + ": " + x.getValue());
        }
    }
}
