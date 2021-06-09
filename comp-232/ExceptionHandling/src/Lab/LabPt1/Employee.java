package Lab.LabPt1;

public class Employee {

    private String name;
    private String phoneNumber;
    private int age;

    public Employee(String name, String phoneNumber, int age) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        try {
            if(age > 0) {
                this.age = age;
            } else {
                throw new InvalidEmployeeAgeException();
            }
        } catch(InvalidEmployeeAgeException e) {
            System.out.println("Age must be a positive number.");
        }
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "\nPhone Number: " + phoneNumber +
                "\nAge: " + age;
    }
}
