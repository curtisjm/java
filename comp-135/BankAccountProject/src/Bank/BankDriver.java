package Bank;

import java.util.Scanner;

public class BankDriver {

    // creates a user account and returns it to the main method
    // user must fill in parameters for BankAccount class
    public static BankAccount create() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a name for your account");
        String name = input.nextLine();
        System.out.println("Enter an account ID");
        String accountID = input.nextLine();
        System.out.println("How much money would you like to put in your account");
        double balance = input.nextDouble();
        while(balance < 0) {
            System.out.println("Invalid Amount. Enter an amount larger than 0");
            balance = input.nextDouble();
        }
        return new BankAccount(name, accountID, balance);
    }

    // user can make modifications to their account or check their balance as long as they don't enter "quit"
    public static void modify(BankAccount myAccount) {
        Scanner input = new Scanner(System.in);
        String in = "";
        double amount;
        while(!in.equals("quit")) {
            System.out.println("Would you like to make a deposit, withdrawal, check your balance, or quit? Enter \"deposit\" \"withdraw\" \"balance\" or \"quit\"");
            in = input.next();
            // validates inputs
            while(!in.equals("deposit") && !in.equals("withdraw") && !in.equals("balance") && !in.equals("quit")) {
                System.out.println("Invalid Input. Enter \"deposit\" \"withdraw\" \"balance\" or \"quit\"");
                in = input.next();
            }
            switch(in) {
                case "deposit":
                    System.out.println("How much would you like to deposit?");
                    amount = input.nextDouble();
                    myAccount.deposit(amount);
                    break;
                case "withdraw":
                    System.out.println("How much would you like to withdraw?");
                    amount = input.nextDouble();
                    myAccount.withdraw(amount);
                    break;
                case "balance":
                    System.out.println("Your balance is $" + myAccount.getBalance());
            }
        }
        System.out.println("Goodbye. Thank you for visiting our bank!");
    }

    // lets directs user to method to create and account
    // user can choose to quit now or continue to method to modify / view information on their account
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter \"create\" to make an account at our bank");
        String in = input.next();
        while(!in.equals("create")) {
            System.out.println("Invalid Input. Enter \"create\" to make an account");
            in = input.next();
        }
        BankAccount myAccount = create();
        System.out.println("You have successfully created an account!");
        System.out.println("Would you like to quit or modify / get information about your account? Enter \"quit\" or \"modify\"");
        in = input.next();
        // only lets user give valid inputs
        while(!in.equals("modify") && !in.equals("quit")) {
            System.out.println("Invalid Input. Enter \"quit\" or \"modify\"");
            in = input.next();
        } 
        if(in.equals("modify")) {
            modify(myAccount);
        } else {
            System.out.println("Goodbye. Thank you for visiting our bank!");
        }
    }
}
