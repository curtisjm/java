package Bank;

public class BankAccount {

    // instance variables
    private String name;
    private String accountID;
    private double balance;

    // constructor
    public BankAccount(String name, String accountID, double balance) {
        this.name = name;
        this.accountID = accountID;
        this.balance = balance;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public String getAccountID() {
        return accountID;
    }

    public double getBalance() {
        return balance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public void setBalance(double balance) {
        if(balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Invalid Balance");
        }
    }

    // lets user add to their account
    public void deposit(double amount) {
        if(amount >= 0) {
            this.balance += amount;
            System.out.println("You successfully deposited $" + amount);
        } else {
            System.out.println("Invalid Amount");
        }
    }

    // lets user withdraw money from their account as long as they have enough stored
    public void withdraw(double amount) {
        if(amount <= 0) {
            System.out.println("Invalid Amount");
        }
        else if(balance < amount) {
            System.out.println("You don't have enough money in your account to withdraw $" + amount);
        } else {
            this.balance -= amount;
            System.out.println("You successfully withdrew $" + amount);
        }
    }

    // account info to be printed
    @Override
    public String toString() {
        String s = "Name: " + name;
        s += "\nAccount ID: " + accountID;
        s += "\nBalance: $" + balance;
        return s;
    }
}
