package InClassEmployee;

public abstract class PaidEmployee extends Employee {

    public PaidEmployee(String name, String id, String phone, Status status) {
        super(name, id, phone, status);
    }

    public void benefits() {
        if(getStatus().getBenefits()) {
            System.out.println("Processing benefits for " + getName());
        } else {
            System.out.println("This employee employee does not receive benefits");
        }
    }

    @Override
    public void review() {
        System.out.println("Conducting review of... " + getName());
    }

    public abstract void pay();
}
