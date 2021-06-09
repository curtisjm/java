package CustomerProject;

public class PreferredCustomer extends Customer {

    private int yearsCustomer;

    public PreferredCustomer(String name, String id, Address address, int yearsCustomer) {
        super(name, id, address);
        this.yearsCustomer = yearsCustomer;
    }

    public int getYearsCustomer() {
        return yearsCustomer;
    }

    public void setYearsCustomer(int yearsCustomer) {
        if(yearsCustomer >= 0) {
            this.yearsCustomer = yearsCustomer;
        }
    }

    @Override
    public String toString() {
        String s = super.toString();
        s += "\n Years As a Customer: " + yearsCustomer;
        return s;
    }
}
