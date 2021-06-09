package EmployeeParser;

public class Employee {

    private int empID;
    private String firstName;
    private String lastName;
    private int salary;

    public Employee(int empID, String firstName, String lastName, int salary) {
        this.empID = empID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public int getEmpID() {
        return empID;
    }
    public void setEmpID(int empID) {
        this.empID = empID;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        String s = "Name: " + firstName + " " + lastName;
        s += "Employee ID: " + empID;
        s += "Salary: $" + salary;
        return s;
    }
}
