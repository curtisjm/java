package CustomerProject;

public class Customer {

    private String name;
    private String id;
    private Address address;

    public Customer(String name, String id, Address address) {
        this.name = name;
        this.id = id;
        this.address = address;
    }

    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public Address getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        String s = "Name: " + name;
        s += "\n ID: " + id;
        s += "\n Address: " + address;
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Customer) {
            Customer otherCustomer = (Customer) obj;
            boolean sameName, sameID, sameAddress;
            sameName = this.name.equalsIgnoreCase(otherCustomer.name);
            sameID = this.id.equals(otherCustomer.id);
            sameAddress = this.address.equals(otherCustomer.address);
            return sameName && sameID && sameAddress;
        } else {
            return false;
        }
    }

    public void inviteSale() {
        System.out.println("To " + name + " at " + address + "...");
        System.out.println("There is a sale for 15% off select products! Come by our store in the next 14 days to take advantage of this limited time discount.");
    }

    public void birthdayReward() {
        System.out.println("Happy Birthday " + name + "!");
        System.out.println("Here is a coupon for 5% off your next purchase :)");
    }
}
