package InClassEmployee;

public abstract class Employee implements Comparable<Employee> {

    private String name, id, phone;
    private Status status;
    public static final String COMPANY_PHONE = "000-000-0000";
    public static final Status DEFAULT_STATUS = Status.FULL_TIME;

    static enum Status {
        FULL_TIME(true,"Full"), PART_TIME(true, "Part"), INACTIVE(false,"Inactive");

        private boolean benefits;
        private String outputText;

        private Status(boolean benefits, String outputText){
            this.benefits = benefits;
            this.outputText = outputText;
        }
        public boolean getBenefits() {
            return this.benefits;
        }
        public String toString() {
            return outputText;
        }
    };

    public Employee(String name, String id, String phone, Status status) {
        this.name = name;
        this.id = id;
        this.phone = phone;
        this.status = status;
    }

    public Employee(String name, String id, Status status) {
        this(name, id, COMPANY_PHONE, status);
    }
    public Employee(String name, String id){
        this(name, id,COMPANY_PHONE, DEFAULT_STATUS);
    }

    public String getName(){
        return name;
    }
    public String getId() {
        return id;
    }
    public String getPhone() {
        return phone;
    }
    public Status getStatus() {
        return status;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setPhone(String phone) {
        this.phone =  phone;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        String s = name + "( " + id + " )";
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Employee) {
            Employee otherEmployee = (Employee) obj;
            return this.name.equalsIgnoreCase(otherEmployee.name) &&
                    this.id.equalsIgnoreCase(otherEmployee.id) &&
                    this.phone.equalsIgnoreCase(otherEmployee.phone) &&
                    this.status.equals(otherEmployee.status);
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Employee otherEmployee) {
        if(name.equalsIgnoreCase(otherEmployee.name)) {
            return id.compareToIgnoreCase(otherEmployee.id);
        } else {
            return name.compareToIgnoreCase(otherEmployee.name);
        }
    }

    public abstract void review();
}
