package Employee;

public class EmployeeInfo {
    private String employeeName;
    private String employeeID;
    private String employeePhoneNumber;

    public EmployeeInfo(String theEmployeeName, String theEmployeeID, String theEmployeePhoneNumber) {
        employeeName = theEmployeeName;
        employeeID = theEmployeeID;
        employeePhoneNumber = theEmployeePhoneNumber;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    public void setEmployeeName(String newEmployeeName) {
        employeeName = newEmployeeName;
    }

    public void setEmployeeID(String newEmployeeID) {
        employeeID = newEmployeeID;
    }

    public void setEmployeePhoneNumber(String newEmployeePhoneNumber) {
        employeePhoneNumber = newEmployeePhoneNumber;
    }

    public String toString() {
        String s = "Name: " + employeeName;
        s += "\n\t ID: " + employeeID;
        s += "\n\t Phone Number: " + employeePhoneNumber;
        return s;
    }
}