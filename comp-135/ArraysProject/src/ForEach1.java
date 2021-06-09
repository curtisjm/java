public class ForEach1 {

    public static void main(String[] args) {
        int[] myArray = {100, 200, 300, 400, 500};
        for (int eachItem: myArray) {
            System.out.println(eachItem);
        }

        String[] names = {"San Francisco", "Marin", "Kentfield", "Sausalito"};
        for (String city : names) {
            System.out.println(city);
        }
    }
}
