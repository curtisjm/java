package GradeBookFiles;

import GradeBookFiles.GradeBook;

public class tdGradeBookMain {

    public static void main(String[] args) {
        GradeBook mathGrades = new GradeBook(6,10);
        mathGrades.enterGrade(0, 0, 99.5);
        mathGrades.enterGrade(0, 1, 94);
        mathGrades.enterGrade(0, 2, 88);
        mathGrades.enterGrade(0, 3, 96);
        mathGrades.enterGrade(0, 4, 77);
        mathGrades.enterGrade(0, 5, 82.5);
        mathGrades.enterGrade(0, 6, 59.5);
        mathGrades.enterGrade(0, 7, 67.5);
        mathGrades.enterGrade(0, 8, 88.5);
        mathGrades.enterGrade(0, 9, 99.5);
        mathGrades.enterGrade(5, 5, 66.6);
        mathGrades.enterGrade(1, 9, 45.5);
        mathGrades.enterGrade(3, 9, 95.7);

        System.out.println(mathGrades);
        System.out.println(mathGrades.calculateStudentAverage(0));
        System.out.println(mathGrades.calculateWeekAverage(9));
    }

}
