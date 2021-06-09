public class Student {

    private String firstName;
    private String lastName;
    private String id;
    private boolean tuitionPaid;

    public Student(String firstName, String lastName, String id, boolean tuitionPaid) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.tuitionPaid = tuitionPaid;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getId() {
        return id;
    }
    public boolean getTuitionPaid() {
        return tuitionPaid;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setTuitionPaid(boolean tuitionPaid) {
        this.tuitionPaid = tuitionPaid;
    }

    @Override
    public String toString() {
        String s = "Student: " + firstName + " " + lastName;
        s += "\n ID: " + id;
        s += "\n Tuition is paid? " + tuitionPaid;
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Student) {
            Student otherStudent = (Student) obj;
            return this.firstName.equalsIgnoreCase(otherStudent.firstName) &&
                    this.lastName.equalsIgnoreCase(otherStudent.lastName) &&
                    this.id.equalsIgnoreCase(otherStudent.id) &&
                    this.tuitionPaid == otherStudent.tuitionPaid;
        } else {
            return false;
        }
    }
}
