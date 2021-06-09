import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
public class Course {

    private String name;
    private int maxStudents;
    private Student[] roster;
    private int numStudents;

    public Course(String name, int maxStudents) {
        this.name = name;
        this.maxStudents = maxStudents;
        roster = new Student[maxStudents];
        numStudents = 0;
    }

    public String getName() {
        return name;
    }
    public int getMaxStudents() {
        return maxStudents;
    }
    public Student[] getRoster() {
        return roster;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setMaxStudents(int maxStudents) {
        if(maxStudents > 0) {
            this.maxStudents = maxStudents;
        }
    }
    public void setRoster(Student[] roster) {
        if(roster.length <= maxStudents) {
            this.roster = roster;
        }
    }

    @Override
    public String toString() {
        String s = "Name: " + name;
        s += "\n Max Students: " + maxStudents;
        s += "\n Students Enrolled: " + numStudents;
        for (Student student : roster) {
            if (student != null) {
                s += "\n " + student.toString();
            }
        }
        return s;
    }


    public boolean addStudent(Student student) {
        if(numStudents < roster.length && student.getTuitionPaid()) {
            roster[numStudents] = student;
            numStudents++;
            return true;
        } else {
            return false;
        }
    }

    public boolean dropStudent(Student student) {
        boolean onRoster = false;
        List<Student> result = new LinkedList<>();
        for(Student student1 : roster) {
            if (student1.equals(student)) {
                onRoster = true;
                break;
            }
        }
        if(onRoster) {
            for(Student student1 : roster) {
                if(!student.equals(student1)) {
                    result.add(student1);
                }
            }
            result.toArray(roster);
            numStudents--;
            return true;
        } else {
            return false;
        }
    }
}
