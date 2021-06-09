package CustomerProject;

public class Driver {

    public static void main(String[] args) {
        Address[] addresses = new Address[4];
        for(int i=0; i<addresses.length; i++) {
            addresses[i] = new Address(Integer.toString(1600 + i), "Amphitheatre Parkway", "Mountain View", "CA", "00000");
        }

        Customer[] customers = new Customer[4];
        customers[0] = new Customer("John Doe", "1234", addresses[0]);
        customers[1] = new PreferredCustomer("Someone", "5678", addresses[1], 10);
        customers[2] = new Customer("Another Person", "1234", addresses[2]);
        customers[3] = new PreferredCustomer("This Guy", "9000", addresses[3], 15);

        int totalYears = 0;
        for(int i=0; i<customers.length; i++) {
            System.out.println(customers[i]);
            System.out.println();
            customers[i].inviteSale();
            customers[i].birthdayReward();
            System.out.println("\n");
            if(customers[i] instanceof PreferredCustomer) {
                totalYears += ((PreferredCustomer) customers[i]).getYearsCustomer();
            }
        }
        System.out.println("Total years of all preferred customers: " + totalYears);
    }
}
