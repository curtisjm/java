package InClassEmployee;

public class SalariedEmployee extends PaidEmployee {

    private int salary;

    public SalariedEmployee(String name, String id, String phone, Status status, int salary) {
        super(name, id, phone, status);
        this.salary = salary;
    }
    public SalariedEmployee(String name, String id, int salary) {
        this(name, id, Employee.COMPANY_PHONE, Employee.DEFAULT_STATUS, salary);
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if(salary > 0) {
            this.salary = salary;
        }
    }

    @Override
    public String toString() {
        String s = super.toString();
        s += "\n Salary: " + salary;
        return s;
    }

    @Override
    public void pay() {
        System.out.println("Paying salary " + salary + " / 52 weeks.");
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof SalariedEmployee) {
            SalariedEmployee otherEmp = (SalariedEmployee) obj;
            return super.equals(obj) &&
                    this.salary == otherEmp.salary;
        } else {
            return false;
        }
    }

    public void vacation() {
        System.out.println("Processing vacation for... " + getName());
    }
}
