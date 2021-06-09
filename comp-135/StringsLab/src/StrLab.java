import java.util.Scanner;

public class StrLab {
    public static String methodInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the method you want to implement (length, same, trim, isEmpty, subStr)");
        return input.next();
    }

    public static String stringInput() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string");
        return input.nextLine();
    }

    public static String stringInput2() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a second string");
        return input.nextLine();
    }

    public static void method(String method) {
        switch (method) {
            case "length": length(stringInput());
                break;
            case "same": same(stringInput(), stringInput2());
                break;
            case "trim": trim(stringInput());
                break;
            case "isEmpty": isEmpty(stringInput());
                break;
            case "subStr": subStr(stringInput(), stringInput2());
                break;
        }
    }

    public static void length(String myStr) {
        int count = 0;
        for(char x : myStr.toCharArray()) {
            count++;
        }
        System.out.println("The length of your string is " + count);
    }

    public static void same(String myStr, String myStr2){
        if (myStr.equals(myStr2))
            System.out.println("True");
        else
            System.out.println("False");
    }

    public static void trim(String myStr) {
        while (myStr.lastIndexOf(' ') == myStr.length() - 1) {
            myStr = myStr.substring(0, myStr.length() - 1);
        }
        System.out.println(myStr);
    }

    public static void isEmpty(String myStr){
        if (myStr.length() == 0)
            System.out.println("True");
        else
            System.out.println("False");
    }

    public static void subStr(String myStr, String myStr2){
        if (myStr.indexOf(myStr2) >= 0)
            System.out.println("True");
        else
            System.out.println("False");
    }

    public static void main(String[] args) {
        String method = methodInput();
        method(method);
    }
}
