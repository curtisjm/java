import java.util.Arrays;
import java.util.Scanner;

public class LoanApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter the number of years you will have your loan");
        int numberOfYears = input.nextInt();

        System.out.println("Enter loan amount");
        double loanAmount = input.nextDouble();

        for(double annualInterestRate = 5; annualInterestRate <= 8; annualInterestRate += 0.125) {
            double monthlyInterestRate = annualInterestRate / 1200;
            double monthlyPayment = loanAmount * monthlyInterestRate / (1 - 1/Math.pow(1+monthlyInterestRate, numberOfYears * 12));
            double totalPayment = monthlyPayment * numberOfYears * 12;


        }

/*
        double monthlyPayment = loanAmount * monthlyInterestRate / (1 - 1/Math.pow(1+monthlyInterestRate, numberOfYears * 12));

        double totalPayment = monthlyPayment * numberOfYears * 12;

        System.out.println("The monthly payment is: $" + (int)(monthlyPayment * 100)/100.0);
        System.out.println("The total payment is: $" + (int)(totalPayment * 100)/100.0);

*/
    }


}

