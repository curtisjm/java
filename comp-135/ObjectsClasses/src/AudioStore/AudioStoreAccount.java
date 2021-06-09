package AudioStore;

import java.util.ArrayList;

public class AudioStoreAccount {
    private String name, accountID;
    private double balance;
    private ArrayList<AudioItem> itemsPurchased;

    public static final double DEFAULT_INITIAL_BALANCE = 0;

    public AudioStoreAccount(String name, String accountID, double balance) {
        this.name = name;
        this.accountID = accountID;
        this.balance = balance;
        itemsPurchased = new ArrayList<AudioItem>();
    }

    public AudioStoreAccount(String name, String accountID) {
        this(name, accountID, DEFAULT_INITIAL_BALANCE);
    }

    public String getName() {
        return name;
    }

    public String getAccountID() {
        return accountID;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList getItemsPurchased() {
        return itemsPurchased;
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
        }
    }

    public boolean purchaseItem(AudioItem newItem){
        double price = newItem.getPrice();
        if(balance >= price) {
            itemsPurchased.add(newItem);
            balance = balance - price;
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        String s = "Name: " + name + " (" + accountID + ")";
        s += "\n\tBalance: " + balance;
        s += "\n\tItems Purchased: " + itemsPurchased.size();
        return s;
    }
}