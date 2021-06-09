
public class Name implements Comparable<Name> {

    private String name;
    private int numValue;

    public Name(String name) {
        this.name = name;
        numValue = findNumValue();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        updateNumValue();
    }

    public int getNumValue() {
        return numValue;
    }

    private void updateNumValue() {
        this.numValue = findNumValue();
    }

    private int findNumValue() {
        int val = 0;
        for(int i = 0; i < name.length(); i++) {
            val += (name.toLowerCase().charAt(i) - 96);
        }
        return val;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nNumerical Value: " + numValue;
    }

    @Override
    public int compareTo(Name otherName) {
        return this.name.compareTo(otherName.name);
    }

}
