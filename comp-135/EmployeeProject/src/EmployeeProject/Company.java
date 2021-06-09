package EmployeeProject;

public class Company {

    public static void main(String[] args) {

        // create employee objects
        Employee e1 = new Employee("Wally Worker", "W157", "555-555-5555");
        Employee e2 = new Employee("Sam Slacker", "A872", "555-555-5555", "Inactive");

        SalariedPaidEmployee s1 = new SalariedPaidEmployee("Mark Monies", "M513", 50000);
        HourlyPaidEmployee h1 = new HourlyPaidEmployee("Hank Hourly", "H158", 10);
        HourlyPaidEmployee h2 = new HourlyPaidEmployee("Minnie Minimum", "M531", 10);

        // test getters and setters
        h1.setPhoneNumber("111-222-3333");
        h2.setHourlyRate(15);

        double s1AnnualSalary = s1.getAnnualSalary();
        System.out.println("s1 Annual Salary test: $" + s1AnnualSalary);

        // test toString methods
        System.out.println(e1);
        System.out.println();
        System.out.println(e2);
        System.out.println();
        System.out.println(s1);
        System.out.println();
        System.out.println(h1);
        System.out.println();

        // test pay method
        e1.pay();

        //test equals methods
        System.out.println();
        System.out.println("Equality of h1 and h2: " + h1.equals(h2));
    }
}
