import java.util.ArrayList;
import java.util.Scanner;

public class NewerAdvancedCalculator {

    public static void main(String[] args) {
        String equation = equation();
        ArrayList<Character> operators = operators(equation);
        String[] splitEquation = splitEquation(equation);
        output(operators, splitEquation);
    }

    public static String equation() {
        System.out.println("Enter an equation");
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    public static ArrayList<Character> operators(String equation) {
        ArrayList<Character> operators = new ArrayList<>();
        for (int i = 0; i < equation.length(); i++) {
            if (equation.charAt(i) == '+' || equation.charAt(i) == '-' || equation.charAt(i) == '*' || equation.charAt(i) == '/') {
                operators.add(equation.charAt(i));
            }
        }
        return operators;
    }

    public static int operatorCount(String equation) {
        int operatorCount = 0;
        for (int i = 0; i < equation.length(); i++) {
            if (equation.charAt(i) == '+' || equation.charAt(i) == '-' || equation.charAt(i) == '*' || equation.charAt(i) == '/') {
                operatorCount++;
            }
        }
        return operatorCount;
    }

    public static String[] splitEquation(String equation) {
        return equation.split("\\+|\\-|\\*|\\/", operatorCount(equation) + 1);
    }

    public static void output(ArrayList<Character> operators, String[] splitEquation) {
        int num1 = Integer.parseInt(splitEquation[0]);
        int num2;
        int x = 0;

        for (int i = 1; i < splitEquation.length; i++) {
            num2 = Integer.parseInt(splitEquation[i]);
            char operator = operators.get(x);

            switch (operator) {
                case '*': num1 = num1 * num2;
                    break;
                case '/': num1 = num1 / num2;
                    break;
                case '+': num1 = num1 + num2;
                    break;
                case '-': num1 = num1 - num2;
                    break;
            }
            x++;

        }System.out.println(num1);

    }
}
