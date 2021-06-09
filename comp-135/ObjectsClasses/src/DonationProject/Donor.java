package DonationProject;

import java.util.ArrayList;

public class Donor {

    private String name;
    private String phoneNumber;
    private ArrayList<Donation> donationsMade;

    public Donor(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        donationsMade = new ArrayList<Donation>();
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ArrayList getDonationsMade() {
        return donationsMade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void makeDonation(double amount, String date){
        Donation newDonation = new Donation(amount, date);
        donationsMade.add(newDonation);
    }

    public void makeDonation(Donation newDonation){
        donationsMade.add(newDonation);
    }

    public String toString() {
        String s = "Name: " + name;
        s += "\nPhone Number: " + phoneNumber;
        s += "\nDonations Made: " + donationsMade.size() + "\n";
        return s;
    }
}