import java.util.ArrayList;
import java.util.Scanner;

public class AdvancedCalculator {

    public static void main(String[] args) {

        System.out.println("Enter an equation");
        Scanner input = new Scanner(System.in);

        String equation = input.next();
        int operatorCount = 0;
        ArrayList<Character> operators = new ArrayList<>();

        for (int i = 0; i < equation.length(); i++) {
            if (equation.charAt(i) == '+' || equation.charAt(i) == '-' || equation.charAt(i) == '*' || equation.charAt(i) == '/') {
                operatorCount++;
                operators.add(equation.charAt(i));
            }
        }
        String[] splitEquation = equation.split("\\+|\\-|\\*|\\/", operatorCount + 1);

        int num1 = Integer.parseInt(splitEquation[0]);
        int num2 = 0;
        int x = 0;
        int result = 0;

        for (int i = 1; i < splitEquation.length; i++) {
            num2 = Integer.parseInt(splitEquation[i]);
            char operator = operators.get(x);

            if (operator == '+') {
                result = num1 + num2;
            } else if (operator == '-') {
                result = num1 - num2;
            } else if (operator == '*') {
                result = num1 * num2;
            } else if (operator == '/') {
                result = num1 / num2;
            }
            x++;
        }
        System.out.println(result);

    }
}
