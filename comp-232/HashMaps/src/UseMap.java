
public class UseMap {

    public static void main(String[] args) {
        MyMap<String, String> firstMap = new MyMap<>(3);

        firstMap.put("San Francisco", "Fog");
        firstMap.put("Seattle", "Rain");
        firstMap.put("Los Angeles", "Sun");
        firstMap.put("Miami", "Beach");

        if(firstMap != null) {
            System.out.println("Map is not null " + firstMap.size());
        }
        System.out.println("SF has " + firstMap.get("San Francisco"));
        System.out.println("Seattle has " + firstMap.get("Seattle"));
        System.out.println("LA has " + firstMap.get("Los Angeles"));
        System.out.println("Miami has " + firstMap.get("Miami"));
    }
}
