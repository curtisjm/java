import java.util.ArrayList;
import java.util.Scanner;

public class NewAdvancedCalc {

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

        public static void output( ArrayList<Character> operators, String[] splitEquation) {
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
/*
        public static String operationInput() {
            Scanner input = new Scanner(System.in);
            System.out.println("What operation would you like to do?");
            System.out.println("(Enter +, -, *, /, square, cube, exponent, sqrt, or factorial)");
            return input.next();
        }

        public static double numInput1() {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter your first number");
            return input.nextDouble();
        }

        public static double numInput2() {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter your second number");
            return input.nextDouble();
        }

        public static void output(String operation) {

            switch(operation) {
                case "+":
                    System.out.println("Your answer is " + addition(numInput1(), numInput2()));
                    break;
                case "-":
                    System.out.println("Your answer is " + subtraction(numInput1(), numInput2()));
                    break;
                case "*":
                    System.out.println("Your answer is " + multiplication(numInput1(), numInput2()));
                    break;
                case "/":
                    System.out.println("Your answer is " + division(numInput1(), numInput2()));
                    break;
                case "square":
                    System.out.println("Your answer is " + square(numInput1()));
                    break;
                case "cube":
                    System.out.println("Your answer is " + cube(numInput1()));
                    break;
                case "exponent":
                    System.out.println("Your answer is " + exponent(numInput1(), numInput2()));
                    break;
                case "sqrt":
                    System.out.println("Your answer is " + sqrt(numInput1()));
                    break;
                case "factorial":
                    System.out.println("Your answer is " + factorial(numInput1()));
                    break;

            }
        }


        public static double addition(double num1, double num2) {
            return num1 + num2;
        }

        public static double subtraction(double num1, double num2) {
            return num1 - num2;
        }

        public static double multiplication(double num1, double num2) {
            return num1 * num2;
        }

        public static double division(double num1, double num2) {
            return num1 / num2;
        }

        public static double square(double num1) {
            return num1 * num1;
        }

        public static double cube(double num1) {
            return num1 * num1 * num1;
        }

        public static double exponent(double num1, double num2) {
            return Math.pow(num1,num2);
        }

        public static double sqrt(double num1) {
            return Math.sqrt(num1);
        }

        public static double factorial(double num1) {
            int i ,fact = 1;
            for(i = 1; i <= num1; i++){
                fact = fact * i;
            }
            return fact;
        }
*/
}
