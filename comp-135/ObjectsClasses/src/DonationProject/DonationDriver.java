package DonationProject;

public class DonationDriver {

    public static void main(String[] args) {
        Donor me = new Donor("Me", "4151112222");
        me.makeDonation(50000, "11/2/20");

        Donation myDonation = new Donation(20000, "10/30/20");
        me.makeDonation(myDonation);

        System.out.println(me);
    }
}
