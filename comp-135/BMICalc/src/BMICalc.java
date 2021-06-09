import java.util.Scanner;

public class BMICalc {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter your height in meters");
        double height = input.nextDouble();
        System.out.println("Enter your weight in kilograms");
        double weight = input.nextDouble();

        double bmi = weight / (height * height);

        if (bmi < 18.5){
            System.out.println("You are underweight");
        }
        if ((18.5 <= bmi) &&(bmi < 25)) {
            System.out.println("You are normal");
        }
        if ((25 <= bmi) &&(bmi < 30)) {
            System.out.println("You are overweight");
        }
        if (30 <= bmi) {
            System.out.println("You are obese");
        }

    }
}
