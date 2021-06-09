public class GradeBook {
    
    public static char printGrade(double score) {
        char grade;
        if (score >= 90)
            grade = 'A';
        else if (score >= 80)
            grade = 'B';
        else if (score >= 70)
            grade = 'C';
        else if (score >= 60)
            grade = 'D';
        else
            grade = 'F';
        return grade;
    }

    public static void main(String[] args) {
        System.out.println(printGrade(78));
    }
}
