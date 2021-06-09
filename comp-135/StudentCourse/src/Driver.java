public class Driver {

    public static void main(String[] args) {
        Student s1 = new Student("John", "Doe", "1234", true);
        Student s2 = new Student("Steve", "Spargur", "5748", true);
        Student s3 = new Student("Emma", "Stone", "89854", true);
        Student s4 = new Student("Lucy", "McGee", "0932", true);
        Student s5 = new Student("Kaitlyn", "Evans", "0903", true);
        Student s6 = new Student("Chris", "Scott", "2384", true);

        Course c1 = new Course("Intro to Java", 5);
        c1.addStudent(s1);
        c1.addStudent(s2);
        c1.addStudent(s3);
        c1.addStudent(s4);
        c1.addStudent(s5);

        if(!c1.addStudent(s6)) {
            System.out.println("Class is full");
        }

        System.out.println();
        System.out.println(c1);

        c1.dropStudent(s5);

        System.out.println();
        System.out.println(c1);

        c1.addStudent(s6);

        System.out.println();
        System.out.println(c1);
    }
}
