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

    // getters
    public String getName() {
        return name;
    }
    public String getAccountID() {
        return accountID;
    }
    public double getBalance() {
        return balance;
    }

    // setters
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
            System.out.println("Invalid balance.");
        }
    }

    public void deposit(double amount) {
        if(amount >= 0) {
            // x += y -----> x = x + y
            this.balance += amount;
            System.out.println("You have successfully deposited $" + amount);
        } else {
            System.out.println("Invalid amount");
        }
    }

    public void withdraw(double amount) {
        if(amount <=0) {
            System.out.println("Invalid amount");
        } else if(balance < amount) {
            System.out.println("You don't have enough money in your account to withdraw $" + amount);
        } else {
            this.balance -= amount;
            System.out.println("You successfully withdrew $" + amount);
        }
    }

    // allows user to print class info
    @Override
    public String toString() {
        String s = "Name: " + name;
        s += "\nAccount ID: " + accountID;
        s += "\nBalance $" + balance;
        return s;
    }
}
