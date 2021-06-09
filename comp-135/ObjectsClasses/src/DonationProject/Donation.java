package DonationProject;

public class Donation {

    private double amount;
    private String date;

    private static int donationCount = 0;

    public Donation(double amount, String date) {
        this.amount = amount;
        this.date = date;
        donationCount++;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public static int getDonationCount() {
        return donationCount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String toString() {
        String s = "Amount: $" + amount;
        s += "\nDate: " + date;
        return s;
    }
}