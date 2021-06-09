package EmployeeProject;

public class PhoneNumber {

    // this class will store the phone numbers given in the driver class or provide a default phone number if not given as a parameter
    private String number;

    private static final String DEFAULT_NUMBER = "000-000-0000";

    public PhoneNumber() {
        this.number = DEFAULT_NUMBER;
    }
    public PhoneNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
}
