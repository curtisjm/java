package EmployeeProject;

public class Employee {

    // instance variables
    private String name;
    private String id;
    private String phoneNumber;
    private String status;

    // use if status parameter not given
    private static final String DEFAULT_STATUS = "Full-Time";

    // if all instance variables are given
    public Employee(String name, String id, String phoneNumber, String status) {
        this.name = name;
        this.id = id;
        PhoneNumber num = new PhoneNumber(phoneNumber);
        this.phoneNumber = num.getNumber();
        this.status = status;
    }
    // if status not given
    public Employee(String name, String id, String phoneNumber) {
        this(name, id, phoneNumber, DEFAULT_STATUS);
    }
    // only given name and ID
    // takes advantage of default phone number in PhoneNumber class
    public Employee(String name, String id) {
        PhoneNumber num = new PhoneNumber();
        this.name = name;
        this.id = id;
        this.status = DEFAULT_STATUS;
        this.phoneNumber = num.getNumber();
    }

    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public void setStatus(String status) {
        if(status.equals("Full-Time") || status.equals("Part-Time") || status.equals("Inactive")) {
            this.status = status;
        } else {
            System.out.println("Invalid Status");
        }
    }

    @Override
    public String toString() {
        String s = "Name: " + name;
        s += "\n ID: " + id;
        s += "\n Phone Number: " + phoneNumber;
        s += "\n Status: " + status;
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Employee) {
            Employee otherEmployee = (Employee) obj;
            boolean sameName, sameID, samePhoneNumber, sameStatus;
            sameName = this.name.equalsIgnoreCase(otherEmployee.name);
            sameID = this.id.equalsIgnoreCase(otherEmployee.id);
            samePhoneNumber = this.phoneNumber.equalsIgnoreCase(otherEmployee.phoneNumber);
            sameStatus = this.status.equalsIgnoreCase(otherEmployee.status);
            return sameName && sameID && samePhoneNumber && sameStatus;
        } else {
            return false;
        }
    }

    public void pay() {
        System.out.println("Paying Employee: ");
        System.out.println(toString());
    }
}
