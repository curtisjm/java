package EmployeeProject;

public class HourlyPaidEmployee extends Employee {

    private double hourlyRate;

    public HourlyPaidEmployee(String name, String id, String phoneNumber, String status, double hourlyRate) {
        super(name, id, phoneNumber, status);
        this.hourlyRate = hourlyRate;
    }
    public HourlyPaidEmployee(String name, String id, String phoneNumber, double hourlyRate) {
        super(name, id, phoneNumber);
        this.hourlyRate = hourlyRate;
    }
    public HourlyPaidEmployee(String name, String id, double hourlyRate) {
        super(name, id);
        this.hourlyRate = hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        if(hourlyRate >= 0) {
            this.hourlyRate = hourlyRate;
        } else {
            System.out.println("Invalid Hourly Rate Amount");
        }
    }

    @Override
    public String toString() {
        String s = super.toString();
        s += "\n Hourly Rate: $" + hourlyRate;
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof HourlyPaidEmployee) {
            HourlyPaidEmployee otherHourlyPaidEmployee = (HourlyPaidEmployee) obj;
            boolean sameHourlyRate;
            sameHourlyRate = this.hourlyRate == otherHourlyPaidEmployee.hourlyRate;
            // uses super class equals method to check if all instance variables are equal
            return sameHourlyRate && super.equals(obj);
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
