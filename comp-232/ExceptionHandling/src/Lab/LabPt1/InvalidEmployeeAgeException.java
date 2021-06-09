package Lab.LabPt1;
public class InvalidEmployeeAgeException extends Exception {

    public InvalidEmployeeAgeException() {
        super("Invalid employee age. Must be a positive number.");
    }
    public InvalidEmployeeAgeException(String message) {
        super(message);
    }
}
