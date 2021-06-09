package EmployeeProject;

public class SalariedPaidEmployee extends Employee {

    private double annualSalary;

    public SalariedPaidEmployee(String name, String id, String phoneNumber, String status, double annualSalary) {
        super(name, id, phoneNumber, status);
        this.annualSalary = annualSalary;
    }
    public SalariedPaidEmployee(String name, String id, String phoneNumber, double annualSalary) {
        super(name, id, phoneNumber);
        this.annualSalary = annualSalary;
    }
    public SalariedPaidEmployee(String name, String id, double annualSalary) {
        super(name, id);
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        if(annualSalary > 0) {
            this.annualSalary = annualSalary;
        } else {
            System.out.println("Invalid Salary Amount");
        }
    }

    @Override
    public String toString() {
        String s = super.toString();
        s += "\n Annual Salary: $" + annualSalary;
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof SalariedPaidEmployee) {
            SalariedPaidEmployee otherSalariedPaidEmployee = (SalariedPaidEmployee) obj;
            boolean sameAnnualSalary;
            sameAnnualSalary = this.annualSalary == otherSalariedPaidEmployee.annualSalary;
            // uses super class equals method to check if all instance variables are equal
            return sameAnnualSalary && super.equals(obj);
        } else {
            return false;
        }
    }

    @Override
    public void pay() {
        System.out.println("Paying Employee:");
        System.out.println(toString());
    }
}
