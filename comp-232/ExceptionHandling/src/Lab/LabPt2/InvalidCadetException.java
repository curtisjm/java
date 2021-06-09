package Lab.LabPt2;

public class InvalidCadetException extends Exception {

    public InvalidCadetException() {
        super("Invalid cadet. Must be less than 40 years old and less than 40 pounds.");
    }
    public InvalidCadetException(String message) {
        super(message);
    }
}
