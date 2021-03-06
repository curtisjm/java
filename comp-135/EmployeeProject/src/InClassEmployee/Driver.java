package InClassEmployee;

public class Driver {

    public static void main(String[] args) {

        Employee e1 = new SalariedEmployee("Mark Monies", "A513", 50000);
        Employee e2 = new HourlyPaidEmployee("Hank Hourly", "Z158", 10);
        Employee e3 = new HourlyPaidEmployee("Minnie Minimum", "M531");
        Employee e4 = new UnpaidEmployee("Irvie Intern", "I009");

        int comparisonNumber = e2.compareTo(e4);
        System.out.println("The comparison is " + comparisonNumber);

        Employee[] employees = {e1, e2, e3, e4};
        for(Employee e : employees) {
            e.review();
        }

        for(Employee e : employees) {
            if(e instanceof PaidEmployee) {
                PaidEmployee paidE = (PaidEmployee) e;
                paidE.pay();
            }
        }
    }
}
