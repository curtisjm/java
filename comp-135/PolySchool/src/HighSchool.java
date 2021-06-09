public class HighSchool extends School implements Comparable<HighSchool> {

    private String name;
    private int numGrades;

    public HighSchool() {
        super();
        numGrades = 4;
    }
    public HighSchool(String name, int numGrades) {
        super(name);
        this.numGrades = numGrades;
    }

    public int getNumGrades() {
        return numGrades;
    }
    public void setNumGrades(int numGrades) {
        if(numGrades > 0) {
            this.numGrades = numGrades;
        }
    }

    @Override
    public String toString() {
        String s = super.toString();
        s += "\n Grades: " + numGrades;
        return s;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof HighSchool) {
            HighSchool otherHS = (HighSchool) obj;
            return this.name.equalsIgnoreCase(otherHS.name) &&
                    this.numGrades == otherHS.numGrades;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(HighSchool otherHS) {
        if(name.equalsIgnoreCase(otherHS.name)) {
            return Integer.compare(numGrades, otherHS.numGrades);
        } else {
            return name.compareToIgnoreCase(otherHS.name);
        }
    }
}
