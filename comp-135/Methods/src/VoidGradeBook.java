public class VoidGradeBook {

    public static void printGrade(double score) {       // void does not return anything, all done within the method
        if (score >= 90)
            System.out.println('A');
        else if (score >= 80)
            System.out.println('B');
        else if (score >= 70)
            System.out.println('C');
        else if (score >= 60)
            System.out.println('D');
        else
            System.out.println('F');
    }

    public static void main(String[] args) {

        printGrade(92.5);
    }
}
