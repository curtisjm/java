package GradeBookFiles;

public class GradeBook {

    double[][] gradebook;
    int numStudents, numAssignments;

    // initialize variables in the class
    public GradeBook(int numStud, int numAssign) {
        numStudents = numStud;
        numAssignments = numAssign;

        gradebook = new double[numStudents][numAssignments];
    }

    public String toString() {
        String s = "";
        for(int row=0; row<numStudents; row++) {
            for(int col=0; col<numAssignments; col++) {
                s += gradebook[row][col] + "\t";
            }
            s += "\n";
        }
        return s;
    }

    public int getNumStudents() {
        return numStudents;
    }

    public int getNumAssignments() {
        return numAssignments;
    }

    public boolean enterGrade(int student, int assignment, double grade) {
        if(validStudent(student) && validAssignment(assignment)) {
            gradebook[student][assignment] = grade;
            return true;
        }
        else {
            System.out.println("Invalid index. No changes made.");
            return false;
        }
    }

    public boolean validStudent(int student) {
        return student < numStudents && student >= 0;
    }

    public boolean validAssignment(int assignment) {
        return assignment < numAssignments && assignment >= 0;
    }

    public double calculateWeekAverage(int assignment) {
        if(validAssignment(assignment)) {
            double total = 0;
            for(int i=0; i<numStudents; i++) {
                total += gradebook[i][assignment];
            }
            return total/numStudents;
        }
        else return -1;
    }

    public double calculateStudentAverage(int student) {
        if(validStudent((student))) {
            double[] studentGrades = gradebook[student];
            double total = 0;
            for(double grade : studentGrades) {
               total += grade;
            }
            return total/studentGrades.length;
        }
        else return -1;
    }

}
