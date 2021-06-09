public class Driver {

    public static void main(String[] args) {
        School[] schools = new School[4];
        schools[0] = new School("COM");
        schools[1] = new School("CCSF");
        schools[2] = new HighSchool("Tam", 4);
        schools[3] = new HighSchool("Redwood", 4);

        int hsGradeCount = 0;
        for (School school : schools) {
            System.out.println(school);
            if (school instanceof HighSchool) {
                hsGradeCount += ((HighSchool) school).getNumGrades();
            }
        }
        System.out.println("Total grades in high schools: " + hsGradeCount);
    }
}
