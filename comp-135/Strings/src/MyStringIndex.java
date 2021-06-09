public class MyStringIndex {

    public static void main(String[] args) {
        String myStr = "Welcome to Miami";
        System.out.println(myStr.indexOf('W'));     // given char, tells position of first occurrence
        System.out.println(myStr.indexOf('o'));
        System.out.println(myStr.indexOf('o', 5));      // from fifth position
        System.out.println(myStr.indexOf("come"));
        System.out.println(myStr.indexOf("Miami", 5));
        System.out.println(myStr.indexOf("java", 5));

        System.out.println(myStr.lastIndexOf('W'));     // returns last occurrence
        System.out.println(myStr.lastIndexOf('o'));
        System.out.println(myStr.lastIndexOf('o', 5));
        System.out.println(myStr.lastIndexOf("me"));
    }
}
